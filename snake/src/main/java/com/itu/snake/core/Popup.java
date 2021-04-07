package com.itu.snake.core;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class Popup {

  private JFrame helpbox = new JFrame("Help Box");

  public Popup(){

    helpbox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    helpbox.setBounds(200, 200, 400, 200);

    Container container = helpbox.getContentPane();
    container.setLayout(null);

    JLabel instruction = new JLabel("Instruction");
    instruction.setBounds(20, 30, 250, 30);

    JLabel sp = new JLabel("press f to speedup, press s to speeddown ");
    sp.setBounds(20, 60, 250, 30);

    JLabel dr = new JLabel("press up/down/left/right for directions");
    dr.setBounds(20, 90, 250, 30);

    JLabel restart = new JLabel("press a to restart");
    restart.setBounds(20, 120, 250, 30);

    container.add(instruction);
    container.add(sp);
    container.add(dr);
    container.add(restart);
    helpbox.setVisible(true);
  }

  public JFrame gethelpbox() {
    return this.helpbox;
  }
}
