// the card class simulates the wild cards, or chance and community chest cards. Each card has a string description,
// a type of card (see chance and community chest for more info) and a value associated with the card.

public class Card {
	// initializing variables.The Card class is used when making the chance and community chest decks.
	private String desc;
	private String type;
	private int value;
	
	// arguments constructor. Each card has a description, an effect type (such as gaining/losing money or moving spaces)
	// and an associated value to the type 
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
