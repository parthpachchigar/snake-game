package com.itu.snake.enums;

public enum Direction {
	UP("DOWN", "UP"),
	DOWN("UP", "DOWN"),
	LEFT("RIGHT", "LEFT"),
	RIGHT("LEFT", "RIGHT"),
	RIGHT_UP("DOWN_LEFT", "UP"),
	UP_RIGHT("LEFT_DOWN", "RIGHT"),
	RIGHT_DOWN("UP_LEFT", "DOWN"),
	DOWN_RIGHT("LEFT_UP", "RIGHT"),
	DOWN_LEFT("RIGHT_UP", "LEFT"),
	LEFT_DOWN("UP_RIGHT", "DOWN"),
	UP_LEFT("RIGHT_DOWN", "LEFT"),
	LEFT_UP("DOWN_RIGHT", "UP");

	private final String oppositeDirection;
	private final String effectiveDirectionForMove;

	Direction(String oppositeDirection, String effectiveDirectionForMove) {
		this.oppositeDirection = oppositeDirection;
		this.effectiveDirectionForMove = effectiveDirectionForMove;
	}

	public boolean isOpposite(Direction direction) {
		return Direction.valueOf(this.oppositeDirection) == direction;
	}

	public Direction getOppositeDirection() {
		return Direction.valueOf(this.oppositeDirection);
	}

	public static Direction getCornerCellDirection(Direction existingDirection, Direction newDirection) {
		if (existingDirection == RIGHT && newDirection == UP) {
			return RIGHT_UP;
		} else if (existingDirection == RIGHT && newDirection == DOWN) {
			return RIGHT_DOWN;
		} else if (existingDirection == LEFT && newDirection == UP) {
			return LEFT_UP;
		} else if (existingDirection == LEFT && newDirection == DOWN) {
			return LEFT_DOWN;
		} else if (existingDirection == UP && newDirection == RIGHT) {
			return UP_RIGHT;
		} else if (existingDirection == UP && newDirection == LEFT) {
			return UP_LEFT;
		} else if (existingDirection == DOWN && newDirection == RIGHT) {
			return DOWN_RIGHT;
		} else if (existingDirection == DOWN && newDirection == LEFT) {
			return DOWN_LEFT;
		}
		return null;
	}

	public Direction getEffectiveDirectionForMove() {
		return Direction.valueOf(this.effectiveDirectionForMove);
	}

}
