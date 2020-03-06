


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;

public class GameController
{
    private ResourceBundle resources;
    private Board gameBoard = new Board();

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Label message;
	
	@FXML
	private HBox hbox;
	@FXML
	private Icon icon = new Icon();
	@FXML
	private Pane boardPane;
    @FXML
    void diceroll(ActionEvent event) {
    	gameBoard.rollDice();
    	int d1 = gameBoard.getDice1();
    	int d2 = gameBoard.getDice2();
    	message.setText("dice1: "+ Integer.toString(d1) +"dice2: "+ Integer.toString(d2));
    	icon.updateLocation();
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { 
    	
    	Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(50),
                   new EventHandler <ActionEvent>()
    			   {
    			   	@Override
    			   	public void handle(ActionEvent event)
    			   	{
    			   		icon.updateLocation();
    			   		if ((icon.getX() < 0) ||
    			   		    (icon.getX() > boardPane.getWidth()))
    			   			icon.reverseX();
    			   		if ((icon.getY() < 0) ||
    			   		    (icon.getY() > boardPane.getHeight()))
    			   			icon.reverseY();
    			   	}
    			   }
            )
    	);
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.setAutoReverse(true);
    	timeline.play();
    	
    	
    	

    	boardPane.getChildren().add(icon);
    	icon.initializeLocation();
    }
}
