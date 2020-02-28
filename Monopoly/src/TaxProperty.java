import java.util.Scanner;
import java.lang.Math;
public class TaxProperty extends Property {
	public TaxProperty(int positionOnBoard, String name)
	{
		super(positionOnBoard, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
	{
		int userInput;
		
		if (player.getBalance() > 0) {
			switch (player.getPosition()) {
			case 4: //if they land on the first tax spot
				Scanner sc = new Scanner(System.in);
					System.out.print("Enter 1 to pay 10 percent of your income, or 2 to pay 200 dollars: ");
					userInput = sc.nextInt();
					
					if (userInput == 1) {
						System.out.println("You just lost $" + (int)Math.round(player.getBalance() * 0.1)); //take this out later
						player.loseMoney((int)Math.round(player.getBalance() * 0.1));
					}
					
					if (userInput == 2) {
						System.out.println("You just lost $200"); //take this out later
						player.loseMoney(200);
					}
				//sc.close();
				break;
			case 20: //if you land on free parking
				System.out.println("You just landed on free parking!");
				break;
			case 38: 
				System.out.println("You just lost $100"); //take this out later
				player.loseMoney(100);
				break;
		
		
			}
		}
		
	}
}
