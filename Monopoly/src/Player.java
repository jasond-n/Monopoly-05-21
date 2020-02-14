import java.util.ArrayList;

public class Player {

	private String avatar;
	private ArrayList<Property> properties;
	private int balance;
	private Boolean Injail;
	
	public Player(String avatar, int balance)
	{
		this.avatar = avatar;
		this.balance = balance;
		this.properties = new ArrayList<Property>();
	}
	
	
	
}
