import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;


public class Icon extends Circle
{
  private static final int RADIUS = 10;
  private int x,y;     // Keep track of the centre of the icon
  private int xVel, yVel; //Velocities of the icon in the x and y directions
  int counter; //will be used to determine what lines of code will be run in the update location method

  /**
   * constructor that initializes each icons variables
   * takes in the color of the icon
   * */
  public Icon(Color color)
  {
	  setRadius(RADIUS);
	  setFill(color);
	  x = 550;
	  y = 550;
	  xVel = 50;
	  yVel = 50;
	  counter = 0;
  }
  
  /**
   * creates an image instead of a circle
   * 
   * */
  public Icon(Image image)
  {
	  setRadius(RADIUS);
	  setFill(new ImagePattern(image));
	  x = 550;
	  y = 550;
	  xVel = 50;
	  yVel = 50;
	  counter = 0;
  }

  /**
   * places player1 in the gui so they don't overlap wih eachother
   * */
  public void movePlayer1(int location)
  {
	  switch(location) {
	  case 0:
		  setCenterX(550);
		  setCenterY(550);
		  break;
	  case 11:
		  setCenterX(50);
		  setCenterY(500);
		  break;
	  case 24: 
		  setCenterX(250);
		  setCenterY(50);
		  break;
	  case 30: 
		  setCenterX(50);
		  setCenterY(550);
		  break; // go to jail
	  case 39: 
		  setCenterX(550);
		  setCenterY(500);
		  break;
	  
	  
	  }
  }
  
  public void movePlayer2(int location)
  {
	  switch(location) {
	  case 0:
		  setCenterX(550+ 20);
		  setCenterY(550);
		  break;
	  case 11:
		  setCenterX(50 + 20);
		  setCenterY(500);
		  break;
	  case 24: 
		  setCenterX(250 + 20);
		  setCenterY(50);
		  break;
	  case 30: 
		  setCenterX(50 + 20);
		  setCenterY(550);
		  break; // go to jail
	  case 39: 
		  setCenterX(550 + 20);
		  setCenterY(500);
		  break;  
	  
	  
	  }
  }
  
  public void movePlayer3(int location)
  {
	  switch(location) {
	  case 0:
		  setCenterX(550);
		  setCenterY(550 + 20);
		  break;
	  case 11:
		  setCenterX(50);
		  setCenterY(500 + 20);
		  break;
	  case 24: 
		  setCenterX(250);
		  setCenterY(50 + 20);
		  break;
	  case 30: 
		  setCenterX(50);
		  setCenterY(550 + 20);
		  break; // go to jail
	  case 39: 
		  setCenterX(550);
		  setCenterY(500 + 20);
		  break;
	  }
  }
  
  public void movePlayer4(int location)
  {
	  switch(location) {
	  case 0:
		  setCenterX(550 + 20);
		  setCenterY(550 + 20);
		  break;
	  case 11:
		  setCenterX(50 + 20);
		  setCenterY(500 + 20);
		  break;
	  case 24: 
		  setCenterX(250 + 20);
		  setCenterY(50 + 20);
		  break;
	  case 30: 
		  setCenterX(50 + 20);
		  setCenterY(550 + 20);
		  break; // go to jail
	  case 39: 
		  setCenterX(550 + 20);
		  setCenterY(500 + 20);
		  break;
	  }
  }
  
  
  
  
  
  
  
  
  //moves the player the amount of pixels 1 spot is
  public void moveOneSpot()
  {
	  x -= 40;
	  setCenterX(x);
	  //setCenterY(y);
  }
  
  //tells where the icon should move depending on it's pixel location
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
  
  //moves the player instantly to a location
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