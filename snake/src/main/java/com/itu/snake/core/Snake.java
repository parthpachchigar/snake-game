package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;
import com.itu.snake.tiles.Cell;

import java.util.ArrayList;
import java.util.List;

public class Snake {

  public static final int INIT_LENGTH = 5;
  private Cell snakeHead;
  private List<Cell> bodies;
  private Cell snakeTail;
  private Direction direction;

  public Snake(int headRow, int headCol) {
    this.direction = Direction.RIGHT;
    snakeHead = new Cell(headRow, headCol, CellType.SNAKE_HEAD, Direction.RIGHT);
    int tailCol = headCol - INIT_LENGTH + 1;
    snakeTail = new Cell(headRow, tailCol, CellType.SNAKE_TAIL, Direction.RIGHT);
    this.bodies = new ArrayList<>(INIT_LENGTH);
    this.bodies.add(snakeHead);
    for (int i = 0; i < INIT_LENGTH - 2; i++) {
      this.bodies.add(new Cell(headRow, --headCol, CellType.SNAKE_BODY, Direction.RIGHT));
    }
    this.bodies.add(snakeTail);
  }

  public boolean setDirection(Direction direction) {
    if (this.direction.isOpposite(direction) || this.direction == direction) {
      return false;
    }
    this.direction = direction;
    this.snakeHead.setDirection(direction);
    return true;
  }

//  public Cell attemptMove() {
//    return snakeHead.getNextCell();
//  }

//  public Pair<Cell, Cell> move() {
//    this.snakeHead = snakeHead.getNextHead();
//    this.bodies.add(snakeHead);
//    Cell tail = removeTail();
//    return new Pair<>(this.snakeHead, tail);
//  }

  public List<Cell> getBodies() {
    return bodies;
  }

//  public Cell eat(Food food) {
//    this.snakeHead = new SnakeHead(food.getRowIndex(), food.getColumnIndex(), this.direction);
//    this.bodies.add(snakeHead);
//    return this.snakeHead;
//  }
//
//  private SnakeBody removeTail() {
//    return this.bodies.remove(0);
//  }
}
