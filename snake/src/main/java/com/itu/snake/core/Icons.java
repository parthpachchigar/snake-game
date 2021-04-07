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
    } if(type == CellType.TREE) {
      return treeIcon();
    } else if (type == CellType.SNAKE_HEAD && direction == Direction.RIGHT) {
      return snakeHeadRight();
    } else if (type == CellType.SNAKE_HEAD && direction == Direction.LEFT) {
      return snakeHeadLeft();
    } else if (type == CellType.SNAKE_HEAD && direction == Direction.UP) {
      return snakeHeadUp();
    } else if (type == CellType.SNAKE_HEAD && direction == Direction.DOWN) {
      return snakeHeadDown();
    } else if(type == CellType.SNAKE_TAIL && direction == Direction.RIGHT) {
      return snakeTailRight();
    } else if(type == CellType.SNAKE_TAIL && direction == Direction.LEFT) {
      return snakeTailLeft();
    } else if(type == CellType.SNAKE_TAIL && direction == Direction.UP) {
      return snakeTailUp();
    } else if(type == CellType.SNAKE_TAIL && direction == Direction.DOWN) {
      return snakeTailDown();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.UP_RIGHT || direction == Direction.LEFT_DOWN)) {
      return snakeBodyUpRightOrLeftDown();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.UP_LEFT || direction == Direction.RIGHT_DOWN)) {
      return snakeBodyUpLeftOrRightDown();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.DOWN_LEFT || direction == Direction.RIGHT_UP)) {
      return snakeBodyDownLeftOrRightUp();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.DOWN_RIGHT || direction == Direction.LEFT_UP)) {
      return snakeBodyDownRightOrLeftUp();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.LEFT || direction == Direction.RIGHT)) {
      return snakeBodyHorizontal();
    } else if(type == CellType.SNAKE_BODY && (direction == Direction.UP || direction == Direction.DOWN)) {
      return snakeBodyVertical();
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

  private static Icon treeIcon() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);

    Rectangle2D.Double trunk = new Rectangle2D.Double(8,5,4,15);
    graphics2D.setPaint(new Color(128, 0, 0));
    graphics2D.fill(trunk);

    Shape tree1 = new Ellipse2D.Double(5,1,10,5);
    Shape tree2 = new Ellipse2D.Double(1,6,10,5);
    Shape tree3 = new Ellipse2D.Double(11,6,10,5);

    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(tree1);
    graphics2D.fill(tree2);
    graphics2D.fill(tree3);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
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

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

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

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

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

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeHeadLeft() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D myPath = new Path2D.Double();
    myPath.moveTo(20, 0);
    myPath.lineTo(16, 4);
    myPath.lineTo(16, 0);
    myPath.lineTo(0, 10);
    myPath.lineTo(16, 20);
    myPath.lineTo(16, 16);
    myPath.lineTo(20, 20);
    myPath.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(myPath);

    Shape eye1 = new Ellipse2D.Double(11,11,3,3);
    Shape eye2 = new Ellipse2D.Double(11,6,3,3);

    graphics2D.setPaint(Color.BLACK);
    graphics2D.fill(eye1);
    graphics2D.fill(eye2);

    Path2D headBorder = new Double();
    headBorder.moveTo(16,0);
    headBorder.lineTo(0,10);
    headBorder.lineTo(16, 20);
    headBorder.closePath();
    graphics2D.draw(headBorder);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeHeadUp() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D myPath = new Path2D.Double();
    myPath.moveTo(20, 20);
    myPath.lineTo(16, 16);
    myPath.lineTo(20, 16);
    myPath.lineTo(10, 0);
    myPath.lineTo(0, 16);
    myPath.lineTo(4, 16);
    myPath.lineTo(0, 20);
    myPath.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(myPath);

    Shape eye1 = new Ellipse2D.Double(11,11,3,3);
    Shape eye2 = new Ellipse2D.Double(6,11,3,3);

    graphics2D.setPaint(Color.BLACK);
    graphics2D.fill(eye1);
    graphics2D.fill(eye2);

    Path2D headBorder = new Double();
    headBorder.moveTo(20,16);
    headBorder.lineTo(10,0);
    headBorder.lineTo(0, 16);
    headBorder.closePath();
    graphics2D.draw(headBorder);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeHeadDown() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D myPath = new Path2D.Double();
    myPath.moveTo(0, 0);
    myPath.lineTo(4, 4);
    myPath.lineTo(0, 4);
    myPath.lineTo(10, 20);
    myPath.lineTo(20, 4);
    myPath.lineTo(16, 4);
    myPath.lineTo(20, 0);
    myPath.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(myPath);

    Shape eye1 = new Ellipse2D.Double(6,6,3,3);
    Shape eye2 = new Ellipse2D.Double(11,6,3,3);

    graphics2D.setPaint(Color.BLACK);
    graphics2D.fill(eye1);
    graphics2D.fill(eye2);

    Path2D headBorder = new Double();
    headBorder.moveTo(0,4);
    headBorder.lineTo(10,20);
    headBorder.lineTo(20, 4);
    headBorder.closePath();
    graphics2D.draw(headBorder);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

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

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeTailLeft() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 0);
    triangle1.lineTo(20, 10);
    triangle1.lineTo(0, 20);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(0,0);
    triangle2.lineTo(20,20);
    triangle2.lineTo(0, 10);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Path2D triangle3 = new Path2D.Double();
    triangle3.moveTo(0,20);
    triangle3.lineTo(20,0);
    triangle3.lineTo(0, 10);
    triangle3.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle3);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeTailUp() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 0);
    triangle1.lineTo(10, 20);
    triangle1.lineTo(20, 0);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(0,0);
    triangle2.lineTo(20,20);
    triangle2.lineTo(10, 0);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Path2D triangle3 = new Path2D.Double();
    triangle3.moveTo(20,0);
    triangle3.lineTo(0,20);
    triangle3.lineTo(10, 0);
    triangle3.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle3);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeTailDown() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 20);
    triangle1.lineTo(10, 0);
    triangle1.lineTo(20, 20);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(0,20);
    triangle2.lineTo(20,0);
    triangle2.lineTo(10, 20);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Path2D triangle3 = new Path2D.Double();
    triangle3.moveTo(20,20);
    triangle3.lineTo(0,0);
    triangle3.lineTo(10, 20);
    triangle3.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle3);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeBodyUpRightOrLeftDown() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 20);
    triangle1.lineTo(10, 0);
    triangle1.lineTo(20, 20);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(20,0);
    triangle2.lineTo(0,10);
    triangle2.lineTo(20, 20);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeBodyUpLeftOrRightDown() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 20);
    triangle1.lineTo(10, 0);
    triangle1.lineTo(20, 20);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(0,20);
    triangle2.lineTo(20,10);
    triangle2.lineTo(0, 0);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeBodyDownRightOrLeftUp() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 0);
    triangle1.lineTo(10, 20);
    triangle1.lineTo(20, 0);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(20,0);
    triangle2.lineTo(0,10);
    triangle2.lineTo(20, 20);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }

  private static Icon snakeBodyDownLeftOrRightUp() {
    BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = (Graphics2D) img.getGraphics();
    Rectangle2D.Double rectangle = new Rectangle2D.Double(0,0,20,20);
    graphics2D.setPaint(new Color(0, 138, 0));
    graphics2D.fill(rectangle);
    Path2D triangle1 = new Path2D.Double();
    triangle1.moveTo(0, 0);
    triangle1.lineTo(10, 20);
    triangle1.lineTo(20, 0);
    triangle1.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle1);

    Path2D triangle2 = new Path2D.Double();
    triangle2.moveTo(0,20);
    triangle2.lineTo(20,10);
    triangle2.lineTo(0, 0);
    triangle2.closePath();
    graphics2D.setPaint(Color.GREEN);
    graphics2D.fill(triangle2);

    Rectangle2D.Double border = new Rectangle2D.Double(0,0,19.5,19.5);
    graphics2D.setPaint(Color.RED);
    graphics2D.draw(border);

    graphics2D.drawImage(img, null, 0, 0);
    return new ImageIcon(img);
  }
}
