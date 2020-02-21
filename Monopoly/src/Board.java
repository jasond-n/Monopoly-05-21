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
	//chance1
	private Property bioSci;
	private Property alma;
	//jail
	private Property reeveTheatre;
	private Property zipper;
	private Property kinesB;
	private Property kinesA;
	private RailroadProperty cityHall;
	private Property scurfield;
	private CommunityChest communityChest2;
	private Property professional;
	private Property scienceA;
	//free parking
	private Property olympicOval;
	//chance2
	private Property murrayFraser;
	private Property scienceTheatres;
	private RailroadProperty university;
	private Property admin;
	private Property macHall;
	private Property gym;
	private Property education;
	//goto jail
	private Property tfdl;
	private Property schulich;
	private CommunityChest communityChest3;
	private RailroadProperty tuscany;
	private Property ict;
	//chance 3
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

		Card money1 = new Card("You have just recieved your student loans. Collect $50.", "money", 50);
		Card money2 = new Card("A bus just ran you over on campus. Collect $150 from the lawsuit settlement.", "money", 150);
		Card money3 = new Card("Pay $15 for a pizza bun at Bake Chef.", "money", -15);
		Card money4 = new Card("You got a scholarship for maintaining a 4.0 GPA last semester. Collect $100", "money", 100);
		Card move1 = new Card("MATH 265 has no more open lecture seats left this semester. Move back 3 spaces.","move", -3);
		Card move2 = new Card("Advance to GO. Collect $200.", "move", 1);
		// in move2, value = 1 represents the index for the GO space. use 41 - player.getLocation() instead? the number of spaces player needs to go forwards to get to GO. (player get location is needed)	
		Card move3 = new Card("Advance to Science Theatres. If you pass GO, collect $200", "move", 25);
		Card move4 = new Card("Advance to Reeve Theatre. If you pass GO, collect $200.", "move", 12);
		Card move5 = new Card("Take a trip to Somerset Station. If you pass Go, collect $200", "move", 6);
		// advance to nearest utility. If owned, throw dice and pay owner a total 10 times the amount thrown.
		// Advance to nearest Railroad and pay owner twice the rental amount.
		// Get out of Jail Free. This card may be kept until needed, or traded/sold.
		// Make general repairs on all your property: For each house pay $25, For each hotel pay $100.
		// You have been elected as an SU faculty representative. Pay each player $50.
		
		allSpotsOnBoard = new ArrayList<Property>();
		//in the constructor possibly add number of players?
		allSpotsOnBoard.add(go = new Property(200));
		allSpotsOnBoard.add(cragie = new Property(60, 0, 0, 2, 2, 10, 30, 90, 160, 250, 30, 50, 50, "n/a", "Cragie Hall", "brown"));
		allSpotsOnBoard.add(communityChest1 = new CommunityChest(3 ,"Community Chest 1"));
		//rent fee
		allSpotsOnBoard.add(scienceB = new Property(60, 0, 0, 5, 4, 20, 60, 180, 320, 450, 30, 50, 50, "n/a", "Science B", "brown"));
		allSpotsOnBoard.add(somerset = new RailroadProperty(200, 6, 25, 50, 100, 200, 100, "n/a", "Somerset Station"));
		allSpotsOnBoard.add(mathScience = new Property(100, 0, 0, 7, 6, 30, 90, 270, 400, 550, 50, 50, 50, "n/a", "Math Sciences", "light blue"));
		//chance
		allSpotsOnBoard.add(bioSci = new Property(100, 0, 0, 9, 6, 30, 90, 270, 400, 550, 50, 50, 50, "n/a", "Biological Sciences", "light blue"));
		allSpotsOnBoard.add(alma = new Property(120, 0, 0, 10, 8, 40, 100, 300, 450, 600, 60, 50, 50, "n/a", "Hotel Alma", "light blue"));
		//jail
		allSpotsOnBoard.add(reeveTheatre = new Property(140, 0, 0, 12, 10, 50, 150, 450, 625, 750, 70, 100, 100, "n/a", "Reeve Theatre", "pink"));
		//zipper
		allSpotsOnBoard.add(kinesB = new Property(140, 0, 0, 14, 10, 50, 150, 450, 625, 750, 70, 100, 100, "n/a", "Kineseology B", "pink"));
		allSpotsOnBoard.add(kinesA = new Property(160, 0, 0, 15, 12, 60, 180, 500, 700, 900, 80, 100, 100, "n/a", "Kineseology A", "pink"));
		allSpotsOnBoard.add(cityHall = new RailroadProperty(200, 16, 25, 50, 100, 200, 100, "n/a", "City Hall Station"));
		allSpotsOnBoard.add(scurfield = new Property(180, 0, 0, 17, 14, 70, 200, 550, 750, 950, 90, 100, 100, "n/a", "Scurfield Hall", "orange"));
		allSpotsOnBoard.add(communityChest2 = new CommunityChest(18 ,"Community Chest 2"));
		allSpotsOnBoard.add(professional = new Property(180, 0, 0, 19, 14, 70, 200, 550, 750, 950, 90, 100, 100, "n/a", "Professional Faculty", "orange"));
		allSpotsOnBoard.add(scienceA = new Property(200, 0, 0, 20, 16, 80, 220, 600, 800, 1000, 100, 100, 100, "n/a", "Science A", "orange"));
		//free parking
		allSpotsOnBoard.add(olympicOval = new Property(220, 0, 0, 22, 18, 90, 250, 700, 875, 1050, 110, 150, 150, "n/a", "Olympic Oval", "red"));
		//chance
		allSpotsOnBoard.add(murrayFraser = new Property(220, 0, 0, 24, 18, 90, 250, 700, 875, 1050, 110, 150, 150, "n/a", "Murray Fraser Hall", "red"));
		scienceTheatres = new Property(240, 0, 0, 25, 20, 100, 300, 750, 925, 1100, 120, 150, 150, "n/a", "Science Theatres", "red");
		allSpotsOnBoard.add(university = new RailroadProperty(200, 26, 25, 50, 100, 200, 100, "n/a", "University Staiton"));
		allSpotsOnBoard.add(admin = new Property(260, 0, 0, 27, 22, 110, 330, 800, 975, 1150, 130, 150, 150, "n/a", "Administration Building", "yellow"));
		allSpotsOnBoard.add(macHall = new Property(260, 0, 0, 28, 22, 110, 330, 800, 975, 1150, 130, 150, 150, "n/a", "Macewan Hall", "yellow"));
		//gym
		allSpotsOnBoard.add(education = new Property(280, 0, 0, 30, 24, 120, 360, 850, 1025, 1200, 140, 150, 150, "n/a", "Werklund School of Education", "yellow"));
		//gotojail
		allSpotsOnBoard.add(tfdl = new Property(300, 0, 0, 32, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, "n/a", "Taylor Family Digital Library", "green"));
		allSpotsOnBoard.add(schulich = new Property(300, 0, 0, 33, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, "n/a", "Schulich School of Engineering", "green"));
		allSpotsOnBoard.add(communityChest3 = new CommunityChest(34 ,"Community Chest 3"));
		allSpotsOnBoard.add(tuscany = new RailroadProperty(200, 35, 25, 50, 100, 200, 100, "n/a", "Tuscany Station"));
		allSpotsOnBoard.add(ict = new Property(320, 0, 0, 36, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200, "n/a", "ICT", "green"));
		//chance
		allSpotsOnBoard.add(eeel = new Property(350, 0, 0, 38, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200, "n/a", "EEEL", "dark blue"));
		//tuition
		allSpotsOnBoard.add(ti = new Property(400 , 0, 0, 40, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200, "n/a", "Taylor Institute", "dark blue"));
		
		
		
		//allProperties.add(new Property(60, 0, 0, 2, 2, 10, 30, 90, 160, 250, 30, 50, 50, "n/a", "Mediterranean Avenue", "brown"));
		
	}
	

	

}
