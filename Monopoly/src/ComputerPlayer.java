//a child class of player with logic to buy property and has type COMPUTER which is used to differentiate what to print to the console in the gameController
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
			getProperties().add(theProperty);
			setBalance(getBalance() - theProperty.getPrice());
			
		}
	}
	
	

}
