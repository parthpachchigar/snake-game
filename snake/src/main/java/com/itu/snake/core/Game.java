package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;
import com.itu.snake.enums.GameStatus;
import com.itu.snake.game.GameStats;
import com.itu.snake.tiles.Food;
import com.itu.snake.tiles.SnakeBody;
import com.itu.snake.ui.Board;
import com.itu.snake.tiles.Cell;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game implements KeyListener {

  private static Board board;
  private static Snake snake;

  private int rows;
  private int columns;
  private int headRow;
  private int headCol;
  //private Snake snake;
  private Food foodCell;
  private Sound backgroundSound;
  private boolean directionSet;

  public Game(int rows, int columns, int headRow, int headCol) {
    this.rows = rows;
    this.columns = columns;
    this.headRow = headRow;
    this.headCol = headCol;
    this.backgroundSound = new Sound("background.wav");
    this.backgroundSound.setLoop();
    this.backgroundSound.stopSound();
    this.directionSet = false;
    this.startNewGame();
  }

  public void startNewGame() {
    board = new Board(rows, columns);
    snake = new Snake(this.headRow, this.headCol);

    GameStats.init();
    board.updateStatus();
    board.addKeyboardListener(this);

    List<SnakeBody> bodies = snake.getBodies();
    updateBoard(bodies);

    this.applyFood();
    //backgroundSound.playSound();
    this.run();
  }

  public boolean setDirection(Direction direction) {
    return snake.setDirection(direction);
  }

  public void takeStep() {
    if (GameStats.getStatus() == GameStatus.OVER || GameStats.getStatus() == GameStatus.PAUSED) {
      if (backgroundSound.isActive()) {
        backgroundSound.stopSound();
      }
      return;
    }
    if (!backgroundSound.isActive()) {
      backgroundSound.playSound();
    }
    Cell nextSnakeHead = snake.attemptMove();
    if (board.getCell(nextSnakeHead.getRowIndex(), nextSnakeHead.getColumnIndex()).getType() == CellType.FOOD) {
      updateBoard(snake.eat(foodCell));
      GameStats.increaseScore();
      new Sound("eat.wav").playSound();
      this.applyFood();
    } else if (!isGameOver(nextSnakeHead)) {
      updateBoard(snake.moveForward());
    } else {
      GameStats.setStatus(GameStatus.OVER);
      backgroundSound.stopSound();
      new Sound("game_over.wav").playSound();
    }
  }

  private void applyFood() {
    this.foodCell = generateFood();
    Cell boardCellForFood = board.getCell(this.foodCell.getRowIndex(), this.foodCell.getColumnIndex());
    boardCellForFood.setIconImg(this.foodCell
        .getIcon());
    boardCellForFood.setType(CellType.FOOD);
    boardCellForFood.setIconOrBackground();
  }

  private Food generateFood() {
    Random random = new Random();
    int foodRow = random.nextInt(rows);
    int foodCol = random.nextInt(columns);
    if (board.getCell(foodRow, foodCol).getType() == CellType.EMPTY) {
      return new Food(foodRow, foodCol);
    }
    return generateFood();
  }

  private boolean isGameOver(Cell nextMove) {
      if (nextMove.getRowIndex() >= this.rows || nextMove.getColumnIndex() >= this.columns || nextMove.getRowIndex() < 0 || nextMove.getColumnIndex() < 0) {
          return true;
      }
      return nextMove.getType() == CellType.SNAKE_BODY
          || nextMove.getType() == CellType.SNAKE_TAIL;
  }

  private void updateBoard(List<? extends Cell> updatedCells) {
    for (Cell updatedCell : updatedCells) {
      Cell cell = board.getCell(updatedCell.getRowIndex(), updatedCell.getColumnIndex());
      cell.setIconImg(updatedCell.getIconImg());
      cell.setType(updatedCell.getType());
      cell.setIconOrBackground();
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // empty
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    char ch = e.getKeyChar();
    if (ch == 'a') {
      this.startNewGame();
    } else if (ch == 'f') {
      GameStats.increaseSpeed();
    } else if (ch == 's') {
      GameStats.decreaseSpeed();
    } else if (ch == 'p') {
      GameStats.setStatus(GameStatus.PAUSED);
    } else if (ch == 'r') {
      GameStats.setStatus(GameStatus.ACTIVE);
    } else {
      if (directionSet) {
        // Do not set the direction when previous key pressed event triggered.
        return;
      }
      if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_KP_LEFT) {
        directionSet = snake.setDirection(Direction.LEFT);
      } else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_KP_RIGHT) {
        directionSet = snake.setDirection(Direction.RIGHT);
      } else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_KP_DOWN) {
        directionSet = snake.setDirection(Direction.DOWN);
      } else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_KP_UP) {
        directionSet = snake.setDirection(Direction.UP);
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // empty
  }

  public void run() {
    while(true) {
      takeStep();
      board.updateStatus();
      this.directionSet = false;
      try {
        TimeUnit.MILLISECONDS.sleep(GameStats.getSpeed().getDelay());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
