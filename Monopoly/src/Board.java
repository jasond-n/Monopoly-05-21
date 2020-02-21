

public class Board {
	private Property propertyName; //don't know what this is for but will leave it here
	private int freeParkingMoneyPool;
	public static Property mediterraneanAvenue; //this makes coding the gameconfig alot easier if we make them all public static just not sure about privacy leaks
	private Property balticAvenue;
	private Property orientalAvenue;
	private Property vermontAvenue;
	private Property connecticutAvenue;
	private Property stCharlesPlace;
	private Property statesAvenue;
	private Property virginiaAvenue;
	private Property stJamesPlace;
	private Property tennesseeAvenue;
	private Property newYorkAvenue;
	private Property kentuckyAvenue;
	private Property indianaAvenue;
	private Property illinoisAvenue;
	private Property atlanticAvenue;
	private Property ventnorAvenue;
	private Property marvinGardens;
	private Property pacificAvenue;
	private Property northCarolinaAvenue;
	private Property pennsylvaniaAvenue;
	private Property parkPlace;
	private Property boardwalk;

	
	
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
		mediterraneanAvenue = new Property(60, 0, 0, 2, 2, 10, 30, 90, 160, 250, 30, 50, 50, "n/a", "Mediterranean Avenue", "brown");
		balticAvenue = new Property(60, 0, 0, 4, 4, 20, 60, 180, 320, 450, 30, 50, 50, "n/a", "Baltic Avenue", "brown");
		orientalAvenue = new Property(100, 0, 0, 7, 6, 30, 90, 270, 400, 550, 50, 50, 50, "n/a", "Oriental Avenue", "light blue");
		vermontAvenue = new Property(100, 0, 0, 9, 6, 30, 90, 270, 400, 550, 50, 50, 50, "n/a", "Vermont Avenue", "light blue");
		connecticutAvenue = new Property(120, 0, 0, 10, 8, 40, 100, 300, 450, 600, 60, 50, 50, "n/a", "Connecticut Avenue", "light blue");
		stCharlesPlace = new Property(140, 0, 0, 12, 10, 50, 150, 450, 625, 750, 70, 100, 100, "n/a", "St. Charles Place", "pink");
		statesAvenue = new Property(140, 0, 0, 14, 10, 50, 150, 450, 625, 750, 70, 100, 100, "n/a", "States Avenue", "pink");
		virginiaAvenue = new Property(160, 0, 0, 15, 12, 60, 180, 500, 700, 900, 80, 100, 100, "n/a", "Virginia Avenue", "pink");
		stJamesPlace = new Property(180, 0, 0, 17, 14, 70, 200, 550, 750, 950, 90, 100, 100, "n/a", "St. James Place", "orange");
		tennesseeAvenue = new Property(180, 0, 0, 19, 14, 70, 200, 550, 750, 950, 90, 100, 100, "n/a", "Tennessee Avenue", "orange");
		newYorkAvenue = new Property(200, 0, 0, 20, 16, 80, 220, 600, 800, 1000, 100, 100, 100, "n/a", "New York Avenue", "orange");
		kentuckyAvenue = new Property(220, 0, 0, 22, 18, 90, 250, 700, 875, 1050, 110, 150, 150, "n/a", "Kentucky Avenue", "red");
		indianaAvenue = new Property(220, 0, 0, 24, 18, 90, 250, 700, 875, 1050, 110, 150, 150, "n/a", "Indiana Avenue", "red");
		illinoisAvenue = new Property(240, 0, 0, 25, 20, 100, 300, 750, 925, 1100, 120, 150, 150, "n/a", "Illinois Avenue", "red");
		atlanticAvenue = new Property(260, 0, 0, 27, 22, 110, 330, 800, 975, 1150, 130, 150, 150, "n/a", "Atlantic Avenue", "yellow");
		ventnorAvenue = new Property(260, 0, 0, 28, 22, 110, 330, 800, 975, 1150, 130, 150, 150, "n/a", "Ventnor Avenue", "yellow");
		marvinGardens = new Property(280, 0, 0, 30, 24, 120, 360, 850, 1025, 1200, 140, 150, 150, "n/a", "Marvin Gardens", "yellow");
		pacificAvenue = new Property(300, 0, 0, 32, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, "n/a", "Pacific Avenue", "green");
		northCarolinaAvenue = new Property(300, 0, 0, 33, 26, 130, 390, 900, 1100, 1275, 150, 200, 200, "n/a", "North Carolina Avenue", "green");
		pennsylvaniaAvenue = new Property(320, 0, 0, 35, 28, 150, 450, 1000, 1200, 1400, 160, 200, 200, "n/a", "Pennsylvania Avenue", "green");
		parkPlace = new Property(350, 0, 0, 38, 35, 175, 500, 1100, 1300, 1500, 175, 200, 200, "n/a", "Park Place", "dark blue");
		boardwalk = new Property(400 , 0, 0, 40, 50, 200, 600, 1400, 1700, 2000, 200, 200, 200, "n/a", "Boardwalk", "dark blue");
		
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
		
		
	}
	

	

}
