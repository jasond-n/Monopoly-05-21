import java.util.ArrayList;

public class Player {

	private final int INITIAL_BALANCE = 1500;
	
	private String avatar;
	private ArrayList<Property> properties;
	private int balance;
	private Boolean injail;
	
	public Player(String avatar)
	{
		this.avatar = avatar;
		this.balance = INITIAL_BALANCE;
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
	
	
}
