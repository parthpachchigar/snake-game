package com.itu.snake;

public class Direction {
	
	
	public static final Direction UP = new Direction();
	public static final Direction DOWN = new Direction();
	public static final Direction LEFT = new Direction();
	public static final Direction RIGHT = new Direction();
	
	
	private Direction() {
		
	}
	
	
	public static Direction getOppositeDirection(Direction givenDirection) {
		
		Direction result = new Direction();
		
		if(givenDirection == UP) {
			
			result = DOWN;
		}
		
		if(givenDirection == DOWN) {
			
			result = UP;
			
		}
		
		if(givenDirection == LEFT) {
			
			result = RIGHT;
			
		}
		
		if(givenDirection == RIGHT) {
			
			result = LEFT;
			
		}
		
		return result;
		
		
	}

}
