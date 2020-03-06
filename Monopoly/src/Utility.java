import java.util.Scanner;
public class Utility extends Property {

	public Utility(int price, int positionOnBoard, int rentBase, int rent1House, int mortgageValue, Player owner, String name, String color)
	{
		super(price, positionOnBoard, rentBase, rent1House, mortgageValue, owner, name, color);
	}

	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
	{
		String userInput;
		
		if(this.getOwner() == null)
		{
			// write the code to ask the player "Do you want to buy this utility?
			Scanner sc = new Scanner(System.in);
				System.out.print("Do you want to buy " + getName() + "? (y/n)");
				userInput = sc.next();
				if (userInput.equalsIgnoreCase("y")) {
					if (player.getBalance() - getPrice() >= 0) {
						setOwner(player);
						player.addPlayerProperty(board.getProperties().get(getPositionOnBoard()));
						player.loseMoney(getPrice());
						System.out.println("You just bought: " + getName());
					}
				}
			//sc.close();
		}
		// if the owner of this utility is not the player who landed, then you need a nested statement to check if this owner also own other utility, 
		// if yes, you pay 10 * roll. if they don't own both, that's 4 * roll.
		else if((board.getProperties().get(12).getOwner() != player) || (board.getProperties().get(28).getOwner() != player))
		{
			if((board.getProperties().get(12).getOwner() == board.getProperties().get(28).getOwner()) &&  board.getProperties().get(12).getOwner() != null) {
				player.loseMoney(roll * 10);
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(roll * 10);
			}
			else {
				//lose money equal to 4 times
				player.loseMoney(roll * 4);
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(roll * 4);
			}
			
		}
	}
}
