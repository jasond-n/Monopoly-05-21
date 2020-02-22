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
		System.out.println(player.getAvatar() + " are in the Jail now and lost 500. And you have to throwing doubles on any of his next two turns.");
		player.loseMoney(500);
	}
}