package com.itu.snake.tiles;

import com.itu.snake.core.Icons;
import com.itu.snake.enums.CellType;

import com.itu.snake.enums.Direction;
import java.awt.Dimension;
import javax.swing.*;

public class Cell extends JLabel {

  public static final int WIDTH = 20;
  public static final int HEIGHT = 20;

  private int rowIndex;
  private int columnIndex;
  private CellType type;
  private Direction direction;

  public Cell(int rowIndex, int columnIndex) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    setSize(WIDTH, HEIGHT);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setVisible(true);
    this.setOpaque(true);
    this.direction = null;
    this.setType(CellType.EMPTY);
    this.setIconOrBackground();
  }

  public Cell(int rowIndex, int columnIndex, CellType type, Direction direction) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    setSize(WIDTH, HEIGHT);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setVisible(true);
    this.setOpaque(true);
    this.direction = direction;
    this.setType(type);
    this.setIconOrBackground();
  }

  public int getColumnIndex() {
    return columnIndex;
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public void setType(CellType type) {
    this.type = type;
  }

  public void setIconOrBackground() {
    Icon icon = Icons.getIcon(this.type, this.direction);
    if (icon != null) {
      this.setIcon(icon);
      return;
    }
    this.setBackground(type.getColor());
  }

  public CellType getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    Cell cell = (Cell) o;
    return rowIndex == cell.rowIndex
        && columnIndex == cell.columnIndex
        && type == cell.getType();
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return this.direction;
  }
}
