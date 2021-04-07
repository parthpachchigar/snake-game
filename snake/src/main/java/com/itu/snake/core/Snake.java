package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;

import com.itu.snake.tiles.Cell;
import com.itu.snake.tiles.Food;
import com.itu.snake.tiles.SnakeBody;
import com.itu.snake.tiles.SnakeHead;
import com.itu.snake.tiles.SnakeTail;
import java.util.ArrayList;
import java.util.List;

public class Snake {

  public static final int INIT_LENGTH = 5;
  private SnakeHead snakeHead;
  private List<SnakeBody> bodies;
  private SnakeTail snakeTail;
  private Direction direction;

  public Snake(int headRow, int headCol) {
    this.direction = Direction.RIGHT;
    snakeHead = new SnakeHead(headRow, headCol, Direction.RIGHT);
    int tailCol = headCol - INIT_LENGTH + 1;
    snakeTail = new SnakeTail(headRow, tailCol, Direction.RIGHT);
    this.bodies = new ArrayList<>(INIT_LENGTH);
    this.bodies.add(snakeHead);
    for (int i = 0; i < INIT_LENGTH - 2; i++) {
      this.bodies.add(new SnakeBody(headRow, --headCol, Direction.RIGHT));
    }
    this.bodies.add(snakeTail);
  }

  public boolean setDirection(Direction direction) {
    if (this.direction.isOpposite(direction) || this.direction == direction) {
      return false;
    }
    Direction cornerDirection = Direction.getCornerCellDirection(this.direction, direction);
    this.direction = direction;
    this.snakeHead.setDirection(cornerDirection);
    return true;
  }

  public Direction getDirection() {
    return this.direction;
  }

  public SnakeHead attemptMove() {
    return snakeHead.getNextHead(this.direction);
  }

  public List<Cell> moveForward() {
    List<Cell> updatedCells = new ArrayList<>();
    this.snakeHead = snakeHead.getNextHead(this.direction.getEffectiveDirectionForMove());
    // Update current head to make it body cell
    SnakeBody oldHead = this.bodies.remove(0);
    SnakeBody oldHeadToBody = new SnakeBody(oldHead.getRowIndex(), oldHead.getColumnIndex(), oldHead.getDirection());
    this.bodies.add(0, oldHeadToBody);
    updatedCells.add(oldHeadToBody);
    // Add new head at location 0
    this.bodies.add(0, this.snakeHead);
    updatedCells.add(this.snakeHead);
    // Remove existing tail cell from the bodies and make it empty
    Cell oldTail = this.bodies.remove(this.bodies.size()-1);
    oldTail = new Cell(oldTail.getRowIndex(), oldTail.getColumnIndex());
    updatedCells.add(oldTail);
    SnakeBody newTail = this.bodies.remove(this.bodies.size()-1);
    this.snakeTail = new SnakeTail(newTail.getRowIndex(), newTail.getColumnIndex(), newTail.getDirection().getEffectiveDirectionForMove());
    this.bodies.add(this.snakeTail);
    updatedCells.add(this.snakeTail);
    return updatedCells;
  }

  public List<SnakeBody> getBodies() {
    return bodies;
  }

  public List<Cell> eat(Food food) {
    List<Cell> updatedCells = new ArrayList<>();
    SnakeBody oldHead = this.bodies.remove(0);
    SnakeBody oldHeadToBody = new SnakeBody(oldHead.getRowIndex(), oldHead.getColumnIndex(), oldHead.getDirection());
    this.bodies.add(0, oldHeadToBody);
    updatedCells.add(oldHeadToBody);
    this.snakeHead = new SnakeHead(food.getRowIndex(), food.getColumnIndex(), this.direction);
    this.bodies.add(0, snakeHead);
    updatedCells.add(this.snakeHead);
    return updatedCells;
  }

}
