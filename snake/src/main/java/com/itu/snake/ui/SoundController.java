package com.itu.snake.ui;

public class SoundController {
    private Sound backgroundSound;
    private Sound eat;
    private Sound gameOver;
    private boolean isBackgroundPlaying = true;

    public SoundController() {
        backgroundSound = new Sound("background.wav");
        gameOver = new Sound("game_over.wav");
        eat = new Sound("eat.wav");
    }

    public void playEat() {
        eat.playSound();
    }

    public void playGameOver() {
        backgroundSound.stopSound();
        eat.stopSound();
        gameOver.playSound();
    }

    public void pauseBackground() {
        backgroundSound.stopSound();
    }

    public void resumeBackground() {
        backgroundSound.setLoop();
        backgroundSound.playSound();
    }
}
