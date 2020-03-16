import java.util.ArrayList;

public class Chance extends Property {
	public Chance(int positionOnBoard, Player owner, String name)
	{
		super(positionOnBoard, owner, name);
	}
	
	public void doActionAfterPlayerLandingHere(Player p, int roll, Board board, Card cardDrawn) {
			//int randomIndex = (int) Math.random() * board.getChanceDeck().size();
			//Card cardDrawn = board.getChanceDeck().get(randomIndex);
			
			System.out.println("drawing a card...");
			System.out.println(cardDrawn.getDesc());
			
			if (cardDrawn.getType() == "money") {
				// update player's money getValue()
				if (cardDrawn.getValue() > 0) {
					p.addMoney(cardDrawn.getValue());
				} else if (cardDrawn.getValue() < 0) {
					p.loseMoney(cardDrawn.getValue());
				}
					
			} else if (cardDrawn.getType() == "move") {					// check if go is passed???
				// update player's location
				p.setPosition(p.getPosition() + cardDrawn.getValue());
				
				//checking to see if you go negative
				if (p.getPosition() < 0) {
					p.setPosition(p.getPosition() + 40);
				}
					
				super.doActionAfterPlayerLandingHere(p, roll, board, cardDrawn);
					
			} else if (cardDrawn.getType() == "moveTo") {
				if (p.getPosition() < cardDrawn.getValue()) {
					p.setPosition(cardDrawn.getValue() - p.getPosition());
					
					//checking to see if you go negative
					if (p.getPosition() < 0) {
						p.setPosition(p.getPosition() + 40);
						
				} else {
					p.setPosition(39 - p.getPosition() + cardDrawn.getValue());
					}
				
				super.doActionAfterPlayerLandingHere(p, roll, board, cardDrawn);
					
			} else if (cardDrawn.getType() == "nearestStation") {
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
				
			} else if (cardDrawn.getType() == "nearestUtil") {
				if (p.getPosition() >= 11 && p.getPosition() >= 28) {
					p.setPosition(12);
				} else {
					p.setPosition(28);
				}
				
				super.doActionAfterPlayerLandingHere(p, roll, board, cardDrawn);
				
			} else if (cardDrawn.getType() == "each") {
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
				
			} else if (cardDrawn.getType() == "jail") {
				ArrayList<Card> x = new ArrayList<Card>();
				x.add(cardDrawn);
				p.setCardsOwned(x);
			}
		}
	}
}