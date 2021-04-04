package com.itu.snake.core;

public enum Direction {
	UP,
	DOWN,
	LEFT,
	RIGHT;

	public boolean isOpposite(Direction direction) {
		switch (this) {
			case UP: {
				return direction == DOWN;
			}
			case DOWN: {
				return direction == UP;
			}
			case LEFT: {
				return direction == RIGHT;
			}
			case RIGHT: {
				return direction == LEFT;
			}
		}
		return false;
	}

}
