
import java.util.ArrayList;
import java.util.Scanner;

public class GameConfiguration {
	
	private static Board gameBoard;
	
	public static void main(String[] args) {
		final int startPosition = 1;
		
		
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
			Player player = new Player(playerName);
			allPlayers.add(player);
		}
		
		System.out.println("Generating board...");
		gameBoard = new Board();
		System.out.println("gameBoard.toString()");
		// Later on, we need to add win condition or game end condition.
		while (true){
			for(int i = 0; i < numOfPlayers; i++)
			{
				
				System.out.println(allPlayers.get(i).getPlayerAllInfo());
				String ConfirmationOfDiceRoll = "";
				while(ConfirmationOfDiceRoll != "yes")
				{
					System.out.println("Player " + (i+1) + ", please enter yes to dice roll: ");
					ConfirmationOfDiceRoll = sc.next();
				}
				
				int dice = 4;
				Player currentPlayer = allPlayers.get(i);
				
				
				currentPlayer.movePosition(dice);
				
				
				int currentPosition = currentPlayer.getPosition();
				Property landedProperty = gameBoard.getProperties().get(currentPosition);
				//now you land on here, what do you do?
				System.out.print(currentPlayer.getPosition());
				sc.next();
			}
		}
		//sc.close();		
	}

	
	public void update()
	{
		
	}
}
