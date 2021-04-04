package com.itu.snake.core;

public class SnakeHead extends SnakeBody {
    private Direction direction;
    public SnakeHead(int row, int col, Direction direction) {
        super(row, col);
        this.direction = direction;
    }

    public SnakeHead next() {
        int nextRow = this.getRow();
        int nextCol = this.getCol();
        if (this.direction == Direction.DOWN) {
            nextRow++;
        } else if (this.direction == Direction.UP) {
            nextRow--;
        } else if (this.direction == Direction.LEFT) {
            nextCol--;
        } else if (this.direction == Direction.RIGHT) {
            nextCol++;
        }
        return new SnakeHead(nextRow, nextCol, this.direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
