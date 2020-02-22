import java.util.ArrayList;
import java.lang.Math;

public class Player {

	private final int INITIAL_BALANCE = 1500;
	
	private String avatar;
	private ArrayList<Property> properties;
	private int balance;
	private int position;
	private Boolean injail;
	private int location;
	private int counterOfRollForLeaveJail;
	private Board board;
	
	public Player(String avatar, Board board)
	{
		this.avatar = avatar;
		this.balance = INITIAL_BALANCE;
		this.position = 0;
		this.properties = new ArrayList<Property>();
		this.injail = false;
		this.location = 1;
		this.counterOfRollForLeaveJail = 0;
		this.board = board;
	}
	
	
	
	public int getCounterOfRollForLeaveJail() {
		return counterOfRollForLeaveJail;
	}

	public void setCounterOfRollForLeaveJail(int counterOfRollForLeaveJail) {
		this.counterOfRollForLeaveJail = counterOfRollForLeaveJail;
	}

	public void sellProperty(Property theProperty)
	{
		theProperty.setOwner(null);
		this.properties.remove(theProperty);
		this.balance = this.balance + theProperty.getPrice();
	}
	
	public Boolean buyProperty(Property theProperty)
	{
		if(this.balance < theProperty.getPrice())
		{
			return false;
		}
		else
		{
			theProperty.setOwner(this);
			this.properties.add(theProperty);
			this.balance = this.balance - theProperty.getPrice();
			return true;
		}
	}
	
	//dice roll function will return the roll
	public int rollDice() {
		int dice1, dice2;
		dice1 = (int)(Math.random() * 6 + 1);
		dice2 = (int)(Math.random() * 6 + 1);
		return dice1 + dice2;
	}
	
	
	
	public String getAvatar()
	{
		return this.avatar;
	}
	

	public int getPosition()
	{
		return this.position;
	}
	
	public void movePosition(int dice)
	{
		
		this.position += dice;
		if(this.position > 39)
		{
			this.position %= 40;
		}
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Boolean getInjail() {
		return injail;
	}

	public void setInjail(Boolean injail) {
		this.injail = injail;
	}
	
	
	
	public void addMoney(int money)
	{
		this.balance = this.balance + money;
	}
	
	public void loseMoney(int money)
	{
		this.balance = this.balance - money;
	}
	
	public String getPlayerAllInfo()
	{
		String resultString = "";
		resultString = this.avatar + ", your position is at " + board.getProperties().get(this.position).getName() + ", your banlance is " + this.balance;
		resultString += " The properies you owned is: ";
		for(Property theProperty: properties)
		{
			resultString += theProperty.getName();
		}
		return resultString;
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public void setLocation(int newLocation)
	{
		this.location = newLocation;
	}
}
