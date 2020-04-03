import java.net.URL;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout. * ;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class GameController {
	private GameConfiguration gameConfiguration = new GameConfiguration();
	private Player currentPlayer = new Player("", gameConfiguration.getGameBoard());
	private boolean gameOver = false;
	private int d1, d2, currentPlayerIndex, playerCount, humanPlayerCount, aiPlayerCount;
	
    public void setPlayerCount(int playerCount) {
    	this.playerCount = playerCount; 
    }
    
    public int getPlayerCount() {
    	return playerCount;
    }
    
    public void setHumanPlayerCount(int humanPlayerCount) {
    	this.humanPlayerCount = humanPlayerCount; 
    }
    
    public int getHumanPlayerCount() {
    	return humanPlayerCount;
    }
    
    public void setAIPlayerCount(int aiPlayerCount) {
    	this.aiPlayerCount = aiPlayerCount; 
    }
    
    public int getAIPlayerCount() {
    	return aiPlayerCount;
    }
    
	public void setCurrentPlayer(Player p) {
		currentPlayer = p;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}



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
	//private Icon icon1 = new Icon(Color.RED);
	private Icon icon1 = new Icon(new Image("/images/dinos.png",false));

	@FXML
	//private Icon icon2 = new Icon(Color.BLUE);
	private Icon icon2 = new Icon(new Image("/images/MonopolyMan.jpeg",false));

	@FXML
	//private Icon icon3 = new Icon(Color.YELLOW);
	private Icon icon3 = new Icon(new Image("/images/sait.png",false));

	@FXML
	//private Icon icon4 = new Icon(Color.GREEN);
	private Icon icon4 = new Icon(new Image("/images/UofCCoat.png",false));

	@FXML
	private Pane boardPane;

	@FXML
	private Label consoleLabel;
	
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		alertPromptPlayerCount();
		boardPane.getChildren().add(icon1);
		icon1.movePlayer1(0);
		boardPane.getChildren().add(icon2);
		icon2.movePlayer2(0);
		if(playerCount >= 3)
		{
			boardPane.getChildren().add(icon3);
			icon3.movePlayer3(0);
		}
		if(playerCount >= 4)
		{
			boardPane.getChildren().add(icon4);
			icon4.movePlayer4(0);
		}
		gameConfiguration.setCurrentPlayerIndex(0);
		StartGame();
	}
	
	// adds the players and their names into an arrayList
	public void StartGame() {
		for (int i = 0; i < getHumanPlayerCount(); i++) {
			String playerName = "Human Player" + (i + 1);
			Player player = new Player(playerName, gameConfiguration.getGameBoard());
			gameConfiguration.getGameBoard().getAllPlayers().add(player);
		}
		
		for (int i = 0; i < getAIPlayerCount(); i++) {
			String playerName = "AI Player" + (i + 1);
			Player player = new ComputerPlayer(playerName, gameConfiguration.getGameBoard());
			gameConfiguration.getGameBoard().getAllPlayers().add(player);
		}
		
		updateMoney();
		consoleLabel.setText("Player 1, please dice roll now: ");
	}

	//updates the balances of each player on the gui
	public void updateMoney() {
		Board gameBoard = gameConfiguration.getGameBoard();
		Player player1 = gameBoard.getAllPlayers().get(0);
		Player player2 = gameBoard.getAllPlayers().get(1);
		Player player3 = gameBoard.getAllPlayers().get(2);
		Player player4 = gameBoard.getAllPlayers().get(3);
		if(playerCount == 2)
		{
			p1Balance.setText(player1.getAvatar() + " Balance: $" + player1.getBalance());
			p2Balance.setText(player2.getAvatar() + " Balance: $" + player2.getBalance());
		}
		else if(playerCount == 3)
		{
			p1Balance.setText(player1.getAvatar() + " Balance: $" + player1.getBalance());
			p2Balance.setText(player2.getAvatar() + " Balance: $" + player2.getBalance());
			p3Balance.setText(player3.getAvatar() + " Balance: $" + player3.getBalance());
		}
		else if(playerCount == 4)
		{
			p1Balance.setText(player1.getAvatar() + " Balance: $" + player1.getBalance());
			p2Balance.setText(player2.getAvatar() + " Balance: $" + player2.getBalance());
			p3Balance.setText(player3.getAvatar() + " Balance: $" + player3.getBalance());
			p4Balance.setText(player4.getAvatar() + " Balance: $" + player4.getBalance());
		}
	}
	
	/**
	 * runs when the roll button is clicked in the gui
	 * rolls the dice and moves the player accordingly
	 * */
	@FXML
	public void diceroll(ActionEvent event) {
		if (!gameOver) { //checks to see if the size of the arraylist of players is 1, if not, runs this code
			gameConfiguration.getGameBoard().rollDice();
			d1 = gameConfiguration.getGameBoard().getDice1();
			d2 = gameConfiguration.getGameBoard().getDice2();
	
			consoleLabel.setText(consoleLabel.getText() + "You diced " + (d1 + d2));
			if (getCurrentPlayer().getInJail() == false) {
				movePlayer(d1, d2);
//				if (d1 == d2) {
//					consoleLabel.setText(consoleLabel.getText() + "\nNice you Rolled a double!");
//					gameConfiguration.getGameBoard().rollDice();
//					movePlayer(d1, d2);
//	
//					if (d1 == d2) {
//						consoleLabel.setText(consoleLabel.getText() + "\nNice you Rolled a double!");
//						gameConfiguration.getGameBoard().rollDice();
//						movePlayer(d1, d2);
//	
//						if (d1 == d2) {
//							consoleLabel.setText(consoleLabel.getText() + "\nYou rolled 3 doubles in a roll. Move to jail!");
//							getCurrentPlayer().setPosition(10);
//							getCurrentPlayer().setInJail(true);
//						}
//					}
//				}
			}
			//test this line
			//checks to see if anyone's balance is negative and takes them out if they are
			checkGameState(gameConfiguration.getGameBoard());
			//determines who's turn is next
			if (getPlayerCount() > 1) {
				//gameConfiguration.setCurrentPlayer((gameConfiguration.getCurrentPlayer() + 1) % getPlayerCount());
				consoleLabel.setText(consoleLabel.getText() + ";\nNow, " + gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayerIndex()).getAvatar() + "'s turn; ");
			}
			updateMoney();	
		}
		else {
			consoleLabel.setText(consoleLabel.getText() + ";\nGame Over! The winner is: " + gameConfiguration.getGameBoard().getAllPlayers().get(0));
		}
	}

	/**
	 * Moves the current player based on their roll and then does the interaction based on what square they landed on
	 * */
	public void movePlayer(int d1, int d2) {
		
			switch (gameConfiguration.getCurrentPlayerIndex()) {
			case 0:
				for (int i = 0; i < d1 + d2; i++) {
					icon1.updateLocation();
				}
				setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayerIndex()));
				getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + d1 + d2);
				getCurrentPlayer().setPreviousPosition(d1 + d2);
			
				break;
			case 1:
				for (int i = 0; i < d1 + d2; i++) {
					icon2.updateLocation();
				}
				setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayerIndex()));
				getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + d1 + d2);
				getCurrentPlayer().setPreviousPosition(d1 + d2);
				
				break;
			case 2:
				for (int i = 0; i < d1 + d2; i++) {
					icon3.updateLocation();
				}
				setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayerIndex()));
				getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + d1 + d2);
				getCurrentPlayer().setPreviousPosition(d1 + d2);
				
				break;
			case 3:
				for (int i = 0; i < d1 + d2; i++) {
					icon4.updateLocation();
				}
				setCurrentPlayer(gameConfiguration.getGameBoard().getAllPlayers().get(gameConfiguration.getCurrentPlayerIndex()));
				getCurrentPlayer().setPosition(getCurrentPlayer().getPosition() + d1 + d2);
				getCurrentPlayer().setPreviousPosition(d1 + d2);
				break;
			}
			
			gameConfiguration.setCurrentPlayerIndex((gameConfiguration.getCurrentPlayerIndex() + 1) % getPlayerCount());
			afterLand(getCurrentPlayer(), gameConfiguration.getGameBoard());
		}

	
		
		
	
	// On startup. You must pick the number of human players you want and we will fill the rest with ai players.
	public void alertPromptPlayerCount() {
		Alert alert = new Alert(AlertType.NONE);
		Image image = new Image("images/monopoly screen.png");
		ImageView imageView = new ImageView(image);
		alert.setGraphic(imageView);
		imageView.setFitWidth(240);
	    imageView.setFitHeight(160);
		alert.setTitle("Please make a decision");
		alert.setHeaderText("Enter the amount of human players you want.");

		ButtonType button1 = new ButtonType("1");
		alert.getButtonTypes().add(button1);
		ButtonType button2 = new ButtonType("2");
		alert.getButtonTypes().add(button2);
		ButtonType button3 = new ButtonType("3");
		alert.getButtonTypes().add(button3);
		ButtonType button4 = new ButtonType("4");
		alert.getButtonTypes().add(button4);

		Optional <ButtonType> action = alert.showAndWait();
		if (action.get() == button1) {
			setHumanPlayerCount(1);
			setAIPlayerCount(3);
			setPlayerCount(getHumanPlayerCount() + getAIPlayerCount());
		}
		else if (action.get() == button2){
			setHumanPlayerCount(2);
			setAIPlayerCount(2);
			setPlayerCount(getHumanPlayerCount() + getAIPlayerCount());
		}
		else if (action.get() == button3){
			setHumanPlayerCount(3);
			setAIPlayerCount(1);
			setPlayerCount(getHumanPlayerCount() + getAIPlayerCount());
		}
		else {
			setHumanPlayerCount(4);
			setAIPlayerCount(0);
			setPlayerCount(getHumanPlayerCount() + getAIPlayerCount());
		}
	}

	// used as our main decision function. Creates a show and wait and based on teh button they click, the according code is executed
	//parameters are the current player and the message that needs to be displayed in the alert prompt
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

	//used by the afterland method
	//runs certain code depending on if the player is ai or human
	//can buy property, houses or hotels
	//displayes text to the gui.
	public void normalPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {

		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText(consoleLabel.getText() + p.getAvatar() + " has to pay the owner of the Property!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				System.out.println("stinky 2");
				alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?\nThe price is " + landedProperty.getPrice());
				if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought " + landedProperty.getName());
				}
				if (p.getBalance() - landedProperty.getPrice() < 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nSorry you do not have enough money to buy " + landedProperty.getName());
				}
			}
			else { //you are a computer
				if (landedProperty.getPrice() <= p.getBalance() * 0.4) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought " + landedProperty.getName());
				}
				else {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " decided not to buy " + landedProperty.getName());
				}
			}
		}
		else if (landedProperty.youOwn(p, gameBoard)) {

			if (landedProperty.getNumOfHouses() == 4 && landedProperty.getNumOfHotels() == 0) {
				if (p.getPlayerType().equalsIgnoreCase("human")) {
					
					alertPrompt(p, "Would you like to buy a hotel? \nThe price is " + landedProperty.getHotelCost());

					if (landedProperty.getUserInput().equalsIgnoreCase("y")) {
						if (p.getBalance() - landedProperty.getHotelCost() >= 0) {
							consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought a hotel ");
						}
						else {
							consoleLabel.setText(consoleLabel.getText() + "\nSorry You do not have enough money to buy this");
						}
					}
				}
				else { //computer player
					if (p.getBalance() - landedProperty.getHotelCost() >= 0) {
						consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought a hotel ");
					}
					else {
						consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " decided not to buy a hotel.");
					}
				}
			}
			//asks to buy a house if you have less than 4 houses
			if (landedProperty.getNumOfHouses() < 4 && landedProperty.getNumOfHotels() == 0) {
				
				if (p.getPlayerType().equalsIgnoreCase("human")) {
					
					alertPrompt(p, "Would you like to buy a house? \nThe price is " + landedProperty.getHouseCost());
					
					if (landedProperty.getUserInput().equalsIgnoreCase("y")) {
						if (p.getBalance() - landedProperty.getHouseCost() >= 0) {
							consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought a house ");
						}
						else {
							consoleLabel.setText(consoleLabel.getText() + "\nSorry You do not have enough money to buy this");
						}
					}
				}
				else { //player is computer
					if (p.getBalance() - landedProperty.getHouseCost() >= 0) {
						consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought a house ");
					}
					else {
						consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " decided not to buy a house.");
					}
				}
			}
		}
	}

	//used by the afterland method
	//runs certain code depending on if the player is ai or human
	//can buy property
	//displayes text to the gui.
	public void railroadlPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText(consoleLabel.getText() + "\nYou have to pay the owner of the railroad!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?\nThe price is " + landedProperty.getPrice());
				if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought " + landedProperty.getName());
				}
				if (p.getBalance() - landedProperty.getPrice() < 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nSorry you do not have enough money to buy " + landedProperty.getName());
				}
			}
			else { //you are a computer
				if (landedProperty.getPrice() <= p.getBalance() * 0.4) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought " + landedProperty.getName());
				}
				else {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " decided not to buy " + landedProperty.getName());
				}
			}
		}
	}

	//used by the afterland method
	//runs certain code depending on if the player is ai or human
	//can buy property
	//displayes text to the gui.
	public void utilityPropertyInteraction(Player p, Board gameBoard, Property landedProperty) {
		if (landedProperty.youAreNotOwner(p, gameBoard)) {
			consoleLabel.setText(consoleLabel.getText() + "\nYou have to pay the owner of the utility!");
		}
		else if (landedProperty.noOneOwns(p, gameBoard)) {
			if (p.getPlayerType().equalsIgnoreCase("human")) {
				alertPrompt(p, "Would you like to buy " + landedProperty.getName() + "?\nThe price is " + landedProperty.getPrice());
				if (landedProperty.getUserInput().equals("y") && p.getBalance() - landedProperty.getPrice() > 0) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought " + landedProperty.getName());
				}
				if (p.getBalance() - landedProperty.getPrice() < 0) {
					consoleLabel.setText(consoleLabel.getText() + "\nSorry you do not have enough money to buy " + landedProperty.getName());
				}
			}
			else { //you are a computer
				if (landedProperty.getPrice() <= p.getBalance() * 0.4) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " just bought " + landedProperty.getName());
				}
				else {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " decided not to buy " + landedProperty.getName());
				}
			}
		}
	}
	
	//used by the afterland method
	//runs certain code depending on if the player is ai or human
	//displayes text to the gui.
	public void chanceInteraction(Player p, Board gameBoard, Property landedProperty) {
		consoleLabel.setText(consoleLabel.getText() + "\nDrawing a card from the deck...");
		int randomIndex = (int)(Math.random() * (gameBoard.getChanceDeck().size()));
		Card cardDrawn = gameBoard.getChanceDeck().get(randomIndex);
		
		if (cardDrawn.getType().equals("moveTo")) {
			int tempValue = 0;

            switch (gameConfiguration.getCurrentPlayerIndex()) {
            case 0: 
                tempValue = 3;
                break;
            case 1: 
                tempValue = 0;
                break;
            case 2: 
                tempValue = 1;
                break;
            case 3: 
                tempValue = 2;
                break;
            }


            switch (tempValue) {
            case 0: 
                icon1.movePlayer1(cardDrawn.getValue());
                break;
            case 1: 
                icon2.movePlayer2(cardDrawn.getValue());
                break;
            case 2: 
                icon3.movePlayer3(cardDrawn.getValue());
                break; 
            case 3:
                icon4.movePlayer4(cardDrawn.getValue());
                break;
            }
		}
		else {
			landedProperty.doActionAfterPlayerLandingHere(p, d1 + d2, gameBoard, cardDrawn);
		}
		
		consoleLabel.setText(consoleLabel.getText() + "\n" + cardDrawn.getDesc());
		updateMoney();
	}

	//used by the afterland method
			//runs certain code depending on if the player is ai or human
			//displayes text to the gui.
	public void chestInteraction(Player p, Board gameBoard, Property landedProperty) {
		consoleLabel.setText(consoleLabel.getText() + "\nDrawing a card from the deck...");
		int randomIndex = (int)(Math.random() * (gameBoard.getCommunityDeck().size()));
		Card cardDrawn = gameBoard.getCommunityDeck().get(randomIndex);
		
		if (cardDrawn.getType().equals("moveTo")) {
			int tempValue = 0;

            switch (gameConfiguration.getCurrentPlayerIndex()) {
            case 0: 
                tempValue = 3;
                break;
            case 1: 
                tempValue = 0;
                break;
            case 2: 
                tempValue = 1;
                break;
            case 3: 
                tempValue = 2;
                break;
            }


            switch (tempValue) {
            case 0: 
                icon1.movePlayer1(cardDrawn.getValue());
                break;
            case 1: 
                icon2.movePlayer2(cardDrawn.getValue());
                break;
            case 2: 
                icon3.movePlayer3(cardDrawn.getValue());
                break; 
            case 3:
                icon4.movePlayer4(cardDrawn.getValue());
                break;
            }
		}
		
		
		consoleLabel.setText(consoleLabel.getText() + "\n" + cardDrawn.getDesc());
		updateMoney();
	}
	
	//used by the afterland method
			//runs certain code depending on if the player is ai or human
			//displayes text to the gui.
	public void taxInteraction(Player p, Board gameBoard, Property landedProperty) {
		switch (p.getPosition()) {
		case 4: 
			if (p.getPlayerType().equals("human")) {
				alertPrompt(p, "You have the option of either paying 10% of your balance or paying $200. Press yes to pay 10% or no to pay $200.");
				if (landedProperty.getUserInput().equals("y")) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " paid 10% of your balance.");
				}
				else {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " paid $200 in tax.");
				}
			}
			else {
				if ((int)Math.round(p.getBalance() * 0.1) < 200) {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " paid 10% of your balance.");
				}
				else {
					consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " paid $200 in tax.");
				}
			}
			break;
		case 38: 
			consoleLabel.setText(consoleLabel.getText() + "\n" + p.getAvatar() + " paid $100 in tax.");
			break;
		}		
	}

	//used by the afterland method
	//runs certain code depending on if the player is ai or human
	//can choose to pay 50 to get out of jail
	//displayes text to the gui.
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
			} 
			else { //it is the computer
				if (p.getBalance() - 50 > 0) {
					p.loseMoney(50);
					p.setInJail(false);
					consoleLabel.setText(consoleLabel.getText() + p.getAvatar() + " decided to pay $50 to get out of jail!");
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
			}
		}
	}
	
	//checks to see if anyone is bankrupt and runs the needed code to remove the player and liquidate the assets
	public void checkGameState(Board board) {
			if (board.someoneIsBankrupt()) {
				board.liquidateAssets();
				playerCount--;
				
				consoleLabel.setText(consoleLabel.getText() + "\n Someone went bankrupt! They must give up their assets to the bank");
				consoleLabel.setText(consoleLabel.getText() + "\n Remaining Players: ");
				
				for (int i = 0; i < gameConfiguration.getGameBoard().getAllPlayers().size(); i++) {
					consoleLabel.setText(consoleLabel.getText() + " " + gameConfiguration.getGameBoard().getAllPlayers().get(i));	
				}
			}
			if (board.getAllPlayers().size() == 1) {
				gameOver = true;
			}
	}

	//has a switch case for every spot on the board and runs the according interaction depending
	//these allow messages to be sent to console and displayed on GUI
	public void afterLand(Player p, Board gameBoard) {
		Property landedProperty = gameBoard.getProperties().get(p.getPosition());
		consoleLabel.setText(consoleLabel.getText() + "\nYou just landed on " + landedProperty.getName());
		if (p.getPosition() >= 0 && p.getPreviousPosition() < 0) {
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