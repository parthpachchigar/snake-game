package com.itu.snake.tiles;

import com.itu.snake.core.Icons;
import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;

public class SnakeBody extends Cell {
  private Direction direction;

  public SnakeBody(int rowIndex, int columnIndex, Direction direction) {
    super(rowIndex, columnIndex, CellType.SNAKE_BODY, Icons.getIcon(CellType.SNAKE_BODY, direction));
    this.direction = direction;
  }

  public SnakeBody(int rowIndex, int columnIndex, CellType type, Direction direction) {
    super(rowIndex, columnIndex, type, Icons.getIcon(type, direction));
    this.direction = direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return this.direction;
  }
}
