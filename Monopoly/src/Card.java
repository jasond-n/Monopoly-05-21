import java.util.ArrayList;

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
	
	// this is supposed to go into a different class lol. im not sure which one tho -justin
	// if player lands on chance space, choose a random card from the chance deck
	// and pass the effect onto the player
	
	public void ChanceEffect(Player p, Board board) {
		int randomIndex = (int) Math.random() * board.getChanceDeck().size();
		Card cardDrawn = board.getChanceDeck().get(randomIndex);
		
		if (cardDrawn.type == "money") {
			// update player's money value
			if (cardDrawn.value > 0) {
				p.addMoney(cardDrawn.value);
			} else if (cardDrawn.value < 0) {
				p.loseMoney(cardDrawn.value);
			}
				
		} else if (cardDrawn.type == "move") {					// check if go is passed???
			// update player's location
			p.movePosition(p.getPosition() + cardDrawn.value);
				
		} else if (cardDrawn.type == "moveTo") {
			if (p.getPosition() < cardDrawn.value) {
				p.movePosition(cardDrawn.value - p.getPosition());
			} else {
				p.movePosition(39 - p.getPosition() + cardDrawn.value);
				}
			
		} else if (cardDrawn.type == "nearestStation") {
			if (p.getPosition() <= 4 && p.getPosition() >= 35) {
				// go to 5
				p.movePosition(5);
			} else if (p.getPosition() >= 5 && p.getPosition() <= 14) {
				// go to 15
				p.movePosition(15);
			} else if (p.getPosition() >= 15 && p.getPosition() <= 24) {
				// go to 25
				p.movePosition(25);
			} else if (p.getPosition() >= 25 && p.getPosition() <= 34) {
				// go to 35
				p.movePosition(35);
			}
			
		} else if (cardDrawn.type == "nearestUtil") {
			if (p.getPosition() >= 11 && p.getPosition() >= 28) {
				p.movePosition(12);
			} else {
				p.movePosition(28);
			}
			
		} else if (cardDrawn.type == "each") {
			ArrayList<Player> players = board.getAllPlayers();
			if (cardDrawn.value > 0) {
				p.addMoney(cardDrawn.value);
				for (int i=0; i < board.getAllPlayers().size(); i++) {
					players.get(i).loseMoney(-1 * cardDrawn.value);
				}
			} else if (cardDrawn.value < 0) {
				p.loseMoney(cardDrawn.value);
				for (int i=0; i < board.getAllPlayers().size(); i++) {
					players.get(i).addMoney(cardDrawn.value);
				}
			}
		}
	} 
	
	// do the same thing if player lands on community chest space
	public void CommunityEffect(Player p, Board board) {



	

}
