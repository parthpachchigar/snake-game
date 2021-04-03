package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.ui.Board;

public class Snake {
  SnakeBody head;

  private static final Snake SNAKE = new Snake();

  private Snake() {
    Cell snakeHead = Board.getCell(10,10);
    snakeHead.setType(CellType.BODY);
    snakeHead.setDirection(Direction.RIGHT);
    head = new SnakeBody(snakeHead);
  }

  public static Snake getSnake() {
    return SNAKE;
  }

  public void move() {
    Cell nextCell = Board.getNextCell(this.head.getCell());
    nextCell.setType(this.head.getCell().getType());
    nextCell.setDirection(this.head.getCell().getDirection());
    SnakeBody newHead = new SnakeBody(nextCell);
    newHead.setNext(head);
    SnakeBody pointer = newHead;
    while(pointer.getNext().getNext() != null) {
      pointer = pointer.getNext();
    }
    pointer.getNext().getCell().clear();
    pointer.setNext(pointer.getNext().getNext());
    this.head = newHead;
  }

  public void setHeadDirection(Direction direction) {
    this.head.getCell().setDirection(direction);
  }

  public Direction getHeadDirection() {
    return this.head.getCell().getDirection();
  }
}
