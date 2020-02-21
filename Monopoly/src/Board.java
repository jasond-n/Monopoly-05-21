import java.util.ArrayList;

public class Board {
	
	private ArrayList<Property> allSpotsOnBoard;
	
	private Property propertyName; //don't know what this is for but will leave it here
	private int freeParkingMoneyPool;
	
	private Property go;
	private Property cragie; //this makes coding the gameconfig alot easier if we make them all public static just not sure about privacy leaks
	private CommunityChest communityChest1;
	//rentFee1
	private Property scienceB;
	private RailroadProperty somerset;
	private Property mathScience;
	private Chance chance1;
	private Property bioSci;
	private Property alma;
	//jail
	private Property reeveTheatre;
	private Utility zipper;
	private Property kinesB;
	private Property kinesA;
	private RailroadProperty cityHall;
	private Property scurfield;
	private CommunityChest communityChest2;
	private Property professional;
	private Property scienceA;
	//free parking
	private Property olympicOval;
	private Chance chance2;
	private Property murrayFraser;
	private Property scienceTheatres;
	private RailroadProperty university;
	private Property admin;
	private Property macHall;
	private Utility gym;
	private Property education;
	//goto jail
	private Property tfdl;
	private Property schulich;
	private CommunityChest communityChest3;
	private RailroadProperty tuscany;
	private Property ict;
	private Chance chance3;
	private Property eeel;
	//tuition tax
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
		Card moveTo1 = new Card("Advance to GO. Collect $200.", "move", 1);
		// in move2, value = 1 represents the index for the GO space. use 41 - player.getLocation() instead? the number of spaces player needs to go forwards to get to GO. (player get location is needed)	
		Card moveTo25 = new Card("Advance to Science Theatres. If you pass GO, collect $200", "move", 25);
		Card moveTo12 = new Card("Advance to Reeve Theatre. If you pass GO, collect $200.", "move", 12);
		Card moveTo40 = new Card("Take a trip to the Taylor Institute. If you pass GO, collect $200.", "move", 40);
		Card moveTo6 = new Card("Take a trip to Somerset Station. If you pass Go, collect $200", "move", 6);
		// advance to nearest utility. If owned, throw dice and pay owner a total 10 times the amount thrown.
		// Advance to nearest Railroad and pay owner twice the rental amount.
		// Get out of Jail Free. This card may be kept until needed, or traded/sold.
		// Make general repairs on all your property: For each house pay $25, For each hotel pay $100.
		// You have been elected as SU president. Pay each player $50.
		// You are hosting a networking night for software engineers. Each player pays you a $50 entrance fee.
		// You got the highest grade on the midterm in your class. It was 57. Collect $10 from each player.
		
		
		// creating the chance and community chest decks as ArrayLists and adding the appropriate cards
		ArrayList<Card> chanceDeck = new ArrayList<Card>();
		chanceDeck.add(money50);
		chanceDeck.add(money150);
		chanceDeck.add(moneyN15);
		chanceDeck.add(money100a);
		chanceDeck.add(moveN3);
		chanceDeck.add(moveTo1);
		chanceDeck.add(moveTo25);
		chanceDeck.add(moveTo12);
		chanceDeck.add(moveTo6);
		chanceDeck.add(moveTo40);
		// add nearest utility, nearest railroad, get out of jail, go to jail, repairs, SU president
		ArrayList<Card> communityDeck = new ArrayList<Card>();
		communityDeck.add(money200);
		communityDeck.add(money20);
		communityDeck.add(moneyN50a);
		communityDeck.add(moneyN50b);
		communityDeck.add(money100a);
		communityDeck.add(money150);
		communityDeck.add(money100b);
		communityDeck.add(money50);
		communityDeck.add(moveTo1);
		communityDeck.add(moveTo40);
		// add go to jail, get out of jail, network night, midterm, repairs
		
