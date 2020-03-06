import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {

	private ArrayList<Property> allSpotsOnBoard;
	private ArrayList<Card> chanceDeck = new ArrayList<Card>();
	private ArrayList<Card> communityDeck = new ArrayList<Card>();
	private ArrayList<Player> allPlayers = new ArrayList<Player>(); 
	
	private int dice1, dice2;
	
	private Property go;
	private Property cragie; //this makes coding the gameconfig alot easier if we make them all public static just not sure about privacy leaks
	private CommunityChest communityChest1;
	private TaxProperty rentFee;
	private Property scienceB;
	private RailroadProperty somerset;
	private Property mathScience;
	private Chance chance1;
	private Property bioSci;
	private Property alma;
	private JailProperty jail;
	private Property reeveTheatre;
	private Utility zipper;
	private Property kinesB;
	private Property kinesA;
	private RailroadProperty cityHall;
	private Property scurfield;
	private CommunityChest communityChest2;
	private Property professional;
	private Property scienceA;
	private TaxProperty freeParking;
	private Property olympicOval;
	private Chance chance2;
	private Property murrayFraser;
	private Property scienceTheatres;
	private RailroadProperty university;
	private Property admin;
	private Property macHall;
	private Utility gym;
	private Property education;
	private JailProperty goToJail;
	private Property tfdl;
	private Property schulich;
	private CommunityChest communityChest3;
	private RailroadProperty tuscany;
	private Property ict;
	private Chance chance3;
	private Property eeel;
	private TaxProperty tuitionFee;
	private Property ti;
	

	
	
	/*
	 *  setPrice(price); //price of property
		setNumOfHouses(numOfHouses); 
		setNumOfHotels(numOfHotels);
		setPositionOnBoard(positionOnBoard); //position of property 1-40
		setRentBase(rentBase);
		setRent1House(rent1House);
		setRent2House(rent2House);
		setRent3House(rent3House);
		setRent4House(rent4House);
		setRentHotel(rentHotel);
		setMortgageValue(mortgageValue);
		setHouseCost(houseCost);
		setHotelCost(hotelCost);
		setOwner(owner); //name of owner of property
		setName(name); //name of the actual property
		setColor(color); //String of color
	 * */

	public Board () { //in the constructor possibly add number of players?

		// coding all the event cards to go in community chest and chance decks
		Card money20 = new Card("You sold an old textbook. Collect $20.", "money", 20);
		Card money50 = new Card("You have just recieved your student loans. Collect $50.", "money", 50);
		Card money100a = new Card("You earned a scholarship for maintaining a 4.0 GPA last semester. Collect $100", "money", 100);
		Card money100b = new Card("You helped an international student with an assignemt. In return, he gave you $100.", "money", 100);
		Card money150 = new Card("You won first place in a city-wide hackathon. Collect $150.", "money", 150);
		Card money200 = new Card("A bus just ran you over on campus. Collect $200 from the lawsuit settlement.", "money", 200);
		Card moneyN15 = new Card("Pay $15 for a pizza bun at Bake Chef.", "money", -15);
		Card moneyN50a = new Card("Pay a $50 fine for dropping out of astronomy 207. Yep, way too much physics.", "money", -50);
		Card moneyN50b = new Card("You fell asleep during your final exam and got a D. Cramming was definitely a bad idea. Lose $50.", "money", -50);
		
		Card moveN3 = new Card("MATH 265 has no more open lecture seats left this semester. Move back 3 spaces.","move", -3);
		Card move3 = new Card("You assignment due date was extended by one week. Move forward 3 spaces.", "move", 3);
		
		Card moveTo0 = new Card("Advance to GO. Collect $200.", "moveTo", 0);
		Card moveTo24 = new Card("Advance to Science Theatres. If you pass GO, collect $200", "moveTo", 24);
		Card moveTo11 = new Card("Advance to Reeve Theatre. If you pass GO, collect $200.", "moveTo", 11);
		Card moveTo39 = new Card("Take a trip to the Taylor Institute. If you pass GO, collect $200.", "moveTo", 39);
		Card moveTo5 = new Card("Take a trip to Somerset Station. If you pass Go, collect $200", "moveTo", 5);
		Card moveToJail = new Card("Go directly to Jail. Do not pass GO, do not collect $200.", "moveTo", 30);
		
		Card nearestUtility = new Card("Advance to nearest utility.", "nearestUtil", 0); // If owned, throw dice and pay owner a total 10 times the amount thrown.
		Card nearestStation = new Card("Advance to nearest station.", "nearestStation", 0); // and pay owner twice the rental amount.
		
		Card GetOutOfJail = new Card("Get out of Jail Free. This card may be kept until needed, or traded/sold.", "jail", 0);
		
		Card eachN50 = new Card("You have been elected as SU president. Pay each player $50.", "each", -50);
		Card each50 = new Card("You are hosting a networking night for software engineers. Each player pays you a $50 entrance fee.", "each", 50);
		Card each10 = new Card("You got the highest grade on the midterm in your class. It was 57. Collect $10 from each player.", "each", 10);
		

		// creating the chance and community chest decks as ArrayLists and adding the appropriate cards
		chanceDeck.add(money50);
		chanceDeck.add(money150);
		chanceDeck.add(moneyN15);
		chanceDeck.add(money100a);
		chanceDeck.add(moveN3);
		chanceDeck.add(moveTo0);
		chanceDeck.add(moveTo24);
		chanceDeck.add(moveTo11);
		chanceDeck.add(moveTo5);
		chanceDeck.add(moveTo39);
		chanceDeck.add(move3);
		chanceDeck.add(moveToJail);
		chanceDeck.add(nearestStation);
		chanceDeck.add(nearestUtility);
		chanceDeck.add(eachN50);
		chanceDeck.add(GetOutOfJail);
		
		communityDeck.add(money200);
		communityDeck.add(money20);
		communityDeck.add(moneyN50a);
		communityDeck.add(moneyN50b);
		communityDeck.add(money100a);
		communityDeck.add(money150);
		communityDeck.add(money100b);
		communityDeck.add(money50);
		communityDeck.add(moveTo0);
		communityDeck.add(moveTo39);
		communityDeck.add(move3);
		communityDeck.add(each50);
		communityDeck.add(each10);
		communityDeck.add(moveToJail);
		communityDeck.add(GetOutOfJail);
		
		allSpotsOnBoard = new ArrayList<Property>();
		//in the constructor possibly add number of players?
		allSpotsOnBoard.add(go = new Property(200, 0, "GO"));
		allSpotsOnBoard.add(cragie = new Property(60, 0, 0, 1, 2, 10, 30, 90, 160, 250, 30, 50, 50, null, "Cragie Hall", "brown"));
		allSpotsOnBoard.add(communityChest1 = new CommunityChest(2 ,"Community Chest 1"));
		allSpotsOnBoard.add(rentFee = new TaxProperty(3, "Rent Fee"));
		allSpotsOnBoard.add(scienceB = new Property(60, 0, 0, 4, 4, 20, 60, 180, 320, 450, 30, 50, 50, null, "Science B", "brown"));
		allSpotsOnBoard.add(somerset = new RailroadProperty(200, 5, 25, 50, 100, 200, 100, null, "Somerset Station", "black"));
		allSpotsOnBoard.add(mathScience = new Property(100, 0, 0, 6, 6, 30, 90, 270, 400, 550, 50, 50, 50, null, "Math Sciences", "light blue"));
		allSpotsOnBoard.add(chance1 = new Chance(7 ,"Chance 1"));
		allSpotsOnBoard.add(bioSci = new Property(100, 0, 0, 8, 6, 30, 90, 270, 400, 550, 50, 50, 50, null, "Biological Sciences", "light blue"));
		allSpotsOnBoard.add(alma = new Property(120, 0, 0, 9, 8, 40, 100, 300, 450, 600, 60, 50, 50, null, "Hotel Alma", "light blue"));
		allSpotsOnBoard.add(jail = new JailProperty(10, "Jail"));
		allSpotsOnBoard.add(reeveTheatre = new Property(140, 0, 0, 11, 10, 50, 150, 450, 625, 750, 70, 100, 100, null, "Reeve Theatre", "pink"));
		allSpotsOnBoard.add(zipper = new Utility(150, 12, 4, 10, 75, null, "The Zipper", "white"));
		allSpotsOnBoard.add(kinesB = new Property(140, 0, 0, 13, 10, 50, 150, 450, 625, 750, 70, 100, 100, null, "Kineseology B", "pink"));
		allSpotsOnBoard.add(kinesA = new Property(160, 0, 0, 14, 12, 60, 180, 500, 700, 900, 80, 100, 100, null, "Kineseology A", "pink"));
		allSpotsOnBoard.add(cityHall = new RailroadProperty(200, 15, 25, 50, 100, 200, 100, null, "City Hall Station", "black"));
		allSpotsOnBoard.add(scurfield = new Property(180, 0, 0, 16, 14, 70, 200, 550, 750, 950, 90, 100, 100, null, "Scurfield Hall", "orange"));
		allSpotsOnBoard.add(communityChest2 = new CommunityChest(17 ,"Community Chest 2"));
		allSpotsOnBoard.add(professional = new Property(180, 0, 0, 18, 14, 70, 200, 550, 750, 950, 90, 100, 100, null, "Professional Faculty", "orange"));
		allSpotsOnBoard.add(scienceA = new Property(200, 0, 0, 19, 16, 80, 220, 600, 800, 1000, 100, 100, 100, null, "Science A", "orange"));
		allSpotsOnBoard.add(freeParking = new TaxProperty(20, "Free Parking"));
		allSpotsOnBoard.add(olympicOval = new Property(220, 0, 0, 21, 18, 90, 250, 700, 875, 1050, 110, 150, 150, null, "Olympic Oval", "red"));
		allSpotsOnBoard.add(chance2 = new Chance(22 ,"Chance 2"));
		allSpotsOnBoard.add(murrayFraser = new Property(220, 0, 0, 23, 18, 90, 250, 700, 875, 1050, 110, 150, 150, null, "Murray Fraser Hall", "red"));
		allSpotsOnBoard.add(scienceTheatres = new Property(240, 0, 0, 24, 20, 100, 300, 750, 925, 1100, 120, 150, 150, null, "Science Theatres", "red"));
		allSpotsOnBoard.add(university = new RailroadProperty(200, 25, 25, 50, 100, 200, 100, null, "University Staiton", "black"));
		allSpotsOnBoard.add(admin = new Property(260, 0, 0, 26, 22, 110, 330, 800, 975, 1150, 130, 150, 150, null, "Administration Building", "yellow"));
		allSpotsOnBoard.add(macHall = new Property(260, 0, 0, 27, 22, 110, 330, 800, 975, 1150, 130, 150, 150, null, "Macewan Hall", "yellow"));
		allSpotsOnBoard.add(gym = new Utility(150, 28, 4, 10, 75, null, "The Gym", "white"));
		allSpotsOnBoard.add(education = new Property(280, 0, 0, 29, 24, 120, 360, 850, 1025, 1200, 140, 150, 150, null, "Werklund School of Education", "yellow"));
		allSpotsOnBoard.add(jail = new JailProperty(30, "Go To Jail"));
		allSpotsOnBoard.add(tfdl = new Property(300, 0, 0, 31, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, null, "Taylor Family Digital Library", "green"));
		allSpotsOnBoard.add(schulich = new Property(300, 0, 0, 32, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, null, "Schulich School of Engineering", "green"));
		allSpotsOnBoard.add(communityChest3 = new CommunityChest(33 ,"Community Chest 3"));
		allSpotsOnBoard.add(tuscany = new RailroadProperty(200, 34, 25, 50, 100, 200, 100, null, "Tuscany Station", "black"));
		allSpotsOnBoard.add(ict = new Property(320, 0, 0, 35, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200, null, "ICT", "green"));
		allSpotsOnBoard.add(chance3 = new Chance(36 ,"Chance 3"));
		allSpotsOnBoard.add(eeel = new Property(350, 0, 0, 37, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200, null, "EEEL", "dark blue"));
		allSpotsOnBoard.add(tuitionFee = new TaxProperty(38, "Tuition Fee"));
		allSpotsOnBoard.add(ti = new Property(400 , 0, 0, 39, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200, null, "Taylor Institute", "dark blue"));
	}
	
	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

	public ArrayList<Card> getChanceDeck() {
		return chanceDeck;
	}

	public void setChanceDeck(ArrayList<Card> chanceDeck) {
		this.chanceDeck = chanceDeck;
	}

	public ArrayList<Card> getCommunityDeck() {
		return communityDeck;
	}

	public void setCommunityDeck(ArrayList<Card> communityDeck) {
		this.communityDeck = communityDeck;
	}

	public ArrayList<Property> getProperties()
	{
		return this.allSpotsOnBoard;
	}

	public String toString()
	{
		String resultString = "";
		for(Property theProperty : allSpotsOnBoard)
		{
			resultString += theProperty.getName() + " \n";
		}
		return resultString;
	}
	
	public int getDice1() {
		return dice1;
	}
	public int getDice2() {
		return dice2;
	}
	
	
	//dice roll function will return the roll
	public int rollDice() {
		dice1 = (int)(Math.random() * 6 + 1);
		dice2 = (int)(Math.random() * 6 + 1);
		return dice1 + dice2;
	}
	
	//checking to see if the roll is a double
	public boolean isDouble() {
		
		if (dice1 == dice2) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	//checks to see if someone is bankrupt
	public boolean someoneIsBankrupt() {
		boolean bankrupt = false;
		
		for (int i = 0; i < allPlayers.size(); i++) {
			if (allPlayers.get(i).getBalance() <= 0) {
				bankrupt = true;
			}
		}
		
		return bankrupt;	
	}
	
	//helper method checks to see who is bankrupt
		private Player whoIsBankrupt() {
			Player broke = new Player(null, null);
			
			for (int i = 0; i < allPlayers.size(); i++) {
				if (allPlayers.get(i).getBalance() <= 0) {
					broke = allPlayers.get(i);
				}
			}
			
			return broke;	
		}
	
	//removes the player that is broke after all their properties have been transferred to the bank
	public void liquidateAssets() {
		Player whoToRemove = whoIsBankrupt();
		
		for (int i = 0; i < whoToRemove.getPlayerProperties().size(); i++) {
			whoToRemove.getPlayerProperties().get(i).setOwner(null);
			whoToRemove.getPlayerProperties().get(i).setNumOfHouses(0);
			whoToRemove.getPlayerProperties().get(i).setNumOfHotels(0);
		}
		
		
		allPlayers.remove(whoToRemove);
	}
	
	
	public void decideOrder() {
		//ArrayList<String> order = new ArrayList<String>();
		int player1 = 0, player2 = 0, player3 = 0, player4 = 0;
		int[] rolls = new int[allPlayers.size()];
		boolean sorted = false;
		
		
		if (allPlayers.size() != 2) {
			//this while loop rolls dice until all tje player's rolls are unique
			while ((player1 == player2) || (player1 == player3) || (player1 == player4) || (player2 == player3) || (player2 == player4) || (player3 == player4)) {
				
				
				
				for (int i = 0; i < allPlayers.size(); i++) {
					switch (i) {
					case 0: 
						player1 = rollDice();
						rolls[0] = player1;
						break;
					case 1: 
						player2 = rollDice();
						rolls[1] = player2;
						break;
					case 2: 
						player3 = rollDice();
						rolls[2] = player3;
						break;
					case 3: 
						player4 = rollDice();
						rolls[3] = player4;
						break;
					}
				}
			}
		}
		else {
			while ((player1 == player2)) {
				
				for (int i = 0; i < allPlayers.size(); i++) {
					switch (i) {
					case 0: 
						player1 = rollDice();
						rolls[0] = player1;
						break;
					case 1: 
						player2 = rollDice();
						rolls[1] = player2;
						break;
					}
				}
			}
		}
		//a bubble sort to create the order
		
		int temp;
		Player temp2;
		do {
			//sorting
			for (int i = 0; i < allPlayers.size() - 1; i++) {
				if (rolls[i] < rolls[i + 1]) {
					temp = rolls[i];
					rolls[i] = rolls[i + 1];
					rolls[i + 1] = temp;
					
					temp2 = allPlayers.get(i);
					allPlayers.set(i, allPlayers.get(i + 1));
					allPlayers.set(i + 1, temp2);
					
					
				}
			}
			
			
			
			switch (allPlayers.size()) {
			case 2: 
				if (rolls[0] > rolls[1]) {
					sorted = true;
				} 
			break;
			case 3: 
				
				if (rolls[0] > rolls[1] && rolls[1] > rolls[2]) {
					sorted = true;
				} 
				
				break;
			case 4: 
				
				if (rolls[0] > rolls[1] && rolls[1] > rolls[2] && rolls[2] > rolls[3]) {
					sorted = true;
				} 
				
				break;
			}
			
			
		} while (sorted == false);
		
			
	}
	
	
}
