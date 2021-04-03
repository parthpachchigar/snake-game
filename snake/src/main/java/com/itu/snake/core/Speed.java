package com.itu.snake.core;

public class Speed {
	public static final Speed SLOWEST = new Speed(1000);
	public static final Speed SLOW = new Speed(800);
	public static final Speed MEDIUM = new Speed(600);
	public static final Speed FAST = new Speed(400);
	public static final Speed FASTEST = new Speed(200);
	private int delayInMilliseconds;

	private Speed(int delayInMilliseconds) {
		this.delayInMilliseconds = delayInMilliseconds;
	}

	public static Speed getNextHigherSpeed(Speed speed) {
		if (speed == Speed.SLOWEST) {
			return Speed.SLOW;
		}
		if (speed == Speed.SLOW) {
			return Speed.MEDIUM;
		}
		if (speed == Speed.MEDIUM) {
			return Speed.FAST;
		}
		if (speed == Speed.FAST) {
			return Speed.FASTEST;
		}

		return speed;
	}

	public static Speed getNextLowerSpeed(Speed speed) {
		if (speed == Speed.FASTEST) {
			return Speed.FAST;
		}
		if (speed == Speed.FAST) {
			return Speed.MEDIUM;
		}
		if (speed == Speed.MEDIUM) {
			return Speed.SLOW;
		}
		if (speed == Speed.SLOW) {
			return Speed.SLOWEST;
		}

		return speed;
	}

	public int getDelayInMilliseconds() {
		return this.delayInMilliseconds;
	}
}
