
public class RailroadProperty extends Property {
	public RailroadProperty(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int mortgageValue, Player owner, String name, String color)
	{
		super(price, positionOnBoard, rentBase, rent1House, rent2House, rent3House, mortgageValue, owner, name, color);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board) {
		String userInput;
		int counter = 0;
		
		if(this.getOwner() == null)
		{
			// write the code to ask the player "Do you want to buy this railroad?
			//Scanner sc = new Scanner(System.in);
				//System.out.print("Do you want to buy " + getName() + "? (y/n)");
				userInput = getUserInput();
				
				if (userInput.equalsIgnoreCase("y")) {
					if (player.getBalance() - getPrice() >= 0) {
						setOwner(player);
						player.loseMoney(getPrice());
						player.addPlayerProperty(board.getProperties().get(player.getPosition()));
						//System.out.println("You just bought: " + getName());
					}
				}
			//sc.close();
		}
		//if you are not the owner
		//now you must pay rent
		else if(board.getProperties().get(player.getPosition()).getOwner() != player && board.getProperties().get(player.getPosition()).getOwner() != null)
		{
			//System.out.println("You have to pay the owner of the property!");
			if (counter >= 0) {
				for(int i = 0; i < board.getProperties().get(player.getPosition()).getOwner().getPlayerProperties().size(); i++) {
					if (board.getProperties().get(player.getPosition()).getOwner().getPlayerProperties().get(i).getColor().equals("black")) {
						counter++;
					}
				}
				switch(counter) {
				case 1: 
					player.loseMoney(getRentBase());
					board.getProperties().get(player.getPosition()).getOwner().addMoney(getRentBase());
					break;
				case 2: 
					player.loseMoney(getRent1House());
					board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent1House());
					break;
				case 3: 
					player.loseMoney(getRent2House());
					board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent2House());
					break;
				case 4: 
					player.loseMoney(getRent3House());
					board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent3House());
					break;
				}
			}
		}
	}
}
