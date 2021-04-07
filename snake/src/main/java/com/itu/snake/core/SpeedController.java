package com.itu.snake.core;

import com.itu.snake.enums.Speed;

public class SpeedController {

	private Speed[] speeds;
	private int speedIndex = 0;
	public SpeedController() {
		this.speeds = new Speed[] {Speed.SLOWEST, Speed.SLOW, Speed.MEDIUM, Speed.FAST, Speed.FASTEST};
	}

	public Speed getSpeed() {
		return this.speeds[speedIndex];
	}

	public Speed faster() {
		if (this.speedIndex < speeds.length - 1) {
			this.speedIndex++;
		}
		return this.speeds[speedIndex];
	}

	public Speed slower() {
		if (this.speedIndex > 0) {
			this.speedIndex--;
		}
		return this.speeds[speedIndex];
	}
}
