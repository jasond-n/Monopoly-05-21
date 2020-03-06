import javafx.scene.shape.Circle;

import java.util.Random;

import javafx.scene.paint.Color;


public class Icon extends Circle
{
  private static final int RADIUS = 10;
  private int x,y;     // Keep track of the centre of the ball
  private int xVel, yVel; //Velocities of the ball in the x and y directions
  int counter; //will be used to determine what lines of code will be run in the update location method

  public Icon()
  {
		//Random rnd = new Random();

	      setRadius(RADIUS);
	      setFill(Color.RED);
	      x = 550;
	      y = 550;
	      xVel = 50;
	      yVel = 50;
	      counter = 0;
  }


  
  public void initializeLocation()
  {
	  setCenterX(550);
	  setCenterY(550);
  }
  
  public void moveOneSpot()
  {
	  x -= 40;
	  
	  
	  setCenterX(x);
	  //setCenterY(y);
  }
  
  public void updateLocation() {
	  
		  //move upwards
		  if (x == 50 && y == 550) {
			  reverseY();
			  counter = 1;
		  }
		//move right
		  else if (x == 50 && y == 50) {
			  reverseX();
			  counter = 0;
		  }
		//move downwards
		  else if (x == 550 && y == 50) {
			  reverseY();
			  counter = 1;
		  }
		//move left
		  else if (x == 550 && y == 550) {
			  reverseX();
			  counter = 0;
		  }
		  
		  switch (counter) {
		  case 0:
			  x += xVel;
			  setCenterX(x);
		  		setCenterY(y);
		  	break;
		  
		  case 1:
			  	y += yVel;
			  	setCenterX(x);
			  	setCenterY(y);
			  break;
		  }
	  
   
  }
  
  public void jumpToLocation(int toX, int toY)
  {
	  x = toX;
	  
	  y = toY ;
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