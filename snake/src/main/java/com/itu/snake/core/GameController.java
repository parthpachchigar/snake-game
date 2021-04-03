package com.itu.snake.core;

import java.util.concurrent.TimeUnit;

public class GameController extends Thread {

  @Override
  public void run() {
    super.run();
    Snake snake = Snake.getSnake();
    boolean noException = true;
    while(noException) {

      try {
        snake.move();
      } catch (ArrayIndexOutOfBoundsException ex) {
        noException = false;
      }

      try {
        TimeUnit.MILLISECONDS.sleep(600);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
