import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Icon extends Circle
{
  private static final int RADIUS = 20;
  private int x,y;     // Keep track of the centre of the ball
  private int xVel, yVel; //Velocities of the ball in the x and y directions

  public Icon()
  {
      setRadius(RADIUS);
      setFill(Color.RED);
      x = 0;
      y = 0;
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
	  setCenterX(x);
	  setCenterY(y);
  }
  
  public void moveOneSpot()
  {
	  
  }
  
  public void jumpToLocation(int toX, int toY)
  {
	  x = toX;
	  y = toY;
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