import javafx.scene.shape.Circle;

import java.util.Random;

import javafx.scene.paint.Color;


public class Icon extends Circle
{
  private static final int RADIUS = 20;
  private int x,y;     // Keep track of the centre of the ball
  private int xVel, yVel; //Velocities of the ball in the x and y directions

  public Icon()
  {
		Random rnd = new Random();

	      setRadius(RADIUS);
	      setFill(Color.RED);
	      x = 50;
	      y = 50;
	      xVel = rnd.nextInt(20) + 5;
	      yVel = rnd.nextInt(20) + 5;
  }

  public void updateLocation()
  {
	  x += xVel;
	  y += yVel;
	  setCenterX(x);
	  setCenterY(y);
  }
  
  public void initializeLocation()
  {
	  setCenterX(550);
	  setCenterY(550);
  }
  
  public void moveOneSpot()
  {
	  
  }
  
  public void jumpToLocation(int toX, int toY)
  {
	  x = toX * 40;
	  
	  y = toY * 40;
	  setCenterX(x);
	  setCenterY(y);
  }

  public int getX()
  {
	  return x;
  }

  public int getY()
  {
	  return y;
  }
  public void reverseX()
  {
	  xVel *= -1;
  }

  public void reverseY()
  {
	  yVel *= -1;
  }
}