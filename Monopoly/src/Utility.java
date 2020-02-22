import java.util.Scanner;
public class Utility extends Property {

	public Utility(int price, int positionOnBoard, int rentBase, int rent1House, int mortgageValue, String owner, String name)
	{
		super(price, positionOnBoard, rentBase, rent1House, mortgageValue, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, Move move, Board board)
	{
		String userInput;
		
		if(this.getOwner() == "n/a")
		{
			// write the code to ask the player "Do you want to buy this utility?
			Scanner sc = new Scanner(System.in);
				System.out.print("Do you want to buy " + name + "? (y/n)");
				userInput = sc.next();
				if (userInput.equalsIgnoreCase("y")) {
					setOwner(player.getAvatar());
					player.loseMoney(getPrice());
				}
			sc.close();
		}
		// if the owner of this utility is not the player who landed, then you need a nested statement to check if this owner also own other utility, 
		// if yes, you pay 10 * roll. if they don't own both, that's 4 * roll.
		else if(this.getOwner() != player.getAvatar())
		{
			//if(board.)
		}
		else
		{
			// Roll x 
			
			//if()
		}
	}
}
