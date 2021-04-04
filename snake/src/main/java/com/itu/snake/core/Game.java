package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.GameStatus;
import com.itu.snake.enums.Speed;
import org.apache.commons.math3.util.Pair;

import java.util.List;
import java.util.Random;

public class Game {
    private int row, col;
    private CellMatrix matrix;
    private Snake snake;
    private Food food;
    private GameStatus status;
    private SpeedController speed;
    private int score;

    public Game(int row, int col, int headRow, int headCol) {
        this.row = row;
        this.col = col;
        this.speed = new SpeedController();
        this.startNewGame(headRow, headCol);
    }

    public void startNewGame(int headRow, int headCol) {
        this.status = GameStatus.ACTIVE;
        matrix = new CellMatrix(row, col);
        snake = new Snake(headRow, headCol);
        List<SnakeBody> bodies = snake.getBodies();
        for (int i = 0; i < bodies.size() - 1; i++) {
            matrix.updateAt(bodies.get(i).getRow(), bodies.get(i).getCol(), CellType.SNAKE_BODY);
        }
        matrix.updateAt(bodies.get(bodies.size() - 1).getRow(), bodies.get(bodies.size() - 1).getCol(), CellType.SNAKE_HEAD);
        this.applyFood();
    }

    public CellMatrix getMatrix() {
        return matrix;
    }

    public boolean setDirection(Direction direction) {
       return this.snake.setDirection(direction);
    }

    public void run() {
        if (status == GameStatus.OVER || status == GameStatus.PAUSED) {
            return;
        }
        Cell nextSnakeHead = this.snake.attemptMove();
        if (nextSnakeHead.equals(food)) {
            nextSnakeHead = this.snake.eat(food);
            matrix.updateAt(nextSnakeHead.getRow(), nextSnakeHead.getCol(), CellType.SNAKE_HEAD);
            this.applyFood();
        } else if (!isGameOver(nextSnakeHead)){
            Pair<Cell, Cell> move = this.snake.move();
            nextSnakeHead = move.getFirst();
            Cell removedTail = move.getSecond();
            matrix.updateAt(nextSnakeHead.getRow(), nextSnakeHead.getCol(), CellType.SNAKE_HEAD);
            matrix.updateAt(removedTail.getRow(), removedTail.getCol(), CellType.EMPTY);
        } else {
            status = GameStatus.OVER;
        }
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Speed faster() {
        return speed.faster();
    }

    public Speed slower() {
        return speed.slower();
    }

    public Speed getSpeed() {
        return this.speed.getSpeed();
    }

    private void applyFood() {
        this.food = generateFood();
        matrix.updateAt(food.getRow(), food.getCol(), CellType.FOOD);
    }
    private Food generateFood() {
        Random random = new Random();
        int foodRow = random.nextInt(row);
        int foodCol = random.nextInt(col);
        if (this.matrix.getCellTypeAt(foodRow, foodCol) == CellType.EMPTY) {
            return new Food(foodRow, foodCol);
        }
        return generateFood();
    }

    private boolean isGameOver(Cell nextMove) {
        if (nextMove.getRow() >= this.row || nextMove.getCol() >= this.col || nextMove.getRow() < 0 || nextMove.getCol() < 0) {
            return true;
        }
        return this.snake.getBodies().contains(nextMove);
    }
}
