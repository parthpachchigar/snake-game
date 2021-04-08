package com.itu.snake.core;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JLabel sp = new JLabel("press 'f' to speedup, 's' to slowdown ");
    sp.setBounds(20, 60, 250, 30);

    JLabel dr = new JLabel("press up/down/left/right for directions");
    dr.setBounds(20, 90, 250, 30);

    JLabel restart = new JLabel("press 'p' to pause, 'r' for resume");
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
