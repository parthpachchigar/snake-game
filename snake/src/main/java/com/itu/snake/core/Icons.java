package com.itu.snake.core;

import com.itu.snake.enums.CellType;
import com.itu.snake.enums.Direction;
import com.itu.snake.tiles.Cell;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Icons {

  public static Icon getIcon(CellType type, Direction direction) {
    if(type == CellType.FOOD) {
      return getAppleIcon();
    }else if (type == CellType.SNAKE_HEAD && direction == Direction.RIGHT) {
      return snakeHeadRight();
    } else if(type == CellType.SNAKE_TAIL && direction == Direction.RIGHT) {
      return snakeTailRight();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.LEFT || direction == Direction.RIGHT)) {
      return snakeBodyHorizontal();
    }
    return null;
  }

  private static Icon getAppleIcon() {
    Icon icon = null;
    try {
      icon = new ImageIcon(ImageIO.read(new URL(
          "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Red_apple.svg/1024px-Red_apple.svg.png"))
          .getScaledInstance(Cell.WIDTH, Cell.HEIGHT, Image.SCALE_SMOOTH));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
    return icon;
  }

  private static Icon snakeBodyHorizontal() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D myPath = new Path2D.Double();
    myPath.moveTo(0, 0);
    myPath.lineTo(10, 5);
    myPath.lineTo(20, 0);
    myPath.lineTo(20, 20);
    myPath.lineTo(10, 15);
    myPath.lineTo(0, 20);
    myPath.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(myPath);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeBodyVertical() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D myPath = new Path2D.Double();
    myPath.moveTo(0, 0);
    myPath.lineTo(5, 10);
    myPath.lineTo(0, 20);
    myPath.lineTo(20, 20);
    myPath.lineTo(15, 10);
    myPath.lineTo(20, 0);
    myPath.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(myPath);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeHeadRight() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D myPath = new Path2D.Double();
    myPath.moveTo(0, 0);
    myPath.lineTo(4, 4);
    myPath.lineTo(4, 0);
    myPath.lineTo(20, 10);
    myPath.lineTo(4, 20);
    myPath.lineTo(4, 16);
    myPath.lineTo(0, 20);
    myPath.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(myPath);

    Shape eye1 = new Ellipse2D.Double(6,6,3,3);
    Shape eye2 = new Ellipse2D.Double(6,11,3,3);

    graphics2D.setPaint(Color.BLACK);
    graphics2D.fill(eye1);
    graphics2D.fill(eye2);

    Path2D headBorder = new Double();
    headBorder.moveTo(4,0);
    headBorder.lineTo(20,10);
    headBorder.lineTo(4, 20);
    headBorder.closePath();
    graphics2D.draw(headBorder);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeTailRight() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(20, 20);
    triangle1.lineTo(20, 0);
    triangle1.lineTo(0, 10);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(20,20);
    triangle2.lineTo(0,0);
    triangle2.lineTo(20, 10);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Path2D triangle3 = new Path2D.Double();
    triangle3.moveTo(20,0);
    triangle3.lineTo(0,20);
    triangle3.lineTo(20, 10);
    triangle3.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle3);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }
}
