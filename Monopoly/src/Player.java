import java.util.ArrayList;

public class Player {

	private String avatar;
	private ArrayList<Property> properties;
	private int balance;
	private Boolean injail;
	
	public Player(String avatar, int balance)
	{
		this.avatar = avatar;
		this.balance = balance;
		this.properties = new ArrayList<Property>();
		this.injail = false;
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
	
}
