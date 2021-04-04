package com.itu.snake.core;

import com.itu.snake.ui.Board;

public class GameController extends Thread {

  @Override
  public void run() {
    super.run();
    Board gameBoard = new Board(400, 300, 10, 20);
    gameBoard.run();
  }
}
