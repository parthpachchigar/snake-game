package com.itu.snake.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameOverPanel extends JPanel {

    public GameOverPanel(int width, int height) {
        setSize(width, height);
        try {
            BufferedImage pic = ImageIO.read(new URL("https://cdn-user-avatars.eneba.com/imt_2cwmqcU9_pk55skvmTw1x1Fa2lZE3NI61ohmr5g.jpeg"));
            JLabel icon = new JLabel(new ImageIcon(pic.getScaledInstance(width, height, Image.SCALE_DEFAULT)));
            icon.setSize(width, height);
            add(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
