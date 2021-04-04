package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import org.apache.commons.math3.util.Pair;

import java.util.List;
import java.util.Random;

public class Game {
    private int row, col;
    private CellMatrix matrix;
    private Snake snake;
    private Food food;

    public Game(int row, int col, int headRow, int headCol) {
        this.row = row;
        this.col = col;
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
        Cell nextSnakeHead = this.snake.attemptMove();
        Cell removedTail = null;
        if (nextSnakeHead.equalsTo(food)) {
            nextSnakeHead = this.snake.eat(food);
            this.applyFood();
        } else {
            // TODO: check if game over
            Pair<Cell, Cell> move = this.snake.move();
            nextSnakeHead = move.getFirst();
            removedTail = move.getSecond();
        }
        matrix.updateAt(nextSnakeHead.getRow(), nextSnakeHead.getCol(), CellType.SNAKE_HEAD);
        if (removedTail != null) {
            matrix.updateAt(removedTail.getRow(), removedTail.getCol(), CellType.EMPTY);
        }
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
}
