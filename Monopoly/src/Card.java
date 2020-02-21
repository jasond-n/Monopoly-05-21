import java.util.ArrayList;
import java.util.Random;

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
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	// does this go in card class?
	// if player lands on chance space, choose a random card from the chance deck
	// and pass the effect onto the player
	public void ChanceEffect(Player p) {
		
		int randomIndex = (int) Math.random() * chanceDeck.size();
		Card cardDrawn = chanceDeck.get(randomIndex);
		System.out.println(cardDrawn.desc);
		
		if (cardDrawn.type == "money") {
			// update player's money value
			p.setBalance(p.getBalance() += cardDrawn.value);
		} else if (cardDrawn.type == "move") {
			// update player's location
			p.setLocation(p.getLocation() += cardDrawn.value); // location in Player class ????
		}
	} 
	
	// do the same thing if player lands on community chest space
	public void CommunityEffect(Player p) {
		
		int randomIndex = (int) Math.random() * communityDeck.size();
		Card cardDrawn = communityDeck.get(randomIndex);
		System.out.println(cardDrawn.desc);
		
		if (cardDrawn.type == "money") {
			// update player's money value
			p.setBalance(p.getBalance() += cardDrawn.value);
		} else if (cardDrawn.type == "move") {
			// update player's location
			p.setLocation(p.getLocation() += cardDrawn.value); // location in Player class ????
		}
	} 
	
	public static void main (String args[]) {
		
		// hard coding each type of community chest or chance card, each with unique actions
		Card money1 = new Card("You have just recieved your student loans. Collect $150.", "money", 150);
		Card move1 = new Card("MATH 265 has no more open lecture seats left for the semester. Move back four spaces.","move", -4);
		Card move2 = new Card("Advance to ")
		// advance to ___
		// advance to nearest ____
		// for each house/hotel, pay ___
		// pay each player ___
		// go to jail
		// get out of jail
		
		
		// creating an arraylist (a deck) of chance cards (GOES IN BOARD CLASS ??)
		ArrayList<Card> chanceDeck = new ArrayList<Card>();
		chanceDeck.add(money1);
		chanceDeck.add(move1);
		
		// creating an arraylist (a deck) of community chest cards (GOES IN BOARD CLASS ??)
		
	}

	

	

}
