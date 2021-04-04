package com.itu.snake;

import com.itu.snake.core.CellMatrix;
import com.itu.snake.core.GameController;
import com.itu.snake.enums.CellType;
import com.itu.snake.ui.Board;

public class SnakeGame {
  public static void main(String[] args) {
//    Board gameBoard = new Board(800, 600);
//
//    CellMatrix matrix = new CellMatrix(60, 80);
//    Thread.sleep(1000);
//    matrix.updateAt(1, 5, CellType.SNAKE_HEAD);
//
//    gameBoard.updateCells(matrix);
//    gameBoard.setVisible(true);
//
    Thread gameController = new GameController();
    gameController.start();
  }
}
