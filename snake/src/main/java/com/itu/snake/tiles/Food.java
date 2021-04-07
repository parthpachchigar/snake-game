package com.itu.snake.tiles;

import com.itu.snake.enums.CellType;

public class Food extends Cell {

  public Food(int rowIndex, int columnIndex) {
    super(rowIndex, columnIndex, CellType.FOOD);
  }
}
