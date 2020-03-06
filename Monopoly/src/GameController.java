


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
    private GridPane gridPaneBoard;
	@FXML
	private HBox hbox;
	@FXML
	private Icon icon;
	@FXML
	private Pane pane;
    @FXML
    void diceroll(ActionEvent event) {
    	gameBoard.rollDice();
    	message.setText("dice1: "+ Integer.toString(gameBoard.getDice1()) +"dice2: "+ Integer.toString(gameBoard.getDice2()));
    	
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	icon = new Icon();
    	System.out.print(gridPaneBoard.getWidth());
    	Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(10),
                   new EventHandler <ActionEvent>()
    			   {
    			   	@Override
    			   	public void handle(ActionEvent event)
    			   	{
    			   		icon.updateLocation();
    			   		if ((icon.getX() < 0) ||
    			   		    (icon.getX() > gridPaneBoard.getWidth()))
    			   			icon.reverseX();
    			   		if ((icon.getY() < 0) ||
    			   		    (icon.getY() > gridPaneBoard.getHeight()))
    			   			icon.reverseY();
    			   	}
    			   }
            )
    	);
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.setAutoReverse(true);
    	timeline.play();

    	gridPaneBoard.getChildren().get.add(icon);
    }
}
