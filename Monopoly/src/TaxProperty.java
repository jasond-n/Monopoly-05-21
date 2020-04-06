// There are 2 types of  tax property in the board. each involve making the player pay some amount of money if
// landed on. These properties cannot be bought.
import java.lang.Math;
public class TaxProperty extends Property {
	
	//constructor
	public TaxProperty(int positionOnBoard, Player owner, String name)
	{
		super(positionOnBoard, owner, name);
	}
	
	//gives them the decision to pay 200 or pay 10% of their balance when they land on a property.
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board, Card cardDrawn)
	{
		String userInput;
		if (player.getBalance() > 0) {
			switch (player.getPosition()) {
			case 4: //if they land on the first tax spot
				//human makes the decision
				if (player.getPlayerType().equals("human")) {
						userInput = getUserInput();
						if (userInput.equals("y")) {
							player.loseMoney((int)Math.round(player.getBalance() * 0.1));
						}
						if (userInput.equals("n")) {	
							player.loseMoney(200);
						}
				}
				//computer makes the decision
				//checks to see if 10% of balance is less than 200 then makes decision
				else {
					if ((int)Math.round(player.getBalance() * 0.1) < 200) {
						player.loseMoney((int)Math.round(player.getBalance() * 0.1));
					}
					else {
						player.loseMoney(200);
					}
				}
				break;
			//automatically lose 100 regardless
			case 38: 
				player.loseMoney(100);
				break;
			}
		}
	}
}