package com.itu.snake.core;

public class Cell {
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean equalsTo(Cell cell) {
        return (this.row == cell.row) && (this.col == cell.col);
    }
}
