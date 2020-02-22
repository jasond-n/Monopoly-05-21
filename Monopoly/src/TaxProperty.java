public class TaxProperty extends Property {
	public TaxProperty(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int mortgageValue, String owner, String name)
	{
		super(price, positionOnBoard, rentBase, rent1House, rent2House, rent3House, mortgageValue, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, Move move, Board board)
	{
		player.loseMoney(this.getPrice());
		
		System.out.println(player.getAvatar() + " landed on " + this.getName() + " and paid $" + this.getPrice() + " tax");
	}
}
