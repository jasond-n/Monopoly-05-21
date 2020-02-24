
import java.util.ArrayList;
import java.util.Scanner;

public class GameConfiguration {
	
	private static Board gameBoard;
	
	public static void main(String[] args) {
		final int startPosition = 1;
		
		System.out.println("Generating board...");
		gameBoard = new Board();
		System.out.println(gameBoard.toString());
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("How many players are playing: (2-4) ");
		int numOfPlayers = sc.nextInt();
		while (numOfPlayers < 2 || numOfPlayers > 4)
		{
			System.out.println("The number that you entered is not between 2-4. Please enter again: ");
			numOfPlayers = sc.nextInt();
		}
		
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		
		for (int i = 1; i <= numOfPlayers; i++)
		{
			System.out.println("Player " + i + ", please enter your name now: ");
			String playerName = sc.next();
			Player player = new Player(playerName, gameBoard);
			allPlayers.add(player);
		}
		
		
		// Later on, we need to add win condition or game end condition.
		while (true){
			for(int i = 0; i < numOfPlayers; i++)
			{
				Player currentPlayer = allPlayers.get(i);
				System.out.println(allPlayers.get(i).getPlayerAllInfo());
				String ConfirmationOfDiceRoll = "";
				while(!ConfirmationOfDiceRoll.equalsIgnoreCase("yes"))
				{
					System.out.println(currentPlayer.getAvatar() + ", please enter yes to dice roll: ");
					ConfirmationOfDiceRoll = sc.next();
				}
				
				int dice = currentPlayer.rollDice();
				
				//hardcode for testing
				//int dice = 4;
				System.out.println(currentPlayer.getAvatar() + ", you just threw " + dice);
				if(currentPlayer.getInjail() != true)
				{
					currentPlayer.movePosition(dice);
					
					Property landedProperty = gameBoard.getProperties().get(currentPlayer.getPosition());
					System.out.println(currentPlayer.getAvatar() + ", you moved to " + landedProperty.getName());
					
					//now you land on here, what do you do?
					// call landedProperty doactions after landed here
					landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
						
				}
				// The logic when you are in jail
				else
				{
					//System.out.println("You are in the Jail now. You need to throwing doubles on the next " + (2 - currentPlayer.getCounterOfRollForLeaveJail()) + " turns.");
					if(dice % 2 == 0)
					{
						currentPlayer.setCounterOfRollForLeaveJail(currentPlayer.getCounterOfRollForLeaveJail() + 1);
					}
					else
					{
						currentPlayer.setCounterOfRollForLeaveJail(0);
					}
					if(currentPlayer.getCounterOfRollForLeaveJail() == 2)
					{
						currentPlayer.setCounterOfRollForLeaveJail(0);
						
						currentPlayer.movePosition(dice);
						int currentPosition = currentPlayer.getPosition();
						Property landedProperty = gameBoard.getProperties().get(currentPosition);
						
						//now you land on here, what do you do?
						// call landedProperty doactions after landed here
						landedProperty.doActionAfterPlayerLandingHere(currentPlayer, dice, gameBoard);
					}
				}
									
				String confirmationOfEndTurn = "";
				while(!confirmationOfEndTurn.equalsIgnoreCase("yes"))
				{
					System.out.println(currentPlayer.getAvatar() + ", please enter yes to end your turn: ");
					confirmationOfEndTurn = sc.next();
				}
			}
		}
		//sc.close();		
	}

	
	public void update()
	{
		
	}
}
