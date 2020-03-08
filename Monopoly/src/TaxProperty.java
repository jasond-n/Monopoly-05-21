import java.util.Scanner;
import java.lang.Math;
public class TaxProperty extends Property {
	public TaxProperty(int positionOnBoard, Player owner, String name)
	{
		super(positionOnBoard, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
	{
		String userInput;
		
		if (player.getBalance() > 0) {
			switch (player.getPosition()) {
			case 4: //if they land on the first tax spot
				Scanner sc = new Scanner(System.in);
					//System.out.print("Enter ok to pay 10 percent of your income, or cancel to pay 200 dollars: ");
					userInput = getUserInput();
					
					if (userInput.equals("y")) {
						//System.out.println("You just lost $" + (int)Math.round(player.getBalance() * 0.1)); //take this out later
						player.loseMoney((int)Math.round(player.getBalance() * 0.1));
					}
					
					if (userInput.equals("n")) {
						//System.out.println("You just lost $200"); //take this out later
						player.loseMoney(200);
					}
				//sc.close();
				break;
			case 20: //if you land on free parking
				//System.out.println("You just landed on free parking!");
				break;
			case 38: 
				//System.out.println("You just lost $100"); //take this out later
				player.loseMoney(100);
				break;
		
		
			}
		}
		
	}
}
