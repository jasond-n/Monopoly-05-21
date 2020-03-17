import java.util.ArrayList;

public class Player {

	private final int INITIAL_BALANCE = 1500;
	
	private String avatar;
	private ArrayList<Property> properties;
	private int balance;
	private int position, prevPosition;
	private Boolean inJail;
	private ArrayList<Card> cardsOwned;
	protected String playerType;
	private int counterOfRollForLeaveJail;
	private Board board;
	
	public Player(String avatar, Board board)
	{
		this.avatar = avatar;
		this.balance = INITIAL_BALANCE;
		this.position = 0;
		this.properties = new ArrayList<Property>();
		this.inJail = false;
		this.counterOfRollForLeaveJail = 0;
		this.board = board;
		this.playerType = "human";
	}
	
	public String getPlayerType() {
		return playerType;
	}
	
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	
	
	public int getCounterOfRollForLeaveJail() {
		return counterOfRollForLeaveJail;
	}

	public void setCounterOfRollForLeaveJail(int counterOfRollForLeaveJail) {
		this.counterOfRollForLeaveJail = counterOfRollForLeaveJail;
	}

	public void sellProperty(Property theProperty) {
		theProperty.setOwner(null);
		this.properties.remove(theProperty);
		this.balance = this.balance + theProperty.getPrice();
	}
	
	public void buyProperty(Property theProperty)
	{
//		if(this.balance < theProperty.getPrice())
//		{
//			return false;
//		}
//		else
//		{
//			theProperty.setOwner(this);
//			this.properties.add(theProperty);
//			this.balance = this.balance - theProperty.getPrice();
//			return true;
//		}
		
		
		if (getBalance() - theProperty.getPrice() >= 0) {
			theProperty.setOwner(this);
			loseMoney(theProperty.getPrice());
			addPlayerProperty(board.getProperties().get(getPosition()));
		}

		
		
	}
	
	public void buyHotel(Property theProperty) {
		if (getBalance() - theProperty.getHotelCost() >= 0) {
			theProperty.setNumOfHotels(1);
			theProperty.setNumOfHouses(0);
			loseMoney(theProperty.getHotelCost());
			////System.out.println("You just bought a hotel ");
		}
	}
	
	public void buyHouse(Property theProperty) {
		if (getBalance() - theProperty.getHouseCost() >= 0) {
			theProperty.addNumOfHouses();
			loseMoney(theProperty.getHouseCost());
			
		}
	}
	
	
	
	
	
	public String getAvatar()
	{

		return this.avatar;
	}
	
	public int getPreviousPosition() {
		return prevPosition;
	}
	
	public void setPreviousPosition(int roll) {
		prevPosition = getPosition() - roll;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	
	public void setPosition(int position) {
		if (position >= 40) {
			position %= 40;
		}
		this.position = position;
	}
	
	public void movePosition(int dice) {
		this.position += dice;
		if(this.position > 39) {
			this.balance += 200; //passing go
			this.position %= 40;
		}
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setCardsOwned(ArrayList<Card> cardsOwned) {
		this.cardsOwned = cardsOwned;
	}
	
	public Boolean getInJail() {
		return inJail;
	}

	public void setInJail(Boolean inJail) {
		this.inJail = inJail;
	}
	
	public void addMoney(int money)
	{
		this.balance = this.balance + money;
	}
	
	public void loseMoney(int money)
	{
		this.balance = this.balance - money;
	}
	
	public ArrayList<Property> getPlayerProperties() {
		ArrayList<Property> temp = new ArrayList<Property>(this.properties);
		return temp;
	}
	
	public void addPlayerProperty(Property temp) {
		this.properties.add(temp);
	}
	
	public String getPlayerAllInfo() {
		String resultString = "";
		resultString = this.avatar + ", your position is at " + board.getProperties().get(this.position).getName() + ", your balance is " + this.balance;
		resultString += " The properies you own are: ";
		for(Property theProperty: properties)
		{
			resultString += theProperty.getName();
		}
		return resultString;
	}
}
