import java.util.Scanner;

/*
 * If you add variables, make getters and setter please
 * 
 * 
 * 
 * 
 * */
public class Property {
	//initializing variables
	private int price, numOfHouses, numOfHotels, positionOnBoard, rentBase, rent1House, rent2House, rent3House, rent4House, rentHotel, mortgageValue, houseCost, hotelCost;
	// Owner is string but in UML Diagram it says Owner is of type Player object?????
	private String name, color;
	private Player owner;
	
	//Getters and Setters
	public Player getOwner() {
		return owner;
	}
	

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	private void setColor(String color) {
		this.color = color;
	}

	public int getNumOfHouses() {
		return numOfHouses;
	}

	public void setNumOfHouses(int numOfHouses) {
		this.numOfHouses = numOfHouses;
	}
	
	public void addNumOfHouses() {
		this.numOfHouses++;
	}

	public int getNumOfHotels() {
		return numOfHotels;
	}

	public void setNumOfHotels(int numOfHotels) {
		this.numOfHotels = numOfHotels;
	}

	public int getPositionOnBoard() {
		return positionOnBoard;
	}

	private void setPositionOnBoard(int positionOnBoard) {
		this.positionOnBoard = positionOnBoard;
	}

	public int getRentBase() {
		return rentBase;
	}

	private void setRentBase(int rentBase) {
		this.rentBase = rentBase;
	}

	public int getRent1House() {
		return rent1House;
	}

	private void setRent1House(int rent1House) {
		this.rent1House = rent1House;
	}

	public int getRent2House() {
		return rent2House;
	}

	private void setRent2House(int rent2House) {
		this.rent2House = rent2House;
	}

	public int getRent3House() {
		return rent3House;
	}

	private void setRent3House(int rent3Hourse) {
		this.rent3House = rent3Hourse;
	}

	public int getRent4House() {
		return rent4House;
	}

	private void setRent4House(int rent4House) {
		this.rent4House = rent4House;
	}

	public int getRentHotel() {
		return rentHotel;
	}

	private void setRentHotel(int rentHotel) {
		this.rentHotel = rentHotel;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	private void setMortgageValue(int mortgageValue) {
		this.mortgageValue = mortgageValue;
	}

	public int getHouseCost() {
		return houseCost;
	}

	private void setHouseCost(int houseCost) {
		this.houseCost = houseCost;
	}

	public int getHotelCost() {
		return hotelCost;
	}

	private void setHotelCost(int hotelCost) {
		this.hotelCost = hotelCost;
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	// Property constructor that takes in arguments
	public Property(int price, int numOfHouses, int numOfHotels, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int mortgageValue, int houseCost, int hotelCost, Player owner, String name, String color) {
		setPrice(price); //price of property
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
	}
	
	// use this to make special property
	// Property constructor that takes in no arguments 
	// This may for now cause a NullPointerException because of the fact that we are calling on objects  
	public Property(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int mortgageValue, Player owner, String name) {
		setPrice(price); //price of property
		setPositionOnBoard(positionOnBoard); //position of property 1-40
		setRentBase(rentBase);
		setRent1House(rent1House);
		setRent2House(rent2House);
		setRent3House(rent3House);
		setMortgageValue(mortgageValue);
		setOwner(owner); //name of owner of property
		setName(name); //name of the actual property
	}
	
	//use this to make utility
		// Property constructor that takes in no arguments 
		// This may for now cause a NullPointerException because of the fact that we are calling on objects  
		public Property(int price, int positionOnBoard, int rentBase, int rent1House, int mortgageValue, Player owner, String name) {
			setPrice(price); //price of property
			setPositionOnBoard(positionOnBoard); //position of property 1-40
			setRentBase(rentBase);
			setRent1House(rent1House);
			setMortgageValue(mortgageValue);
			setOwner(owner); //name of owner of property
			setName(name); //name of the actual property
		}
		
		//use this to make comunity chest / chance / tax
				// Property constructor that takes in no arguments 
				// This may for now cause a NullPointerException because of the fact that we are calling on objects  
				public Property(int positionOnBoard,  String name) {
					setPositionOnBoard(positionOnBoard); //position of property 1-40
					setName(name); //name of the actual property
				}
		
		public Property(int price, int positionOnBoard) {
			setPrice(price);
			setPositionOnBoard(positionOnBoard); //position of property 1-40
		}
		
		public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
		{
			String userInput;
			//figure out mortgages later
			//if you are not the owner
			if (board.getProperties().get(getPositionOnBoard()).getOwner() != player) {
				System.out.println("You have  to pay the owner of the property!");
				if (getNumOfHotels() == 0) {
					switch(getNumOfHouses()) {
					case 0: 
						player.loseMoney(getRentBase());
						board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRentBase());
						break;
					case 1: 
						player.loseMoney(getRent1House());
						board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent1House());
						break;
					case 2: 
						player.loseMoney(getRent2House());
						board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent2House());
						break;
					case 3: 
						player.loseMoney(getRent3House());
						board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent3House());
						break; 
					case 4: 
						player.loseMoney(getRent4House());
						board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRent4House());
						break;
					}
				}
				
				if (getNumOfHotels() == 1) {
					player.loseMoney(getRentHotel());
					board.getProperties().get(getPositionOnBoard()).getOwner().addMoney(getRentHotel());
				}
			}
			//no one owns the property
			else if (board.getProperties().get(getPositionOnBoard()).getOwner() == null) {
				Scanner sc = new Scanner(System.in);
					System.out.print("would you like to buy this property? (y/n)");
					userInput = sc.next();
					
					if (userInput.equalsIgnoreCase("y")) {
						if (player.getBalance() - getPrice() >= 0) {
							setOwner(player);
							player.loseMoney(getPrice());
							System.out.println("You just bought: " + getName());
						}
						else {
							System.out.println("Sorry You do not have enough money to buy this");
						}
					}
					
				
				sc.close();
			}
			//you own the property 
			else {
				//asks to buy a house if you have less than 4 houses
				
				if (getNumOfHouses() < 4 && getNumOfHotels() == 0) {
					Scanner sc = new Scanner(System.in);
					System.out.print("would you like to buy a house? (y/n)");
					userInput = sc.next();
	
					if (userInput.equalsIgnoreCase("y")) {
						if (player.getBalance() - getHouseCost() >= 0) {
							addNumOfHouses();
							player.loseMoney(getHouseCost());
							System.out.println("You just bought a house ");
						}
						else {
							System.out.println("Sorry You do not have enough money to buy this");
						}
					}
					
					sc.close();
				}
			}
			
			
			
			
		}
				
		public void doActionBeforePlayerLeavingingHere(Player player,  Board board)
		{
			
		}
	
}
