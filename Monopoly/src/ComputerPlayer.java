
public class ComputerPlayer extends Player {

	public ComputerPlayer(String avatar, Board board) {
		super(avatar, board);
		setPlayerType("computer");
	}
	
	public void buyProperty(Property theProperty)
	{
		//if the property is less than or equal to 40% of your balance
		if(theProperty.getPrice() <= getBalance() * 0.4)
		{
			theProperty.setOwner(this);
			getPlayerProperties().add(theProperty);
			setBalance(getBalance() - theProperty.getPrice());
			
		}
	}
	
	

}
