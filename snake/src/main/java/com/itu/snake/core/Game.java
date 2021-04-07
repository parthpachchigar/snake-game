package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;
import com.itu.snake.enums.GameStatus;
import com.itu.snake.game.GameStats;
import com.itu.snake.tiles.Food;
import com.itu.snake.tiles.SnakeBody;
import com.itu.snake.tiles.Tree;
import com.itu.snake.ui.Board;
import com.itu.snake.tiles.Cell;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game implements KeyListener {
  public static int MAX_TREE_NUMBER = 20;

  private static Board board;
  private static Snake snake;

  private int rows;
  private int columns;
  private int headRow;
  private int headCol;
  private Food foodCell;
  private Sound backgroundSound;
  private boolean directionSet;
  private List<Tree> trees;

  public Game(int rows, int columns, int headRow, int headCol) {
    this.rows = rows;
    this.columns = columns;
    this.headRow = headRow;
    this.headCol = headCol;
    this.backgroundSound = new Sound("background.wav");
    this.directionSet = false;
    this.trees = new ArrayList<>(MAX_TREE_NUMBER);

    this.startNewGame();
  }

  public void startNewGame() {
    board = new Board(rows, columns);
    snake = new Snake(this.headRow, this.headCol);

    GameStats.init();
    board.updateStatus(snake.getDirection());
    board.addKeyboardListener(this);

    List<SnakeBody> bodies = snake.getBodies();
    updateBoard(bodies);

    this.applyFood();
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
      backgroundSound.playSoundInLoop();
    }
    Cell nextSnakeHead = snake.attemptMove();
    if(isOutOfBound(nextSnakeHead)) {
      gameOver();
      return;
    }
    nextSnakeHead = board.getCell(nextSnakeHead.getRowIndex(), nextSnakeHead.getColumnIndex());
    if(nextSnakeHead.getType() == CellType.SNAKE_BODY
        || nextSnakeHead.getType() == CellType.SNAKE_TAIL
        || nextSnakeHead.getType() == CellType.TREE) {
      gameOver();
      return;
    }
    if (nextSnakeHead.getType() == CellType.FOOD) {
      updateBoard(snake.eat(foodCell));
      GameStats.increaseScore();
      new Thread(){
        @Override
        public void run() {
          new Sound("eat.wav").playSound();
        }
      }.start();

      this.applyFood();
    }
    updateBoard(snake.moveForward());

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

  private boolean isOutOfBound(Cell nextMove) {
      return nextMove.getRowIndex() >= this.rows || nextMove.getColumnIndex() >= this.columns || nextMove.getRowIndex() < 0 || nextMove.getColumnIndex() < 0;
  }

  private void gameOver() {
    GameStats.setStatus(GameStatus.OVER);
    backgroundSound.stopSound();
    new Sound("game_over.wav").playSound();
    board.showMessageOnStatus(String.format("Game over! Your score is %d. Press 'c' to try cheating", GameStats.getScore()));
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
    if (ch == 'f') {
      GameStats.increaseSpeed();
    } else if (ch == 's') {
      GameStats.decreaseSpeed();
    } else if (ch == 'p') {
      GameStats.setStatus(GameStatus.PAUSED);
    } else if (ch == 'r') {
      GameStats.setStatus(GameStatus.ACTIVE);
    } else if (ch == 'c' && GameStats.getStatus() == GameStatus.OVER) {
      if(GameStats.getScore() == 0) {
        board.showMessageOnStatus(String
            .format("You need score other than 0 to cheat. Your score: %d",
                GameStats.getScore()));
      } else {
        GameStats.changeScoreToHalf();
        GameStats.setStatus(GameStatus.PAUSED);
        board.updateStatus(snake.getDirection());
      }
    } else if (ch == 't') {
      GameStats.setStatus(GameStatus.PAUSED);
      if(this.trees.isEmpty()){
        applyTree();
      } else {
        clearTree();
      }
    }  else {
      if(GameStats.getStatus() == GameStatus.OVER) {
        return;
      }
      if (directionSet && GameStats.getStatus() != GameStatus.PAUSED) {
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
    board.updateStatus(snake.getDirection());
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // empty
  }

  public void run() {
    while(true) {
      takeStep();
      board.updateStatus(snake.getDirection());
      this.directionSet = false;
      try {
        TimeUnit.MILLISECONDS.sleep(GameStats.getSpeed().getDelay());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void applyTree() {
    for (int i = 0; i < MAX_TREE_NUMBER; i++) {
      Tree tree = generateTree();
      this.trees.add(tree);
    }
    updateBoard(this.trees);
  }

  private void clearTree() {
    List<Cell> emptyCells = new ArrayList<>();
    for(Tree tree : this.trees) {
      emptyCells.add(new Cell(tree.getRowIndex(), tree.getColumnIndex()));
    }
    this.trees = new LinkedList<>();
    updateBoard(emptyCells);
  }

  private Tree generateTree() {
    Random random = new Random();
    int treeRow = random.nextInt(rows);
    int treeCol = random.nextInt(columns);
    if (board.getCell(treeRow, treeCol).getType() == CellType.EMPTY) {
      return new Tree(treeRow, treeCol);
    }
    return generateTree();
  }
}
