import java.util.Scanner;
public class RailroadProperty extends Property {
	public RailroadProperty(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int mortgageValue, Player owner, String name)
	{
		super(price, positionOnBoard, rentBase, rent1House, rent2House, rent3House, mortgageValue, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board) {
		String userInput;
		// buy property meaning no owner
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
		//has owner. Player must buy rent to owner
		else if (board.getProperties().get(getPositionOnBoard()).getOwner() != player && board.getProperties().get(getPositionOnBoard()).getOwner() != null) {
		System.out.println("You have to pay the owner of the property!");
		if (getNumOfHotels() == 0) {
			switch(getNumOfHouses()) {
			case 0: 
				player.loseMoney(getRentBase());
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRentBase());
				break;
			case 1: 
				player.loseMoney(getRent1House());
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent1House());
				break;
			case 2: 
				player.loseMoney(getRent2House());
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent2House());
				break;
			case 3: 
				player.loseMoney(getRent3House());
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent3House());
				break; 
			case 4: 
				player.loseMoney(getRent4House());
				board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent4House());
				break;
				}
			}
		
		if (getNumOfHotels() == 1) {
			player.loseMoney(getRentHotel());
			board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRentHotel());
			}
		}
	}
}
