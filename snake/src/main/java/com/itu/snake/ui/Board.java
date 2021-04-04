package com.itu.snake.ui;

import com.itu.snake.core.Direction;
import com.itu.snake.core.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class Board extends JFrame {
  private int width;
  private int height;
  private Cell[][] cellMatrix;

  private Game game;
  private boolean directionSet = false;

  public Board(int width, int height, int headRow, int headCol) {
    this.width = width;
    this.height = height;
    setTitle("Team 3 - Snake Game");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setResizable(false);
    setMinimumSize(new java.awt.Dimension(width, height));
    setLocationRelativeTo(null);
    int cols = this.width / Cell.WIDTH;
    int rows = this.height / Cell.HEIGHT;
    GridLayout layout = new GridLayout(rows, cols);
    setLayout(layout);
    cellMatrix = new Cell[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        this.cellMatrix[r][c] = new Cell();
        add(this.cellMatrix[r][c]);
      }
    }
    addKeyListener();
    setVisible(true);
    pack();
    this.game = new Game(rows, cols, headRow, headCol);
  }

  public void run() {
    while (true) {
      try {
        TimeUnit.MILLISECONDS.sleep(500);
        this.game.run();
        this.render();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void render() {
    for (int r = 0; r < cellMatrix.length; r++) {
      for (int c = 0; c < cellMatrix[0].length; c++) {
        this.cellMatrix[r][c].setType(this.game.getMatrix().getCellTypeAt(r, c));
      }
    }
    directionSet = false;
  }

  private void addKeyListener() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (directionSet) {
          // Do not set the direction when previous key pressed event triggered.
          return;
        }
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_KP_LEFT) {
          directionSet = game.setDirection(Direction.LEFT);
        } else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_KP_RIGHT) {
          directionSet = game.setDirection(Direction.RIGHT);
        } else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_KP_DOWN) {
          directionSet = game.setDirection(Direction.DOWN);
        } else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_KP_UP) {
          directionSet = game.setDirection(Direction.UP);
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    });
  }

}
