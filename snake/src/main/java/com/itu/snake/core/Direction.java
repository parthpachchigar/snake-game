package com.itu.snake.core;

public enum Direction {
	UP("DOWN"),
	DOWN("UP"),
	LEFT("RIGHT"),
	RIGHT("LEFT");

	private String oppositeDirection;

	Direction(String oppositeDirection) {
		this.oppositeDirection = oppositeDirection;
	}

	public boolean isOpposite(Direction direction) {
		return Direction.valueOf(this.oppositeDirection) == direction;
	}

}
