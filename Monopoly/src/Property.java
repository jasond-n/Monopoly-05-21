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
	private String owner, name, color;
	
	//Getters and Setters
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumOfHouses() {
		return numOfHouses;
	}

	public void setNumOfHouses(int numOfHouses) {
		this.numOfHouses = numOfHouses;
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

	public void setPositionOnBoard(int positionOnBoard) {
		this.positionOnBoard = positionOnBoard;
	}

	public int getRentBase() {
		return rentBase;
	}

	public void setRentBase(int rentBase) {
		this.rentBase = rentBase;
	}

	public int getRent1House() {
		return rent1House;
	}

	public void setRent1House(int rent1House) {
		this.rent1House = rent1House;
	}

	public int getRent2House() {
		return rent2House;
	}

	public void setRent2House(int rent2House) {
		this.rent2House = rent2House;
	}

	public int getRent3House() {
		return rent3House;
	}

	public void setRent3House(int rent3Hourse) {
		this.rent3House = rent3Hourse;
	}

	public int getRent4House() {
		return rent4House;
	}

	public void setRent4House(int rent4House) {
		this.rent4House = rent4House;
	}

	public int getRentHotel() {
		return rentHotel;
	}

	public void setRentHotel(int rentHotel) {
		this.rentHotel = rentHotel;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public void setMortgageValue(int mortgageValue) {
		this.mortgageValue = mortgageValue;
	}

	public int getHouseCost() {
		return houseCost;
	}

	public void setHouseCost(int houseCost) {
		this.houseCost = houseCost;
	}

	public int getHotelCost() {
		return hotelCost;
	}

	public void setHotelCost(int hotelCost) {
		this.hotelCost = hotelCost;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Property constructor that takes in arguments
	public Property(int price, int numOfHouses, int numOfHotels, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int mortgageValue, int houseCost, int hotelCost, String owner, String name, String color) {
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
	
	// Property constructor that takes in no arguments 
	// This may for now cause a NullPointerException because of the fact that we are calling on objects  
	public Property() {
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
	
}
