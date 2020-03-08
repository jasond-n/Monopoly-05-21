


import java.net.URL;
import java.util.Optional;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import javafx.event.ActionEvent;

public class GameController
{
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
    private Label decision;
    

    
	@FXML
	private HBox hbox;
	@FXML
	private Icon icon1 = new Icon(Color.RED);
	@FXML
	private Icon icon2 = new Icon(Color.BLUE);
	
	//@FXML
	//private Icon icon3 = new Icon(Color.YELLOW);
	//@FXML
	//private Icon icon4 = new Icon(Color.GREEN);
	
	@FXML
	private Pane boardPane;
	
	@FXML
	private Label consoleLabel;
	
    @FXML
    void diceroll(ActionEvent event) {
    	gameConfiguration.getGameBoard().rollDice();
    	int d1 = gameConfiguration.getGameBoard().getDice1();
    	int d2 = gameConfiguration.getGameBoard().getDice2();

    	consoleLabel.setText(consoleLabel.getText() + "You diced " + (d1+d2));
    	
    	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.5), new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event2) {
		    	int currentPlayerIndex = gameConfiguration.getCurrentPlayer();
		    	switch(currentPlayerIndex)
		    	{
		    	case 0:
		    		icon1.updateLocation();
		    		Player currentPlayer = gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayer());
		    		currentPlayer.movePosition(1);
		    		break;
		    	case 1:
		    		icon2.updateLocation();
		    		Player currentPlayer2 = gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayer());
		    		currentPlayer2.movePosition(1);
		    		break;
		    	case 2:
		    		//icon3.updateLocation(); 				       	
		    		break;
		    	case 3:
		    		//icon4.updateLocation(); 
		    		break;
		    	}
		    	
		    }
		}));
    	
    	timeline.setCycleCount(d1+d2);
		timeline.play();

		gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % 2);
    	
		consoleLabel.setText(consoleLabel.getText() + ";\nNow, Player "+ (((gameConfiguration.getCurrentPlayer()+1)%2)+1) +"'s turn; ");
		
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { 
    	
    	boardPane.getChildren().add(icon1);
    	icon1.initializeLocation(0);
    	boardPane.getChildren().add(icon2);
    	icon2.initializeLocation(1);
    	//boardPane.getChildren().add(icon3);
    	//icon3.initializeLocation(2);
    	//boardPane.getChildren().add(icon4);
    	//icon4.initializeLocation(3);
    	gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % 2);
    	p3Balance.setText("");
    	p4Balance.setText("");
    	StartGame();
    }
    
    
	public void StartGame() {
		//consoleLabel.setText("Generating board...");
		//consoleLabel.setText(gameConfiguration.getGameBoard().toString());
		
		int numOfPlayers = 2;
			
		for (int i = 0; i < numOfPlayers; i++)
		{
			String playerName = "p" + (i + 1);
			Player player = new Player(playerName, gameConfiguration.getGameBoard());
			gameConfiguration.getGameBoard().getAllPlayers().add(player);
		}
		
		updateMoney();
		consoleLabel.setText("Player 1, please dice roll now: ");
	}
	
	public void updateMoney()
	{
		Board gameBoard = gameConfiguration.getGameBoard();
		Player player1 = gameBoard.getAllPlayers().get(0);
		Player player2 = gameBoard.getAllPlayers().get(1);
		
		p1Balance.setText("P1 Balance: $" + player1.getBalance());
		p2Balance.setText("P2 Balance: $" + player2.getBalance());
	}
	
	public void alertPrompt(Player p, String message) {
		Alert alert = new Alert(AlertType.NONE);
		alert.setTitle("Please make a decision");
		alert.setHeaderText("Click yes or no");
		//alert.setContentText("You are at " + gameConfiguration.getGameBoard().getProperties().get(gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayer()).getPosition()).getName() + 
				//". Do you want want to buy it?");
		alert.setContentText(message);
		
		ButtonType buttonYes = new ButtonType("Yes");
		alert.getButtonTypes().add(buttonYes);
	    ButtonType buttonNo = new ButtonType("No");
	    alert.getButtonTypes().add(buttonNo);
		
	
		Optional <ButtonType> action = alert.showAndWait();
		
		if (action.get() == buttonYes) {

			gameConfiguration.getGameBoard().getProperties().get(p.getPosition()).setUserInput("y");
			//p1Balance.
			//gameConfiguration.executeTurn(currentPlayer);

		} 
		else {
			gameConfiguration.getGameBoard().getProperties().get(p.getPosition()).setUserInput("n");
		}
	}
	
	public void afterLand(Player p, Board gameBoard) {
		Property landedProperty = gameBoard.getProperties().get(p.getPosition());
		
		
		switch (p.getPosition()) {
		case 0: 
			consoleLabel.setText("You just landed on GO, you can gain $200");
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 1:
			consoleLabel.setText("You just landed on Cragie Hall");
			
			if (landedProperty.youAreNotOwner(p, gameBoard)) {
				consoleLabel.setText("You have to pay the owner of the Property!");
			}
			else if (landedProperty.noOneOwns(p, gameBoard)){
				alertPrompt(p, "Would you like to buy Cragie Hall?");
			}
			
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		}
	}
	
	
	
}
