import java.net.URL;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout. * ;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class GameController extends MainMenuController {
	private GameConfiguration gameConfiguration = new GameConfiguration();
	private Player currentPlayer = new Player("", gameConfiguration.getGameBoard());
	private boolean gameOver = false;
	private int d1, d2, currentPlayerIndex, playerCount;

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
	private Icon icon3 = new Icon(Color.YELLOW);

	@FXML
	private Icon icon4 = new Icon(Color.GREEN);

	@FXML
	private Pane boardPane;

	@FXML
	private Label consoleLabel;

	@FXML
	public void diceroll(ActionEvent event) {
		gameConfiguration.getGameBoard().rollDice();
		d1 = gameConfiguration.getGameBoard().getDice1();
		d2 = gameConfiguration.getGameBoard().getDice2();

		consoleLabel.setText(consoleLabel.getText() + "You diced " + (d1 + d2));
		if (getCurrentPlayer().getInJail() == false) {
			movePlayer(d1, d2);
			if (d1 == d2) {
				consoleLabel.setText(consoleLabel.getText() + "\nNice you Rolled a double!");
				gameConfiguration.getGameBoard().rollDice();
				movePlayer(d1, d2);

				if (d1 == d2) {
					consoleLabel.setText(consoleLabel.getText() + "\nNice you Rolled a double!");
					gameConfiguration.getGameBoard().rollDice();
					movePlayer(d1, d2);

					if (d1 == d2) {
						consoleLabel.setText(consoleLabel.getText() + "\nYou rolled 3 doubles in a roll. Move to jail!");
						getCurrentPlayer().setPosition(10);
						getCurrentPlayer().setInJail(true);
					}
				}
			}
		}
		gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % getPlayerCount());
		consoleLabel.setText(consoleLabel.getText() + ";\nNow, Player " + (((gameConfiguration.getCurrentPlayer() + 1) % getPlayerCount()) + 1) + "'s turn; ");
		updateMoney();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		boardPane.getChildren().add(icon1);
		icon1.initializeLocation(0);
		boardPane.getChildren().add(icon2);
		icon2.initializeLocation(1);
		if(getPlayerCount() >= 3)
		{
			boardPane.getChildren().add(icon3);
			icon3.initializeLocation(2);
		}
		if(getPlayerCount() >= 4)
		{
			boardPane.getChildren().add(icon4);
			icon4.initializeLocation(3);
		}
		playerCount = getPlayerCount();
		gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % playerCount);
		//p3Balance.setText("");
		//p4Balance.setText("");
		StartGame();
	}

	public void movePlayer(int d1, int d2) {
		setCurrentPlayerIndex(gameConfiguration.getCurrentPlayer());
		for (int i = 0; i < d1 + d2; i++) {
			switch (getCurrentPlayerIndex()) {
			case 1:
				icon1.updateLocation();
				setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(getCurrentPlayerIndex()));
				if (i == 0) {
					getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + d1 + d2);
					getCurrentPlayer().setPreviousPosition(d1 + d2);
				}
				break;
			case 0:
				icon2.updateLocation();
				setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(getCurrentPlayerIndex()));
				if (i == 0) {
					getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + d1 + d2);
					getCurrentPlayer().setPreviousPosition(d1 + d2);
				}
				break;
			case 3:
				//icon3.updateLocation();
				//setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(currentPlayerIndex));
				//getCurrentPlayer().movePosition(1);
				break;
			case 2:
				//icon4.updateLocation(); 
				//setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(currentPlayerIndex));
				//getCurrentPlayer().movePosition(1);
				break;
			}
		}
		afterLand(getCurrentPlayer(), gameConfiguration.getGameBoard());
	}

	public void setCurrentPlayer(Player p) {
		currentPlayer = p;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	public void StartGame() {
		playerCount = getPlayerCount();
		for (int i = 0; i < playerCount; i++) {
			String playerName = "p" + (i + 1);
			Player player = new Player(playerName, gameConfiguration.getGameBoard());
			gameConfiguration.getGameBoard().getAllPlayers().add(player);
		}
		updateMoney();
		consoleLabel.setText("Player 1, please dice roll now: ");
	}

	public void updateMoney() {
		Board gameBoard = gameConfiguration.getGameBoard();
		Player player1 = gameBoard.getAllPlayers().get(1);
		Player player2 = gameBoard.getAllPlayers().get(0);
		Player player3 = gameBoard.getAllPlayers().get(2);
		Player player4 = gameBoard.getAllPlayers().get(3);

		if(getPlayerCount() == 2)
		{
			p1Balance.setText("P1 Balance: $" + player1.getBalance());
			p2Balance.setText("P2 Balance: $" + player2.getBalance());
		}
		else if(getPlayerCount() == 3)
		{
			p1Balance.setText("P1 Balance: $" + player1.getBalance());
			p2Balance.setText("P2 Balance: $" + player2.getBalance());
			p3Balance.setText("P3 Balance: $" + player3.getBalance());
		}
		else if(getPlayerCount() == 4)
		{
			p1Balance.setText("P1 Balance: $" + player1.getBalance());
			p2Balance.setText("P2 Balance: $" + player2.getBalance());
			p3Balance.setText("P3 Balance: $" + player3.getBalance());
			p2Balance.setText("P4 Balance: $" + player4.getBalance());
		}
	}

	public void alertPrompt(Player p, String message) {
		Alert alert = new Alert(AlertType.NONE);
		alert.setTitle("Please make a decision");
		alert.setHeaderText("Click yes or no");
		alert.setContentText(message);

		ButtonType buttonYes = new ButtonType("Yes");
		alert.getButtonTypes().add(buttonYes);
		ButtonType buttonNo = new ButtonType("No");
		alert.getButtonTypes().add(buttonNo);

		Optional < ButtonType > action = alert.showAndWait();
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
		else if (landedProperty.noOneOwns(p, gameBoard)) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?\nThe price is " + landedProperty.getPrice());
				if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
				}
				if (p.getBalance() - landedProperty.getPrice() < 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nSorry you do not have enough money to buy " + landedProperty.getName());
				}
			}
			else {
				if (landedProperty.getPrice() <= p.getBalance() * 0.4);
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
			}
		}
		else if (landedProperty.youOwn(p, gameBoard)) {

			if (landedProperty.getNumOfHouses() == 4 && landedProperty.getNumOfHotels() == 0) {
				if (p.getPlayerType().equalsIgnoreCase("human")) {
					alertPrompt(p, "Would you like to buy a hotel? \nThe price is " + landedProperty.getHotelCost());

					if (landedProperty.getUserInput().equalsIgnoreCase("y")) {
						if (p.getBalance() - landedProperty.getHotelCost() >= 0) {
							consoleLabel.setText(consoleLabel.getText() + "\nYou just bought a hotel ");
						}
						else {
							consoleLabel.setText(consoleLabel.getText() + "\nSorry You do not have enough money to buy this");
						}
					}
				}
				else {
					if (landedProperty.getPrice() <= p.getBalance() * 0.4);
						consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
				}
			}
			//asks to buy a house if you have less than 4 houses
			if (landedProperty.getNumOfHouses() < 4 && landedProperty.getNumOfHotels() == 0) {
				alertPrompt(p, "Would you like to buy a house? \nThe price is " + landedProperty.getHotelCost());
				if (p.getPlayerType().equalsIgnoreCase("human")) {
					if (landedProperty.getUserInput().equalsIgnoreCase("y")) {
						if (p.getBalance() - landedProperty.getHouseCost() >= 0) {
							consoleLabel.setText(consoleLabel.getText() + "\nYou just bought a house.");
						}
						else {
							consoleLabel.setText(consoleLabel.getText() + "\nSorry You do not have enough money to buy this");
						}
					}
				}
				else {
					if (landedProperty.getPrice() <= p.getBalance() * 0.4);
						consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
				}
			}
		}
	}

	public void railroadlPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText(consoleLabel.getText() + "\nYou have to pay the owner of the railroad!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?\nThe price is " + landedProperty.getPrice());
				if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
				}
				if (p.getBalance() - landedProperty.getPrice() < 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nSorry you do not have enough money to buy " + landedProperty.getName());
				}
			} else {
				if (landedProperty.getPrice() <= p.getBalance() * 0.4);
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
			}
		}
	}

	public void utilityPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText(consoleLabel.getText() + "\nYou have to pay the owner of the utility!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?\nThe price is " + landedProperty.getPrice());
				if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
				}
				if (p.getBalance() - landedProperty.getPrice() < 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nSorry you do not have enough money to buy " + landedProperty.getName());
				}
			} else {
				if (landedProperty.getPrice() <= p.getBalance() * 0.4);
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
			}
		}
	}

	public void chanceInteraction(Player p, Board gameBoard, Property landedProperty) {
		consoleLabel.setText(consoleLabel.getText() + "\nDrawing a card from the deck...");
		int randomIndex = (int)(Math.random() * (gameBoard.getChanceDeck().size() + 1));
		Card cardDrawn = gameBoard.getChanceDeck().get(randomIndex);
		consoleLabel.setText(consoleLabel.getText() + "\n" + cardDrawn.getDesc());
		landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, cardDrawn);
	}

	public void chestInteraction(Player p, Board gameBoard, Property landedProperty) {
		consoleLabel.setText(consoleLabel.getText() + "\nDrawing a card from the deck...");
		int randomIndex = (int)(Math.random() * (gameBoard.getCommunityDeck().size() + 1));
		Card cardDrawn = gameBoard.getCommunityDeck().get(randomIndex);
		consoleLabel.setText(consoleLabel.getText() + "\n" + cardDrawn.getDesc());
		landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, cardDrawn);
	}
	
	
	/**
	 * possible implementation of human vs ai interaction to make code more clean and actually display what we want it to display.
	 * or make the computer class set the user input to yes if they make a certain decision and surround the alert prompt to check to see if they are human ***
	 * 
	 * 
	 * */
	
	public void taxInteraction(Player p, Board gameBoard, Property landedProperty) {
		switch (p.getPosition()) {
		
		case 4: 
			alertPrompt(p, "You have the option of either paying 10% of your balance or paying $200. Press yes to pay 10% or no to pay $200.");
			if (landedProperty.getUserInput().equals("y")) {
				consoleLabel.setText(consoleLabel.getText() + "\nYou paid 10% of your balance.");
			}
			else {
				consoleLabel.setText(consoleLabel.getText() + "\nYou paid $200.");
			}
			break;
		
		case 38: 
			consoleLabel.setText(consoleLabel.getText() + "\nYou paid $100 of.");
			break;
			
		}	
		
	}

	public void jailPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (p.getInJail() == true) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				alertPrompt(p, "You are in jail. Would you like to pay $50 to get out this turn? (y/n)");
				String userInput = landedProperty.getUserInput();
				if (userInput.equalsIgnoreCase("y")) {
					p.loseMoney(50);
					p.setInJail(false);
					consoleLabel.setText(consoleLabel.getText() + "\nNice you are out of jail!");
					gameBoard.rollDice();
				}
				else {
					gameBoard.rollDice();
					if (gameBoard.isDouble()) {
						p.setInJail(false);
						consoleLabel.setText(consoleLabel.getText() + "\nHey you rolled a double! You are Free!");
						p.movePosition(gameBoard.getDice1() + gameBoard.getDice2());
					}
					else {
						consoleLabel.setText(consoleLabel.getText() + "\nDamn you suck at rolling. Try again next turn!");
					}
				}
			} else {
				if (landedProperty.getPrice() <= p.getBalance() * 0.4);
					consoleLabel.setText(consoleLabel.getText() + "\nYou just bought " + landedProperty.getName());
			}
		}
	}
	
	//figure out where to implement this***
	//checks to see if anyone is bankrupt and runs the needed code to remove the player and liquidate the assets
	public void checkGameState(Board board) {
			
			if (board.someoneIsBankrupt()) {
				board.liquidateAssets();
				playerCount--;
			}
			
			if (board.getAllPlayers().size() == 1) {
				gameOver = true;
			}

	}
	
	
	
	

	public void afterLand(Player p, Board gameBoard) {
		Property landedProperty = gameBoard.getProperties().get(p.getPosition());
		consoleLabel.setText(consoleLabel.getText() + "\nYou just landed on " + landedProperty.getName());
		if (p.getPosition() >= 0 && p.getPreviousPosition() <= 0) {
			consoleLabel.setText(consoleLabel.getText() + "\nYou passed go, Collect $50");
		}
		switch (p.getPosition()) {
		case 0:
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 1:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 2:
			chestInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 3:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 4:
			taxInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 5:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 6:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 7:
			chanceInteraction(p, gameBoard, landedProperty);
			break;
		case 8:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 9:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 10:
			if (p.getInJail() == false) {
				consoleLabel.setText(consoleLabel.getText() + "\nYou passed Jail, nothing happened");
			}
			else {
				jailPropertyInteraction(p, gameBoard, landedProperty);
				landedProperty.doActionBeforeLeavingHere(p, d1 + d2, gameBoard);
			}
			break;
		case 11:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 12:
			utilityPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 13:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 14:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 15:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 16:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 17:
			chestInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 18:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 19:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 20:
			break;
		case 21:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 22:
			chanceInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 23:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 24:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 25:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, 0, gameBoard, null);
			break;
		case 26:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 27:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 28:
			utilityPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 29:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 30:
			consoleLabel.setText(consoleLabel.getText() + "\nGo to Jail");
			p.setPosition(10);
			p.setInJail(true);
			break;
		case 31:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 32:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 33:
			chestInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 34:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 35:
			railroadlPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 36:
			chanceInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 37:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 38:
			taxInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		case 39:
			normalPropertyInteraction(p, gameBoard, landedProperty);
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, null);
			break;
		}
	}
}