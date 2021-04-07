package com.itu.snake.core;

import com.itu.snake.enums.CellType;

public class CellMatrix {
    private CellType[][] cells;
    public CellMatrix(int rows, int cols) {
        cells = new CellType[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.cells[r][c] = CellType.EMPTY;
            }
        }
    }

    public void updateAt(int rowIndex, int colIndex, CellType type) {
        this.cells[rowIndex][colIndex] = type;
    }

    public CellType getCellTypeAt(int rowIndex, int colIndex) {
        return this.cells[rowIndex][colIndex];
    }
}
