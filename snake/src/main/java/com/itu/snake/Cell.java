package com.itu.snake;

import com.itu.snake.enums.CellType;

/**
 * Represents single cell in the rid of the cells on game board.
 */
public class Cell {
  private int rowIndex;
  private int columnIndex;
  private CellType type;

  /**
   * Constructs object of Cell class.
   *
   * @param rowIndex row index of the cell on the board
   * @param columnIndex column index of the cell on the board
   * @param type one of the values in {@link CellType} enum
   */
  public Cell(int rowIndex, int columnIndex, CellType type) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    this.type = type;
  }

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
}
