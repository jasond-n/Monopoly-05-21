import java.util.ArrayList;

// chance class inherits from the property class, it contains the class doAtionAfterPlayer... which mimics the actions of a 
// random chance card drawn from the deck of chance cards created in board.java.
// This property cannot be bought.

public class Chance extends Property {
	public Chance(int positionOnBoard, Player owner, String name)
	{
		super(positionOnBoard, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player p, int roll, Board board, Card cardDrawn) {
			
			System.out.println("drawing a card...");
			System.out.println(cardDrawn.getDesc());
			
			if (cardDrawn.getType().equals("money")) { //this card type adds or removes money from a player by updating player's addmoney/losemoney
				if (cardDrawn.getValue() > 0) {
					p.addMoney(cardDrawn.getValue());
				} else if (cardDrawn.getValue() < 0) {
					p.loseMoney(-cardDrawn.getValue());
				}
					
			} else if (cardDrawn.getType() == "move") { // causes player to move a specific amount of spaces
				// update player's location
				p.setPosition(p.getPosition() + cardDrawn.getValue());
				
				//checking to see if you go negative
				if (p.getPosition() < 0) {
					p.setPosition(p.getPosition() + 40);
				}
					
				super.doActionAfterPlayerLandingHere(p, roll, board, cardDrawn);
					
			} else if (cardDrawn.getType() == "moveTo") { // move to another space
				
					p.setPosition(cardDrawn.getValue());
					
					//all the spaces you can possibly move to with a move to card
					switch (p.getPosition()) {
					case 0: p.addMoney(50); break;
					case 30: 
						p.setInJail(true);
						p.setPosition(10);
						break;
					case 11:
		            	case 24:
		            	case 39: p.setPosition(cardDrawn.getValue()); break;
					}
				 
				
				
					
			} else if (cardDrawn.getType() == "nearestStation") { // move to the nearest station
				if (p.getPosition() <= 4 && p.getPosition() >= 35) {
					// go to 5
					p.setPosition(5);
				} else if (p.getPosition() >= 5 && p.getPosition() <= 14) {
					// go to 15
					p.setPosition(15);
				} else if (p.getPosition() >= 15 && p.getPosition() <= 24) {
					// go to 25
					p.setPosition(25);
				} else if (p.getPosition() >= 25 && p.getPosition() <= 34) {
					// go to 35
					p.setPosition(35);
				}
				
				super.doActionAfterPlayerLandingHere(p, roll, board, cardDrawn);
				
			} else if (cardDrawn.getType() == "nearestUtil") {  // move to the nearest utility space
				if (p.getPosition() >= 11 && p.getPosition() >= 28) {
					p.setPosition(12);
				} else {
					p.setPosition(28);
				}
				
				super.doActionAfterPlayerLandingHere(p, roll, board, cardDrawn);
				
			} else if (cardDrawn.getType() == "each") { //adding/removing money from each player
				ArrayList<Player> players = board.getAllPlayers();
				if (cardDrawn.getValue() > 0) {
					p.addMoney(cardDrawn.getValue());
					for (int i=0; i < board.getAllPlayers().size(); i++) {
						players.get(i).loseMoney(-1 * cardDrawn.getValue());
					}
				} else if (cardDrawn.getValue() < 0) {
					p.loseMoney(cardDrawn.getValue());
					for (int i=0; i < board.getAllPlayers().size(); i++) {
						players.get(i).addMoney(cardDrawn.getValue());
					}
				}
				
			} else if (cardDrawn.getType() == "jail") { //get out of jail free card
				ArrayList<Card> x = new ArrayList<Card>();
				x.add(cardDrawn);
				p.setCardsOwned(x);
			}
		}
	}

