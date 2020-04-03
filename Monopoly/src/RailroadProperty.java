
public class RailroadProperty extends Property {
	//constructor that takes the super constructor
	public RailroadProperty(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, Player owner, String name, String color)
	{
		super(price, positionOnBoard, rentBase, rent1House, rent2House, rent3House, owner, name, color);
	}
	
	/**
	 * runs according code depending on if your human or not.
	 * allows to buy property, or pay the owner
	 * */
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board) {
		String userInput;
		int counter = 0;
		
		if(noOneOwns(player, board))
		{
			//will wait for the show and wait
			//continue from here
			//the player is human so we have to wait for input
			if (player.getPlayerType().equals("human")) {
				userInput = getUserInput();
				
				if (userInput.equalsIgnoreCase("y")) {
					player.buyProperty(board.getProperties().get(player.getPosition()));
				}
			}
			else { //the player is a computer and will run the needed logic
				player.buyProperty(board.getProperties().get(player.getPosition()));
			}
		}
		//if you are not the owner
		//now you must pay rent
		else if(youAreNotOwner(player, board))
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
