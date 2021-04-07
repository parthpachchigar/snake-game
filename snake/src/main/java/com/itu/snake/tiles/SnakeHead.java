package com.itu.snake.tiles;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;

public class SnakeHead extends SnakeBody {

  public SnakeHead(int rowIndex, int columnIndex,
      Direction direction) {
    super(rowIndex, columnIndex, CellType.SNAKE_HEAD, direction);
  }

  public SnakeHead getNextHead(Direction direction) {
    int nextRow = this.getRowIndex();
    int nextCol = this.getColumnIndex();
    switch (direction) {
      case DOWN:
        nextRow++;
        break;

      case UP:
        nextRow--;
        break;

      case LEFT:
        nextCol--;
        break;

      case RIGHT:
        nextCol++;
        break;
    }

    return new SnakeHead(nextRow, nextCol, direction);
  }
}
