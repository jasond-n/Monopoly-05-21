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
	public String getType() {
		return type;
	}
	public int getValue() {
		return value;
	}
	
	// does this go in card class?
	// if player lands on chance space, choose a random card from the chance deck
	// and pass the effect onto the player
	public void ChanceEffect(Player p) {
	
		int randomIndex = (int) Math.random() * Board.chanceDeck.size();
		Card cardDrawn = Board.chanceDeck.get(randomIndex);
		System.out.println(cardDrawn.desc);
		
		if (cardDrawn.type == "money") {
			// update player's money value
			if (cardDrawn.value > 0) {
				p.addMoney(cardDrawn.value);
			} else if (cardDrawn.value < 0) {
				p.loseMoney(cardDrawn.value);
			}
			
		} else if (cardDrawn.type == "move") {
			// update player's location
			p.setLocation(p.getLocation() + cardDrawn.value);
		}
	} 
	
	// do the same thing if player lands on community chest space
	public void CommunityEffect(Player p) {
		
		int randomIndex = (int) Math.random() * Board.communityDeck.size();
		Card cardDrawn = Board.communityDeck.get(randomIndex);
		System.out.println(cardDrawn.desc);
		
		if (cardDrawn.type == "money") {
			// update player's money value
			if (cardDrawn.value > 0) {
				p.addMoney(cardDrawn.value);
			} else if (cardDrawn.value < 0) {
				p.loseMoney(cardDrawn.value);
			}
			
		} else if (cardDrawn.type == "move") {
			// update player's location
			p.setLocation(p.getLocation() + cardDrawn.value);
		}
	} 

	

	

}
