
public class Utility extends Property {

	public Utility(int price, int positionOnBoard, int rentBase, int rent1House, int mortgageValue, Player owner, String name, String color)
	{
		super(price, positionOnBoard, rentBase, rent1House, mortgageValue, owner, name, color);
	}

	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
	{
		String userInput;
		
		if(noOneOwns(player, board)) //ask if they want to buy if they are human
		{
			if (player.getPlayerType().equals("human")) {
				userInput = getUserInput();
				if (userInput.equalsIgnoreCase("y")) {
					player.buyProperty(board.getProperties().get(player.getPosition()));
				}
			}
			//computer player
			else {
				player.buyProperty(board.getProperties().get(player.getPosition()));
			}
			
		}
		// if the owner of this utility is not the player who landed, then you need a nested statement to check if this owner also own other utility, 
		// if yes, you pay 10 * roll. if they don't own both, that's 4 * roll.
		else if((board.getProperties().get(12).getOwner() != player) || (board.getProperties().get(28).getOwner() != player))
		{
			if((board.getProperties().get(12).getOwner() == board.getProperties().get(28).getOwner()) &&  board.getProperties().get(12).getOwner() != null) {
				player.loseMoney(roll * 10);
				board.getProperties().get(player.getPosition()).getOwner().addMoney(roll * 10);
			}
			else {
				//lose money equal to 4 times
				player.loseMoney(roll * 4);
				board.getProperties().get(player.getPosition()).getOwner().addMoney(roll * 4);
			}
			
		}
	}
}
