package com.itu.snake.core;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    public static final int INIT_LENGTH = 3;
    private SnakeHead snakeHead;
    private List<SnakeBody> bodies;
    private Direction direction;

    public Snake(int headRow, int headCol) {
        this.direction = Direction.RIGHT;
        snakeHead = new SnakeHead(headRow, headCol, Direction.RIGHT);
        this.bodies = new ArrayList<>(INIT_LENGTH);
        int tailCol = headCol - INIT_LENGTH + 1;
        for (int i = 0; i < INIT_LENGTH - 1; i++) {
            this.bodies.add(new SnakeBody(headRow, tailCol++));
        }
        this.bodies.add(snakeHead);
    }

    public boolean setDirection(Direction direction) {
        if (this.direction.isOpposite(direction) || this.direction == direction) {
            return false;
        }
        this.direction = direction;
        this.snakeHead.setDirection(direction);
        return true;
    }

    public Cell attemptMove() {
        return snakeHead.next();
    }

    public Pair<Cell, Cell> move() {
        this.snakeHead = snakeHead.next();
        this.bodies.add(snakeHead);
        Cell tail = removeTail();
        return new Pair<>(this.snakeHead, tail);
    }

    public List<SnakeBody> getBodies() {
        return bodies;
    }

    public Cell eat(Food food) {
        this.snakeHead = new SnakeHead(food.getRow(), food.getCol(), this.direction);
        this.bodies.add(snakeHead);
        return this.snakeHead;
    }

    private SnakeBody removeTail() {
        return this.bodies.remove(0);
    }
}
