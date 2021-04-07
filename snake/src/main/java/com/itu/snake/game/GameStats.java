package com.itu.snake.game;

import com.itu.snake.enums.GameStatus;
import com.itu.snake.enums.Speed;

public class GameStats {
  private static int score;
  private static Speed speed;
  private static GameStatus status;

  public static void init() {
    score = 0;
    speed = Speed.MEDIUM;
    status = GameStatus.PAUSED;
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

  public static void increaseScore() {
    GameStats.score += speed.getScoreWeight();
  }

  public static void decreaseScore(int amount) {
    GameStats.score -= amount;
  }

  public static void setStatus(GameStatus status) {
    GameStats.status = status;
  }

  public static void increaseSpeed() {
    speed = speed.getFasterSpeed();
  }

  public static void decreaseSpeed() {
    speed = speed.getSlowerSpeed();
  }
}