package com.itu.snake.enums;

public enum Direction {
	UP("DOWN"),
	DOWN("UP"),
	LEFT("RIGHT"),
	RIGHT("LEFT"),
	RIGHT_UP("BOTTOM_LEFT"),
	UP_RIGHT("LEFT_BOTTOM"),
	RIGHT_DOWN("UP_LEFT"),
	BOTTOM_RIGHT("LEFT_UP"),
	BOTTOM_LEFT("RIGHT_UP"),
	LEFT_BOTTOM("UP_RIGHT"),
	UP_LEFT("RIGHT_DOWN"),
	LEFT_UP("BOTTOM_RIGHT");

	private final String oppositeDirection;

	Direction(String oppositeDirection) {
		this.oppositeDirection = oppositeDirection;
	}

	public boolean isOpposite(Direction direction) {
		return Direction.valueOf(this.oppositeDirection) == direction;
	}

}
