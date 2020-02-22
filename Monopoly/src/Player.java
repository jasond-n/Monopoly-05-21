import java.util.ArrayList;

public class Player {

	private final int INITIAL_BALANCE = 1500;
	
	private String avatar;
	private ArrayList<Property> properties;
	private int balance;
	private Boolean injail;
	private int location;
	
	public Player(String avatar)
	{
		this.avatar = avatar;
		this.balance = INITIAL_BALANCE;
		this.properties = new ArrayList<Property>();
		this.injail = false;
		this.location = 1;
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
			theProperty.setOwner(this.avatar);
			this.properties.add(theProperty);
			this.balance = this.balance - theProperty.getPrice();
			return true;
		}
	}
	
	public String getAvatar()
	{
		return this.avatar;
	}
	
	public void getMoney(int money)
	{
		this.balance = this.balance + money;
	}
	
	public void loseMoney(int money)
	{
		this.balance = this.balance - money;
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
