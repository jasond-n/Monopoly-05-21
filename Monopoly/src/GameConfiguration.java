
import java.util.Scanner;

public class GameConfiguration {
	
	private static Board gameBoard;
	
	public static void main(String[] args) {
		final int startPosition = 1;
		
		gameBoard = new Board();
		
		
		Player player1 = new Player("Bob");
		Player player2 = new Player("Sally");
		int turn = 0; //counter to determine turn
		//Player player3 = new Player("n/a");
		//Player player4 = new Player("n/a");
		
		Scanner sc = new Scanner(System.in);
		String userInput = "";
		do {
			if (turn == 0) {
				int postion =player1.move(player1.diceRoll());
				
				
				turn = 1;
			}
			else {
				
				
				turn = 0;
			}
			
			
		} while (userInput != "");
		
		
		sc.close();
		
		
		
		
		
		
		
		
		
		//switch statement to handle player move
		switch(startPosition) {
			case 1: break;
		
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
			case 8: break;
			case 9: break;
			case 10: break;
			case 11: break;
			case 12: break;
			case 13: break;
			case 14: break;
			case 15: break;
			case 16: break;
			case 17: break;
			case 18: break;
			case 19: break;
			case 20: break;
			case 21: break;
			case 22: break;
			case 23: break;
			case 24: break;
			case 25: break;
			case 26: break;
			case 27: break;
			case 28: break;
			case 29: break;
			case 30: break;
			case 31: break;
			case 32: break;
			case 33: break;
			case 34: break;
			case 35: break;
			case 36: break;
			case 37: break;
			case 38: break;
			case 39: break;
			case 40: break;
		}
		
		
		
	}

	
	public void update()
	{
		
	}
	
	
	
	
	
	
}
