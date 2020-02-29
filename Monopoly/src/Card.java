
public class Card {
	// initializing variables
	private String desc;
	private String type;
	private int value;
	
	// arguments constructor. Each card has a description, an effect type (such as gaining/losing money or moving spaces)
	// and an associated value to the type (?? what if multiple int values or multiple types)
	public Card(String desc, String type, int value) { 
		this.desc = desc;
		this.type = type;
		this.value = value;
	}
	
	// getters and setters
	public String getDesc() {
		return desc;
	}
	public String getType() {
		return type;
	}
	public int getValue() {
		return value;
	}
	
}
