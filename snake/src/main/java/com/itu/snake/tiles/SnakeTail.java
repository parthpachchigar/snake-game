package com.itu.snake.tiles;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;

public class SnakeTail extends SnakeBody{

  public SnakeTail(int rowIndex, int columnIndex, Direction direction) {
    super(rowIndex, columnIndex, CellType.SNAKE_TAIL, direction);
  }
}
