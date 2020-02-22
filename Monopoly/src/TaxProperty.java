public class TaxProperty extends Property {
	public TaxProperty(int positionOnBoard, String name)
	{
		super(positionOnBoard, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player player, Move move, Board board)
	{
		player.loseMoney(this.getPrice());
		
		System.out.println(player.getAvatar() + " landed on " + this.getName() + " and paid $" + this.getPrice() + " tax");
	}
}
