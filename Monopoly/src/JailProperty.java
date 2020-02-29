import java.util.Scanner;

public class JailProperty extends Property {
	public JailProperty(int price, String name)
	{
		super(price, name);
	}
	public void doActionBeforePlayerLeavingHere(Player player, int positionOnBoard, Board board)
	{
//		Scanner sc = new Scanner(System.in);
//		System.out.println(player.getAvatar() + ", you are in the Jail now, do you want to pay 50 fine, and leave, type yes to pay, other any thing to not pay");
//		String answer = sc.next();
//		if(answer == "yes")
//		{
//			int roll = player.rollDice();
//			System.out.println("you just rolled " + roll);
//			
//		}
//		else
//		{
//			
//		}
//		
		
		
		
		
	}
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
	{
		switch(player.getPosition())
		{
			case 10:
				System.out.println(player.getAvatar() + " are passing the jail. Nothing happens.");
				break;
			case 30:
				System.out.println(player.getAvatar() + " are going to the jail now and lost 500. And you have to throw doubles on any of your next two turns.");
				player.movePosition(10);
				player.setInJail(true);
				break;
		}
		
	}
}