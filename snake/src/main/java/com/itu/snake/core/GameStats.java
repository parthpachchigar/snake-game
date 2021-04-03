package com.itu.snake.core;

import com.itu.snake.enums.GameStatus;

public class GameStats {
  private static int score;
  private static Speed speed;
  private static GameStatus status;

  static {
    score = 0;
    speed = Speed.MEDIUM;
    status = GameStatus.NEW;
  }

  public static int getScore() {
    return score;
  }

  public static Speed getSpeed() {
    return speed;
  }

  public static GameStatus getStatus() {
    return status;
  }

  public static void increaseScore(int increment) {
    GameStats.score += increment;
  }

  public static void setStatus(GameStatus status) {
    GameStats.status = status;
  }

  public static void increaseSpeed() {
    speed = Speed.getNextHigherSpeed(speed);
  }

  public static void decreaseSpeed() {
    speed = Speed.getNextLowerSpeed(speed);
  }
}
