
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
		System.out.println(cardDrawn.desc);
		
		if (cardDrawn.type == "money") {
			// update player's money value
			if (cardDrawn.value > 0) {
				p.addMoney(cardDrawn.value);
			} else if (cardDrawn.value < 0) {
				p.loseMoney(cardDrawn.value);
				
		} else if (cardDrawn.type == "move") {					// check if go is passed???
			// update player's location
			p.movePosition(p.getPosition() + cardDrawn.value);
				
		} else if (cardDrawn.type == "moveTo") {
			if (p.getPosition() < cardDrawn.value) {
				p.movePosition(cardDrawn.value - p.getPosition());
			} else {
				p.movePosition(39 - p.getPosition() + cardDrawn.value);
				}
		// } else if () {
			// ...
		}
			
		}
	} 
	
	// do the same thing if player lands on community chest space
	public void CommunityEffect(Player p, Board board) {
		

		int randomIndex = (int) Math.random() * board.getCommunityDeck().size();
		Card cardDrawn = board.getCommunityDeck().get(randomIndex);
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
			p.movePosition(p.getPosition() + cardDrawn.value);
		}
	} 


	

}
