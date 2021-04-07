package com.itu.snake.ui;

import com.itu.snake.enums.Direction;
import com.itu.snake.enums.GameStatus;
import com.itu.snake.game.GameStats;
import com.itu.snake.tiles.Cell;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
  private int width, height;
  private Cell[][] cellMatrix;
  private JPanel gamePanel;
  private StatusPanel statusPanel;

  public Board(int rows, int columns) {
    this.width = columns * Cell.WIDTH;
    this.height = rows * Cell.HEIGHT;

    setTitle("Team 3 - Snake Game");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setMinimumSize(new java.awt.Dimension(width, height+StatusPanel.STATUS_PANEL_HEIGHT));
    setLocationRelativeTo(null);

    gamePanel = new GamePanel(width, height);

    GridBagLayout frameLayout = new GridBagLayout();
    setLayout(frameLayout);

    GridLayout panelLayout = new GridLayout(rows, columns);
    gamePanel.setLayout(panelLayout);
    cellMatrix = new Cell[rows][columns];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        this.cellMatrix[r][c] = new Cell(r, c);
        gamePanel.add(this.cellMatrix[r][c]);
      }
    }
    statusPanel = new StatusPanel(width);

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(statusPanel, constraints);
    gamePanel.setVisible(true);

    //addKeyListener();
    setVisible(true);

    constraints.gridx = 0;
    constraints.gridy = 1;
    add(gamePanel, constraints);
    pack();
  }

  public void addKeyboardListener(KeyListener listener) {
    this.addKeyListener(listener);
  }

  public Cell getCell(int rowIndex, int columnIndex) {
    return this.cellMatrix[rowIndex][columnIndex];
  }

  public void updateStatus(Direction direction) {
    if(!statusPanel.getText().startsWith("Speed") && GameStats.getStatus() == GameStatus.OVER) {
      return;
    }
    this.statusPanel.update(direction);
  }

  public void showMessageOnStatus(String message) {
    this.statusPanel.showMessage(message);
  }

}
