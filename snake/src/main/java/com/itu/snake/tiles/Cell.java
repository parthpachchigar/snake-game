package com.itu.snake.tiles;

import com.itu.snake.core.Icons;
import com.itu.snake.enums.CellType;

import java.awt.Dimension;
import javax.swing.*;

public class Cell extends JLabel {

  public static final int WIDTH = 20;
  public static final int HEIGHT = 20;

  private int rowIndex;
  private int columnIndex;
  private CellType type;
  private Icon iconImg;

  public Cell(int rowIndex, int columnIndex) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    setSize(WIDTH, HEIGHT);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setVisible(true);
    this.setOpaque(true);
    this.setType(CellType.EMPTY);
    this.iconImg = Icons.getIcon(this.getType(), null);
    this.setIconOrBackground();
  }

  public Cell(int rowIndex, int columnIndex, CellType type) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    setSize(WIDTH, HEIGHT);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setVisible(true);
    this.setOpaque(true);
    this.setType(type);
    this.iconImg = Icons.getIcon(this.getType(), null);
    this.setIconOrBackground();
  }

  public Cell(int rowIndex, int columnIndex, CellType type, Icon iconImg) {
    this.rowIndex = rowIndex;
    this.columnIndex = columnIndex;
    setSize(WIDTH, HEIGHT);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.setVisible(true);
    this.setOpaque(true);
    this.setType(type);
    this.iconImg = iconImg;
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

  public Icon getIconImg() {
    return this.iconImg;
  }

  public void setIconImg(Icon icon) {
    this.iconImg = icon;
  }

  public void setIconOrBackground() {
    if (this.iconImg != null) {
      this.setIcon(this.iconImg);
      return;
    }
    this.setBackground(type.getColor());
  }
}
