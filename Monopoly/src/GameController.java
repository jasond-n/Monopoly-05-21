import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;

public class GameController
{
    private GameConfiguration gameConfiguration = new GameConfiguration();
    private Player currentPlayer = new Player("", gameConfiguration.getGameBoard());
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
		    		setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(currentPlayerIndex));
		    		getCurrentPlayer().movePosition(1);
		    		break;
		    	case 1:
		    		icon2.updateLocation();
		    		setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(currentPlayerIndex));
		    		getCurrentPlayer().movePosition(1);
		    		break;
		    	case 2:
		    		//icon3.updateLocation();
		    		//setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(currentPlayerIndex));
		    		//getCurrentPlayer().movePosition(1);
		    		break;
		    	case 3:
		    		//icon4.updateLocation(); 
		    		//setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(currentPlayerIndex));
		    		//getCurrentPlayer().movePosition(1);
		    		break;
		    	}
		    	
		    }
		}));
    	
    	timeline.setCycleCount(d1+d2);
		timeline.play();

		gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % 2);
    	
		consoleLabel.setText(consoleLabel.getText() + ";\nNow, Player "+ (((gameConfiguration.getCurrentPlayer()+1)%2)+1) +"'s turn; ");
		afterLand(getCurrentPlayer(), gameConfiguration.getGameBoard());
		updateMoney();
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
    
    public void setCurrentPlayer(Player p) {
    	currentPlayer = p;
    }
    
    public Player getCurrentPlayer() {
    	return currentPlayer;
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
		} 
		else {
			gameConfiguration.getGameBoard().getProperties().get(p.getPosition()).setUserInput("n");
		}
	}
	
	public void normalPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText("You have to pay the owner of the Property!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)){
			alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?");
			
			if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
				consoleLabel.setText("You just bought " + landedProperty.getName());
			}
			
			if (p.getBalance() - landedProperty.getPrice() < 0) {
				consoleLabel.setText("Sorry you do not have enough money to buy " + landedProperty.getName());
			}
			
		}
		else if (landedProperty.youOwn(p, gameBoard)) {
			
			if (landedProperty.getNumOfHouses() == 4 && landedProperty.getNumOfHotels() == 0) {
				
				alertPrompt(p, "Would you like to buy a hotel? (y/n)");

				if (landedProperty.getUserInput().equalsIgnoreCase("y")) {
					if (p.getBalance() - landedProperty.getHotelCost() >= 0) {
						consoleLabel.setText("You just bought a hotel ");
					}
					else {
						consoleLabel.setText("Sorry You do not have enough money to buy this");
					}
				}
			}
			//asks to buy a house if you have less than 4 houses
			if (landedProperty.getNumOfHouses() < 4 && landedProperty.getNumOfHotels() == 0) {
				//System.out.print("would you like to buy a house? (y/n)");
				if (landedProperty.getUserInput().equalsIgnoreCase("y")) {
					if (p.getBalance() - landedProperty.getHouseCost() >= 0) {
						consoleLabel.setText("You just bought a house.");
						//System.out.println("You just bought a house ");
					}
					else {
						consoleLabel.setText("Sorry You do not have enough money to buy this");
						//System.out.println("Sorry You do not have enough money to buy this");
					}
				}
				//sc.close();
			}
		}
	}
	
	public void railroadlPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText("You have to pay the owner of the railroad!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)){
			alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?");
			
			if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
				consoleLabel.setText("You just bought" + landedProperty.getName());
			}
			
			if (p.getBalance() - landedProperty.getPrice() < 0) {
				consoleLabel.setText("Sorry you do not have enough money to buy " + landedProperty.getName());
			}	
		}
	}
	
	public void utilityPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText("You have to pay the owner of the utility!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)){
			alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?");
			
			if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
				consoleLabel.setText("You just bought " + landedProperty.getName());
			}
			
			if (p.getBalance() - landedProperty.getPrice() < 0) {
				consoleLabel.setText("Sorry you do not have enough money to buy " + landedProperty.getName());
			}	
		}
	}
	
	public void afterLand(Player p, Board gameBoard) {
		Property landedProperty = gameBoard.getProperties().get(p.getPosition());
		
		consoleLabel.setText("You just landed on " + landedProperty.getName());
		
		switch (p.getPosition()) {
		case 0: 
			consoleLabel.setText("Collect $200");
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 1:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 2:
			break;
		case 3:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 4:
			break;
		case 5:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 6:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 7:
			break;
		case 8:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 9:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 10:
			consoleLabel.setText("You passed Jail, nothing happened");
			break;
		case 11:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 12:
			utilityPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 13:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 14:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 15:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 16:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 17:
			break;
		case 18:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 19:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 20:
			break;
		case 21:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 22:
			break;
		case 23:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 24:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 25:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 26:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 27:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 28:
			utilityPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 29:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 30:
			break;
		case 31:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 32:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 33:
			break;
		case 34:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 35:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 36:
			break;
		case 37:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		case 38:
			break;
		case 39:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard);
			break;
		}
	}
}
