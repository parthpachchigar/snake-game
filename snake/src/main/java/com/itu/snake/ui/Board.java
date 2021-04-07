package com.itu.snake.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.itu.snake.core.Direction;
import com.itu.snake.core.Game;
import com.itu.snake.core.GameListener;
import com.itu.snake.enums.GameStatus;

public class Board extends JFrame implements GameListener {
  private int width, height, initHeadRow, initHeadCol;
  private Cell[][] cellMatrix;
  private JPanel gamePanel;
  private JPanel gameOverPanel;
  private StatusPanel statusPanel;
  private SoundController soundController;

  private Game game;
  private boolean directionSet = false;

  public Board(int rows, int cols, int headRow, int headCol) {
    this.width = cols * Cell.WIDTH;
    this.height = rows * Cell.HEIGHT;
    this.initHeadRow = headRow;
    this.initHeadCol = headCol;
    this.game = new Game(rows, cols, headRow, headCol);
    this.soundController = new SoundController();

    setTitle("Team 3 - Snake Game");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setLocationRelativeTo(null);
    setMinimumSize(new java.awt.Dimension(width, height+StatusPanel.STATUS_PANEL_HEIGHT));

    gamePanel = new JPanel();
    gamePanel.setSize(width, height);
    gamePanel.setMinimumSize(new java.awt.Dimension(width, height));

    GridBagLayout frameLayout = new GridBagLayout();
    setLayout(frameLayout);

    GridLayout panelLayout = new GridLayout(rows, cols);
    gamePanel.setLayout(panelLayout);
    cellMatrix = new Cell[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        this.cellMatrix[r][c] = new Cell();
        gamePanel.add(this.cellMatrix[r][c]);
      }
    }
    statusPanel = new StatusPanel(width);

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(statusPanel, constraints);
    pack();
    gamePanel.setVisible(true);

    addKeyListener();
    setVisible(true);

    gameOverPanel = new GameOverPanel(width, height);
    gameOverPanel.setVisible(false);

    constraints.gridx = 0;
    constraints.gridy = 1;
    add(gamePanel, constraints);
    add(gameOverPanel, constraints);
  }

  public void run() {
    this.game.setListener(this);
    this.game.startNewGame(initHeadRow, initHeadCol);
    while (true) {
      try {
        this.game.run();
        this.render();
        TimeUnit.MILLISECONDS.sleep(this.game.getSpeed().getDelay());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void render() {
    pack();
    this.statusPanel.update(this.game);
    for (int r = 0; r < cellMatrix.length; r++) {
      for (int c = 0; c < cellMatrix[0].length; c++) {
        this.cellMatrix[r][c].setType(this.game.getMatrix().getCellTypeAt(r, c));
      }
    }
    directionSet = false;
  }

  private void addKeyListener() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        char ch = e.getKeyChar();
        if (ch == 'a') {
          game.setScore(0);
          game.startNewGame(initHeadRow, initHeadCol);
        } else if (ch == 'f') {
          game.faster();
        } else if (ch == 's') {
          game.slower();
        } else if (ch == 'p') {
          game.setStatus(GameStatus.PAUSED);
        } else if (ch == 'r') {
          game.setStatus(GameStatus.ACTIVE);
        } else if (ch == 'c' && game.getStatus() == GameStatus.OVER) {
          game.startNewGame(initHeadRow, initHeadCol);
          game.setScore(game.getScore()/2);
        } else {
          if (directionSet) {
            // Do not set the direction when previous key pressed event triggered.
            return;
          }
          if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_KP_LEFT) {
            directionSet = game.setDirection(Direction.LEFT);
          } else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_KP_RIGHT) {
            directionSet = game.setDirection(Direction.RIGHT);
          } else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_KP_DOWN) {
            directionSet = game.setDirection(Direction.DOWN);
          } else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_KP_UP) {
            directionSet = game.setDirection(Direction.UP);
          }
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    });
  }

  @Override
  public void onGameStatusChange(GameStatus status) {
    if (status == GameStatus.OVER) {
      soundController.playGameOver();
      this.gamePanel.setVisible(false);
      this.gameOverPanel.setVisible(true);
    } else {
      this.gamePanel.setVisible(true);
      this.gameOverPanel.setVisible(false);
      if (status == GameStatus.PAUSED) {
        soundController.pauseBackground();
      } else if (status == GameStatus.ACTIVE) {
        soundController.resumeBackground();
      }
    }
  }

  @Override
  public void onEat() {
    soundController.playEat();
  }
}
