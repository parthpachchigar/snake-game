package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;
import com.itu.snake.game.GameStats;
import com.itu.snake.ui.Board;
import com.itu.snake.tiles.Cell;

import java.util.List;
import java.util.Random;

public class Game {
    private static Board board;
    private static Snake snake;

    private int rows;
    private int columns;
    //private Snake snake;
    private Cell foodCell;
    private Sound backgroundSound;

    public Game(int rows, int columns, int headRow, int headCol) {
        this.rows = rows;
        this.columns = columns;
        this.backgroundSound = new Sound("background.wav");
        this.backgroundSound.setLoop();
        this.startNewGame(headRow, headCol);
    }

    public void startNewGame(int headRow, int headCol) {
        board = new Board(rows, columns);
        snake = new Snake(headRow, headCol);

        GameStats.init();

        List<Cell> bodies = snake.getBodies();

        for (Cell body : bodies) {
            Cell cell = board.getCell(body.getRowIndex(), body.getColumnIndex());
            cell.setDirection(body.getDirection());
            cell.setType(body.getType());
            cell.setIconOrBackground();
        }

        backgroundSound.playSound();
        this.applyFood();
    }

    public boolean setDirection(Direction direction) {
       return this.snake.setDirection(direction);
    }

//    public void run() {
//        if (GameStats.getStatus() == GameStatus.OVER || GameStats.getStatus() == GameStatus.PAUSED) {
//        	if (backgroundSound.isActive()) {
//        		backgroundSound.stopSound();
//        	}
//            return;
//        }
//        if (!backgroundSound.isActive()) {
//        	backgroundSound.playSound();
//        }
//        Cell nextSnakeHead = this.snake.attemptMove();
//        if (nextSnakeHead.equals(food)) {
//            nextSnakeHead = this.snake.eat(food);
//            matrix.updateAt(nextSnakeHead.getRowIndex(), nextSnakeHead.getColumnIndex(), CellType.SNAKE_HEAD);
//            this.increaseScore();
//            new Sound("eat.wav").playSound();
//            this.applyFood();
//        } else if (!isGameOver(nextSnakeHead)){
//            Pair<Cell, Cell> move = this.snake.move();
//            nextSnakeHead = move.getFirst();
//            Cell removedTail = move.getSecond();
//            matrix.updateAt(nextSnakeHead.getRowIndex(), nextSnakeHead.getColumnIndex(), CellType.SNAKE_HEAD);
//            matrix.updateAt(removedTail.getRowIndex(), removedTail.getColumnIndex(), CellType.EMPTY);
//        } else {
//            status = GameStatus.OVER;
//            //this.score = 0;
//            backgroundSound.stopSound();
//            new Sound("game_over.wav").playSound();
//        }
//    }
//
//    public GameStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(GameStatus status) {
//        this.status = status;
//    }
//
//    public Speed faster() {
//        return speed.faster();
//    }
//
//    public Speed slower() {
//        return speed.slower();
//    }
//
//    public Speed getSpeed() {
//        return GameStats.getSpeed();
//    }
//
//    public int getScore() {
//        return score;
//    }
//
    private void applyFood() {
        this.foodCell = generateFood();
        this.foodCell.setType(CellType.FOOD);
        this.foodCell.setIconOrBackground();
    }

    private Cell generateFood() {
        Random random = new Random();
        int foodRow = random.nextInt(rows);
        int foodCol = random.nextInt(columns);
        if (board.getCell(foodRow, foodCol).getType() == CellType.EMPTY) {
            return board.getCell(foodRow, foodCol);
        }
        return generateFood();
    }
//
//    private boolean isGameOver(Cell nextMove) {
//        if (nextMove.getRowIndex() >= this.rows || nextMove.getColumnIndex() >= this.columns || nextMove.getRowIndex() < 0 || nextMove.getColumnIndex() < 0) {
//            return true;
//        }
//        return this.snake.getBodies().contains(nextMove);
//    }
//
//    private void increaseScore() {
//        this.score += this.speed.getSpeed().getScoreWeight();
//    }
}
