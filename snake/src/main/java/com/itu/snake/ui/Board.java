package com.itu.snake.ui;

import com.itu.snake.core.Cell;
import com.itu.snake.core.Direction;
import com.itu.snake.core.Snake;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame {

  private JPanel jPanel;
  private static Cell[][] cells;
  private static final int MAX_ROWS = 60;
  private static final int MAX_COLS = 80;

  static {
    cells = new Cell[MAX_ROWS][MAX_COLS];
    for(int i=0; i < MAX_ROWS; i++) {
      for(int j=0; j< MAX_COLS; j++) {
        cells[i][j] = new Cell(i, j);
        cells[i][j].setDirection(null);
      }
    }
  }

  public Board() {
    initUi();
  }

  private void initUi() {
    setTitle("Team 3 - Snake Game");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setResizable(false);
    setMinimumSize(new java.awt.Dimension(800, 600));
    setLocationRelativeTo(null);

    jPanel = new javax.swing.JPanel(new GridLayout(MAX_ROWS, MAX_COLS, 0, 0));
    for(int i=0; i < MAX_ROWS; i++) {
      for(int j=0; j< MAX_COLS; j++) {
        jPanel.add(cells[i][j].getLabel());
      }
    }
    add(jPanel);

    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
        Snake snake = Snake.getSnake();
        if (e.getKeyCode() == 37 && snake.getHeadDirection() != Direction.RIGHT) {
          snake.setHeadDirection(Direction.LEFT);
        }
        if(e.getKeyCode() == 38 && snake.getHeadDirection() != Direction.DOWN) {
          snake.setHeadDirection(Direction.UP);
        }
        if(e.getKeyCode() == 39 && snake.getHeadDirection() != Direction.LEFT) {
          snake.setHeadDirection(Direction.RIGHT);
        }
        if (e.getKeyCode() == 40 && snake.getHeadDirection() != Direction.UP) {
          snake.setHeadDirection(Direction.DOWN);
        }
      }
    });

    pack();
  }

  public static Cell getCell(int rowIndex, int columnIndex) throws ArrayIndexOutOfBoundsException {
    if (rowIndex >= MAX_ROWS || columnIndex >= MAX_COLS) {
      throw new ArrayIndexOutOfBoundsException(String.format("Invalid Index: row = %d, col = %d", rowIndex, columnIndex));
    }
    return cells[rowIndex][columnIndex];
  }

  public static Cell getNextCell(Cell cell) throws ArrayIndexOutOfBoundsException {
    int rowIndex = cell.getRowIndex();
    int columnIndex = cell.getColumnIndex();

    if (cell.getDirection() == Direction.UP) {
      rowIndex--;
    }
    if (cell.getDirection() == Direction.DOWN) {
      rowIndex++;
    }
    if (cell.getDirection() == Direction.LEFT) {
      columnIndex--;
    }
    if (cell.getDirection() == Direction.RIGHT) {
      columnIndex++;
    }
    if (rowIndex >= MAX_ROWS || columnIndex >= MAX_COLS) {
      throw new ArrayIndexOutOfBoundsException(String.format("Invalid Index: row = %d, col = %d", rowIndex, columnIndex));
    }
    return cells[rowIndex][columnIndex];
  }

}
