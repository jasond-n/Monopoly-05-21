import java.util.Scanner;
public class RailroadProperty extends Property {
	public RailroadProperty(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int mortgageValue, Player owner, String name)
	{
		super(price, positionOnBoard, rentBase, rent1House, rent2House, rent3House, mortgageValue, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board) {
		String userInput;
		
		if(this.getOwner() == null)
		{
			// write the code to ask the player "Do you want to buy this railroad?
			Scanner sc = new Scanner(System.in);
				System.out.print("Do you want to buy " + getName() + "? (y/n)");
				userInput = sc.next();
				if (userInput.equalsIgnoreCase("y")) {
					if (player.getBalance() - getPrice() >= 0) {
						setOwner(player);
						player.loseMoney(getPrice());
						System.out.println("You just bought: " + getName());
					}
				}
			//sc.close();
		}
		//if you are not the owner
		//now you must pay rent
		else if(board.getProperties().get(getPositionOnBoard()).getOwner() != player && board.getProperties().get(getPositionOnBoard()).getOwner() != null)
		{
			System.out.println("You have to pay the owner of the property!");
			player.loseMoney(getRentBase());
		}
		
	}
}
