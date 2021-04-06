package com.itu.snake.core;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private Clip clip;

	Sound(String sound) {
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playSound() {
		clip.start();
	}

	public void stopSound() {
		clip.stop();
	}
	
	public boolean isActive() {
		return clip.isActive();
	}
	
	public void setLoop() {
		clip.loop(-1);
	}
}
