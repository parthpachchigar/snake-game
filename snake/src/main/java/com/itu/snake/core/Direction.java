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

	public Direction getOppositeDirection() {
		return Direction.valueOf(this.oppositeDirection);
	}

}