		allSpotsOnBoard = new ArrayList<Property>();
		//in the constructor possibly add number of players?
		allSpotsOnBoard.add(go = new Property(200));
		allSpotsOnBoard.add(cragie = new Property(60, 0, 0, 2, 2, 10, 30, 90, 160, 250, 30, 50, 50, "n/a", "Cragie Hall", "brown"));
		allSpotsOnBoard.add(communityChest1 = new CommunityChest(3 ,"Community Chest 1"));
		//rent fee
		allSpotsOnBoard.add(scienceB = new Property(60, 0, 0, 5, 4, 20, 60, 180, 320, 450, 30, 50, 50, "n/a", "Science B", "brown"));
		allSpotsOnBoard.add(somerset = new RailroadProperty(200, 6, 25, 50, 100, 200, 100, "n/a", "Somerset Station"));
		allSpotsOnBoard.add(mathScience = new Property(100, 0, 0, 7, 6, 30, 90, 270, 400, 550, 50, 50, 50, "n/a", "Math Sciences", "light blue"));
		allSpotsOnBoard.add(chance1 = new Chance(8 ,"Chance 1"));
		allSpotsOnBoard.add(bioSci = new Property(100, 0, 0, 9, 6, 30, 90, 270, 400, 550, 50, 50, 50, "n/a", "Biological Sciences", "light blue"));
		allSpotsOnBoard.add(alma = new Property(120, 0, 0, 10, 8, 40, 100, 300, 450, 600, 60, 50, 50, "n/a", "Hotel Alma", "light blue"));
		//jail
		allSpotsOnBoard.add(reeveTheatre = new Property(140, 0, 0, 12, 10, 50, 150, 450, 625, 750, 70, 100, 100, "n/a", "Reeve Theatre", "pink"));
		allSpotsOnBoard.add(zipper = new Utility(150, 13, 4, 10, 75, "n/a", "The Zipper"));
		allSpotsOnBoard.add(kinesB = new Property(140, 0, 0, 14, 10, 50, 150, 450, 625, 750, 70, 100, 100, "n/a", "Kineseology B", "pink"));
		allSpotsOnBoard.add(kinesA = new Property(160, 0, 0, 15, 12, 60, 180, 500, 700, 900, 80, 100, 100, "n/a", "Kineseology A", "pink"));
		allSpotsOnBoard.add(cityHall = new RailroadProperty(200, 16, 25, 50, 100, 200, 100, "n/a", "City Hall Station"));
		allSpotsOnBoard.add(scurfield = new Property(180, 0, 0, 17, 14, 70, 200, 550, 750, 950, 90, 100, 100, "n/a", "Scurfield Hall", "orange"));
		allSpotsOnBoard.add(communityChest2 = new CommunityChest(18 ,"Community Chest 2"));
		allSpotsOnBoard.add(professional = new Property(180, 0, 0, 19, 14, 70, 200, 550, 750, 950, 90, 100, 100, "n/a", "Professional Faculty", "orange"));
		allSpotsOnBoard.add(scienceA = new Property(200, 0, 0, 20, 16, 80, 220, 600, 800, 1000, 100, 100, 100, "n/a", "Science A", "orange"));
		//free parking
		allSpotsOnBoard.add(olympicOval = new Property(220, 0, 0, 22, 18, 90, 250, 700, 875, 1050, 110, 150, 150, "n/a", "Olympic Oval", "red"));
		allSpotsOnBoard.add(chance2 = new Chance(23 ,"Chance 2"));
		allSpotsOnBoard.add(murrayFraser = new Property(220, 0, 0, 24, 18, 90, 250, 700, 875, 1050, 110, 150, 150, "n/a", "Murray Fraser Hall", "red"));
		scienceTheatres = new Property(240, 0, 0, 25, 20, 100, 300, 750, 925, 1100, 120, 150, 150, "n/a", "Science Theatres", "red");
		allSpotsOnBoard.add(university = new RailroadProperty(200, 26, 25, 50, 100, 200, 100, "n/a", "University Staiton"));
		allSpotsOnBoard.add(admin = new Property(260, 0, 0, 27, 22, 110, 330, 800, 975, 1150, 130, 150, 150, "n/a", "Administration Building", "yellow"));
		allSpotsOnBoard.add(macHall = new Property(260, 0, 0, 28, 22, 110, 330, 800, 975, 1150, 130, 150, 150, "n/a", "Macewan Hall", "yellow"));
		allSpotsOnBoard.add(gym = new Utility(150, 29, 4, 10, 75, "n/a", "The Gym"));
		allSpotsOnBoard.add(education = new Property(280, 0, 0, 30, 24, 120, 360, 850, 1025, 1200, 140, 150, 150, "n/a", "Werklund School of Education", "yellow"));
		//gotojail
		allSpotsOnBoard.add(tfdl = new Property(300, 0, 0, 32, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, "n/a", "Taylor Family Digital Library", "green"));
		allSpotsOnBoard.add(schulich = new Property(300, 0, 0, 33, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, "n/a", "Schulich School of Engineering", "green"));
		allSpotsOnBoard.add(communityChest3 = new CommunityChest(34 ,"Community Chest 3"));
		allSpotsOnBoard.add(tuscany = new RailroadProperty(200, 35, 25, 50, 100, 200, 100, "n/a", "Tuscany Station"));
		allSpotsOnBoard.add(ict = new Property(320, 0, 0, 36, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200, "n/a", "ICT", "green"));
		allSpotsOnBoard.add(chance3 = new Chance(37 ,"Chance 3"));
		allSpotsOnBoard.add(eeel = new Property(350, 0, 0, 38, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200, "n/a", "EEEL", "dark blue"));
		//tuition
		allSpotsOnBoard.add(ti = new Property(400 , 0, 0, 40, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200, "n/a", "Taylor Institute", "dark blue"));
		
		
		
		//allProperties.add(new Property(60, 0, 0, 2, 2, 10, 30, 90, 160, 250, 30, 50, 50, "n/a", "Mediterranean Avenue", "brown"));
		
	}
	

	

}
