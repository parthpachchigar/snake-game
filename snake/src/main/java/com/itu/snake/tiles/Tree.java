package com.itu.snake.tiles;

import com.itu.snake.core.Icons;
import com.itu.snake.enums.CellType;

public class Tree extends Cell {

  public Tree(int rowIndex, int columnIndex) {
    super(rowIndex, columnIndex, CellType.TREE, Icons.getIcon(CellType.TREE, null));
  }
}
