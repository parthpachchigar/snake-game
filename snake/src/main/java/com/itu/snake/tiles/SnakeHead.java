package com.itu.snake.tiles;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;

public class SnakeHead extends SnakeBody {

  public SnakeHead(int rowIndex, int columnIndex,
      Direction direction) {
    super(rowIndex, columnIndex, CellType.SNAKE_HEAD, direction);
  }
}
