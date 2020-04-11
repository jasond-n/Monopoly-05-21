// gameConfiguration is a class that starts the game. It is mostly commented out
// because it was used for the text based version of the game, adn this is the GUI version.

public class GameConfiguration {
	private int currentPlayerIndex;
	
	private boolean gameEnd;
	private int numOfPlayers;
	private Board gameBoard;
	private Property landedProperty;
	private int dice;
	private String userInput;
	
	//constructor that initializes the gameboard and houses memory for the current player 
	public GameConfiguration()
	{
		currentPlayerIndex = 0;
		gameEnd = false;
		numOfPlayers = 0;
		gameBoard = new Board();
		dice = 0;
		userInput = "";
	}
	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}
	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}
}


//	private static Board gameBoard;
//	public static void main(String[] args) {
//		System.out.println("Generating board...");
//		gameBoard = new Board();
//		System.out.println(gameBoard.toString());
//		
//		Scanner sc = new Scanner(System.in);
//		
//		
//		System.out.println("How many players are playing: (2-4) ");
//		int numOfPlayers = sc.nextInt();
//		while (numOfPlayers < 2 || numOfPlayers > 4)
//		{
//			System.out.println("The number that you entered is not between 2-4. Please enter again: ");
//			numOfPlayers = sc.nextInt();
//		}
//		
//		for (int i = 1; i <= numOfPlayers; i++)
//		{
//			System.out.println("Player " + i + ", please enter your name now: ");
//			String playerName = sc.next();
//			Player player = new Player(playerName, gameBoard);
//			gameBoard.getAllPlayers().add(player);
//		}
//		
//		//deciding the order for turns
//		gameBoard.decideOrder();
//		
//		
//		// Later on, we need to add win condition or game end condition.
//		//change it to while monopolized for win condition
//		while (gameBoard.getAllPlayers().size() > 1){
//			
//			
//			
//			
//			for(int i = 0; i < numOfPlayers; i++)
//			{
//				
//				if (gameBoard.someoneIsBankrupt()) {
//					gameBoard.liquidateAssets();
//					numOfPlayers--;
//				}
//				
//				Player currentPlayer = gameBoard.getAllPlayers().get(i);
//				System.out.println(gameBoard.getAllPlayers().get(i).getPlayerAllInfo());
//				String ConfirmationOfDiceRoll = "";
//				while(!ConfirmationOfDiceRoll.equalsIgnoreCase("yes"))
//				{
//					System.out.println(currentPlayer.getAvatar() + ", please enter yes to dice roll: ");
//					ConfirmationOfDiceRoll = sc.next();
//				}
//				
//				
//				
//				int dice = 2;
//				Property landedProperty;
//				
//				//hardcode for testing
//				//int dice = 4;
//				
//				if(currentPlayer.getInJail() == false)
//
//				{
//					
//					//dice = gameBoard.rollDice();
//					System.out.println(currentPlayer.getAvatar() + ", you just threw " + dice);
//					currentPlayer.movePosition(dice);
//					
//					landedProperty = gameBoard.getProperties().get(currentPlayer.getPosition());
//					System.out.println(currentPlayer.getAvatar() + ", you moved to " + landedProperty.getName());
//					//now you land on here, what do you do?
//					// call landedProperty doactions after landed here
//					landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
//					
//					if (gameBoard.isDouble()) { //first double
//						
//						dice = gameBoard.rollDice();
//						System.out.println(currentPlayer.getAvatar() + ", you just threw " + dice);
//						currentPlayer.movePosition(dice);
//						
//						landedProperty = gameBoard.getProperties().get(currentPlayer.getPosition());
//						System.out.println(currentPlayer.getAvatar() + ", you moved to " + landedProperty.getName());
//						//now you land on here, what do you do?
//						// call landedProperty doactions after landed here
//						landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
//						
//						
//						if (gameBoard.isDouble()) { //second double
//							
//							dice = gameBoard.rollDice();
//							System.out.println(currentPlayer.getAvatar() + ", you just threw " + dice);
//							currentPlayer.movePosition(dice);
//							
//							landedProperty = gameBoard.getProperties().get(currentPlayer.getPosition());
//							System.out.println(currentPlayer.getAvatar() + ", you moved to " + landedProperty.getName());
//							//now you land on here, what do you do?
//							// call landedProperty doactions after landed here
//							landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
//							
//							
//							
//							if (gameBoard.isDouble()) { //third double
//								currentPlayer.setPosition(10);
//								currentPlayer.setInJail(true);
//								landedProperty = gameBoard.getProperties().get(currentPlayer.getPosition());
//								System.out.println(currentPlayer.getAvatar() + ", you moved to " + landedProperty.getName());
//								//now you land on here, what do you do?
//								// call landedProperty doactions after landed here
//								landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
//							}
//						}
//					}
//					
//						
//				}
//				// The logic when you are in jail
//				else {
//					landedProperty = gameBoard.getProperties().get(10);
//					landedProperty.doActionBeforePlayerLeavingHere(currentPlayer, dice, gameBoard);
//					if (currentPlayer.getInJail() == false) {
//						currentPlayer.movePosition(gameBoard.getDice1() + gameBoard.getDice2());
//						
//						landedProperty = gameBoard.getProperties().get(currentPlayer.getPosition());
//						System.out.println(currentPlayer.getAvatar() + ", you moved to " + landedProperty.getName());
//						
//						//now you land on here, what do you do?
//						// call landedProperty doactions after landed here
//						landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
//					}
//				}
//									
//				String confirmationOfEndTurn = "";
//				while(!confirmationOfEndTurn.equalsIgnoreCase("yes"))
//				{
//					System.out.println(currentPlayer.getAvatar() + ", please enter yes to end your turn: ");
//					confirmationOfEndTurn = sc.next();
//				}
//			}
//		}
//		//sc.close();	
//		
//	}
