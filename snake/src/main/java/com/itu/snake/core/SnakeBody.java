package com.itu.snake.core;

public class SnakeBody {
  private Cell cell;
  private SnakeBody next;

  public SnakeBody(Cell cell) {
    this.cell = cell;
    this.next = null;
  }

  public Cell getCell() {
    return cell;
  }

  public void setCell(Cell cell) {
    this.cell = cell;
  }

  public SnakeBody getNext() {
    return next;
  }

  public void setNext(SnakeBody next) {
    this.next = next;
  }
}
