package com.itu.snake.ui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private Clip clip;

	public Sound(String sound) {
		AudioInputStream audioInputStream;
		try {
			InputStream inputStream = Objects.requireNonNull(this.getClass().getClassLoader()
					.getResourceAsStream(sound));
			audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playSound() {
		clip.setMicrosecondPosition(0);
		clip.start();
	}

	public void stopSound() {
		clip.stop();
	}

	public void setLoop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
