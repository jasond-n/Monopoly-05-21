


import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;

public class GameController
{
    private ResourceBundle resources;
    private Board gameBoard = new Board();
    private GameConfiguration gameConfiguration = new GameConfiguration();
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Label message;
    
    @FXML
    private Label p1Balance;
    
    @FXML
    private Label p2Balance;
    
    @FXML
    private Label p3Balance;
    
    @FXML
    private Label p4Balance;
	
	@FXML
	private HBox hbox;
	@FXML
	private Icon icon1 = new Icon(Color.RED);
	@FXML
	private Icon icon2 = new Icon(Color.BLUE);
	
	@FXML
	private Pane boardPane;
	
	@FXML
	private Label consoleLabel;
	
	
	
    @FXML
    void diceroll(ActionEvent event) {
    	gameBoard.rollDice();
    	int d1 = gameBoard.getDice1();
    	int d2 = gameBoard.getDice2();

    	//message.setText("dice1: "+ Integer.toString(d1) +"; dice2: "+ Integer.toString(d2));


    	consoleLabel.setText(consoleLabel.getText() + "You diced " + (d1+d2));
    	
    	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.5), new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event2) {
		    	switch(gameConfiguration.getCurrentPlayer())
		    	{
		    	case 0:
		    		icon1.updateLocation(); 				       	
		    		break;
		    	case 1:
		    		icon2.updateLocation(); 
		    		break;
		    	}
		    	
		    }
		}));
    	
    	timeline.setCycleCount(d1+d2);
		timeline.play();
		gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % 2);
    	
		consoleLabel.setText(consoleLabel.getText() + "\n; Now, Player "+ (gameConfiguration.getCurrentPlayer()+1) +"'s turn; ");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { 
    	
//    	Timeline timeline = new Timeline(
//            new KeyFrame(Duration.millis(50),
//                   new EventHandler <ActionEvent>()
//    			   {
//    			   	@Override
//    			   	public void handle(ActionEvent event)
//    			   	{
//    			   		icon.updateLocation();
//    			   		if ((icon.getX() < 0) ||
//    			   		    (icon.getX() > boardPane.getWidth()))
//    			   			icon.reverseX();
//    			   		if ((icon.getY() < 0) ||
//    			   		    (icon.getY() > boardPane.getHeight()))
//    			   			icon.reverseY();
//    			   	}
//    			   }
//            )
//    	);
//    	timeline.setCycleCount(Timeline.INDEFINITE);
//    	timeline.setAutoReverse(true);
//    	timeline.play();
    
    	boardPane.getChildren().add(icon1);
    	icon1.initializeLocation(0);
    	boardPane.getChildren().add(icon2);
    	icon2.initializeLocation(1);
    	StartGame();
    }
    
    
	public void StartGame() {
		//consoleLabel.setText("Generating board...");
		//consoleLabel.setText(gameBoard.toString());
		
		
		Scanner sc = new Scanner(System.in);
		
		
		//consoleLabel.setText("How many players are playing: (2-4) ");
		int numOfPlayers = 2;
		
		
		
		for (int i = 1; i <= numOfPlayers; i++)
		{
			//consoleLabel.setText("Player " + i + ", please enter your name now: ");
			//String playerName = sc.next();
			String playerName = "p" + i;
			Player player = new Player(playerName, gameBoard);
			gameBoard.getAllPlayers().add(player);
		}
		
		p1Balance.setText("P1 Balance: $1500");
		p2Balance.setText("P2 Balance: $1500");
		
		
		consoleLabel.setText("Player 1, please dice roll now: ");

		sc.close();	
		
	}
}
