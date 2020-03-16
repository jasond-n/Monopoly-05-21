
public class computerPlayer extends Player {

	public computerPlayer(String avatar, Board board) {
		super(avatar, board);
		setPlayerType("computer");
	}
	
	public Boolean buyProperty(Property theProperty)
	{
		//if the property is less than or equal to 40% of your balance
		if(theProperty.getPrice() <= getBalance() * 0.4)
		{
			theProperty.setOwner(this);
			getPlayerProperties().add(theProperty);
			setBalance(getBalance() - theProperty.getPrice());
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
