package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import javax.swing.JLabel;

/**
 * Represents single cell in the rid of the cells on game board.
 */
public class Cell {
  private int rowIndex;
  private int columnIndex;
  private CellType type;
  private Direction direction;
  private JLabel label;

  /**
   * Constructs object of Cell class with cell type as EMPTY.
   *
   * @param rowIndex row index of the cell on the board
   * @param columnIndex column index of the cell on the board
   */
  public Cell(int rowIndex, int columnIndex) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    this.type = CellType.EMPTY;
    this.label = new JLabel();
    this.label.setOpaque(true);
    this.label.setBackground(this.type.getColor());
    this.label.setSize(10,10);
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public int getColumnIndex() {
    return columnIndex;
  }

  public CellType getType() {
    return type;
  }

  public void setType(CellType type) {
    this.type = type;
    this.label.setBackground(type.getColor());
  }

  public JLabel getLabel() {
    return this.label;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Cell getNextCell(Direction direction) {
    int rowIndex = this.rowIndex;
    int columnIndex = this.columnIndex;

    if (direction == Direction.UP) {
      rowIndex--;
    }
    if (direction == Direction.DOWN) {
      rowIndex++;
    }
    if (direction == Direction.LEFT) {
      columnIndex--;
    }
    if (direction == Direction.RIGHT) {
      columnIndex++;
    }
    return new Cell(rowIndex, columnIndex);
  }

  void clear() {
    this.setType(CellType.EMPTY);
    this.direction = null;
  }
}
