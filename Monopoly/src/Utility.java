
public class Utility extends Property {

	public Utility(int price, int positionOnBoard, int rentBase, int rent1House, int mortgageValue, String owner, String name)
	{
		super(price, positionOnBoard, rentBase, rent1House, mortgageValue, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, Move move)
	{
		if(this.getOwner() == "n/a")
		{
			// write the code to ask the player "Do you want to buy this utility?"
			
		}
		else if(this.getOwner() == player)
		{
			// Do nothing
		}
		else
		{
			
		}
	}
}
