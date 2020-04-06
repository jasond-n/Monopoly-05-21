
// the property class is used to represents all the landable spaces on the monopoly board. Because of this
// it is a parent class to the variety of other types of properties, including community chest, chance, utility, tax, railroad, etc.
public class Property {
	//These are all the necessary variables that define a property space.
	private int price, numOfHouses, numOfHotels, positionOnBoard, rentBase, rent1House, rent2House, rent3House, rent4House, rentHotel, houseCost, hotelCost;
	private String name, color;
	private Player owner;
	private String userInput;
	
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
	public Property(int price, int numOfHouses, int numOfHotels, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int houseCost, int hotelCost, Player owner, String name, String color) {
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
		setHouseCost(houseCost);
		setHotelCost(hotelCost);
		setOwner(owner); //name of owner of property
		setName(name); //name of the actual property
		setColor(color); //String of color
	}
	
	// this constructor is used to make special properties
	public Property(int price, int positionOnBoard, int rentBase, int rent1House, int rent2House, int rent3House, Player owner, String name, String color) {
		setPrice(price); //price of property
		setPositionOnBoard(positionOnBoard); //position of property 1-40
		setRentBase(rentBase);
		setRent1House(rent1House);
		setRent2House(rent2House);
		setRent3House(rent3House);
		setOwner(owner); //name of owner of property
		setName(name); //name of the actual property
		setColor(color); //String of color
	}
	
	//use this to make utility 
		public Property(int price, int positionOnBoard, int rentBase, int rent1House, Player owner, String name, String color) {
			setPrice(price); //price of property
			setPositionOnBoard(positionOnBoard); //position of property 1-40
			setRentBase(rentBase);
			setRent1House(rent1House);
			setOwner(owner); //name of owner of property
			setName(name); //name of the actual property
			setColor(color);
		}
		
		//use this to make community chest / chance / tax
		public Property(int positionOnBoard, Player owner, String name) {
			setPositionOnBoard(positionOnBoard); //position of property 1-40
			setName(name); //name of the actual property
			setOwner(owner);
			}
				
		//constructor for go
		public Property(int price, int positionOnBoard, String name) {
			setPrice(price);
			setPositionOnBoard(positionOnBoard); //position of property 1-40
			setName(name); //name of the actual property
		}
		
		public void setUserInput(String userInput) {
			this.userInput = userInput;
		}
		
		public String getUserInput() {
			return userInput;
		}
		
		//helper method to check truth values
		//checking ownership of the property spaces
		public boolean youAreNotOwner(Player player, Board board) {
			return board.getProperties().get(player.getPosition()).getOwner() != player && board.getProperties().get(player.getPosition()).getOwner() != null;
		}
		
		//helper method to check truth values
		public boolean noOneOwns(Player player, Board board) {
			return (board.getProperties().get(player.getPosition()).getOwner() == null )
			
			&& (board.getProperties().get(player.getPosition()).getName().startsWith("Community Chest") == false) 
			
			&& (board.getProperties().get(player.getPosition()).getName().startsWith("Chance") == false) 
			
			&& (board.getProperties().get(player.getPosition()).getName().equals("GO") == false);
		}
		
		//helper method to check truth values
		public boolean youOwn(Player player, Board board) {
			return board.getProperties().get(player.getPosition()).getOwner() == player;
		}
		
		//runs the logic side of of landing on a spot on the board
		public void doActionAfterPlayerLandingHere(Player player, int roll, Board board, Card cardDrawn)
		{
			String userInput;
			int multiplier = 1;
			//if you land on go
			if (player.getPosition() >= 0 && player.getPreviousPosition() < 0) {
				player.addMoney(50);
			}
			//figure out mortgages later
			//if you are not the owner
			if (youAreNotOwner(player, board)) {
				
				
				
				if (isMonopolized(player, board)) {
					multiplier = 2;
				}
				//add an if statement to see if the owner has a monopoly on all 3
				////System.out.println("You have to pay the owner of the property!");
				if (getNumOfHotels() == 0) {
					switch(getNumOfHouses()) {
					case 0: 
						player.loseMoney(getRentBase() * multiplier);
						board.getProperties().get(player.getPosition()).getOwner().addMoney(getRentBase() * multiplier);
						break;
					case 1: 
						player.loseMoney(getRent1House());
						board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent1House() * multiplier);
						break;
					case 2: 
						player.loseMoney(getRent2House());
						board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent2House() * multiplier);
						break;
					case 3: 
						player.loseMoney(getRent3House());
						board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent3House() * multiplier);
						break; 
					case 4: 
						player.loseMoney(getRent4House());
						board.getProperties().get(player.getPosition()).getOwner().addMoney(getRent4House() * multiplier);
						break;
					}
				}
				if (getNumOfHotels() == 1) {
					player.loseMoney(getRentHotel());
					board.getProperties().get(player.getPosition()).getOwner().addMoney(getRentHotel() * multiplier);
				}
			}
			//no one owns the property
			else if (noOneOwns(player, board)) 
			{
				//will wait for the show and wait
				//continue from here
				//the player is human so we have to wait for input
				if (player.getPlayerType().equals("human")) {
					userInput = getUserInput();
					if (userInput.equalsIgnoreCase("y")) {
						player.buyProperty(board.getProperties().get(player.getPosition()));
					}
				}
				else { //the player is a computer and will run the needed logic
					player.buyProperty(board.getProperties().get(player.getPosition()));
				}
			}
			//you own the property 
			else if (youOwn(player, board)){
				if (getNumOfHouses() == 4 && getNumOfHotels() == 0) {
					if (player.getPlayerType().equals("human")) {
						////System.out.print("would you like to buy a hotel? (y/n)");
						userInput = getUserInput();
						if (userInput.equalsIgnoreCase("y")) {
							player.buyHotel(board.getProperties().get(player.getPosition()));
						}
					}
					//computer player
					else {
						player.buyHotel(board.getProperties().get(player.getPosition()));
					}
				}
				//asks to buy a house if you have less than 4 houses
				if (getNumOfHouses() < 4 && getNumOfHotels() == 0) {
					
					
					
					////System.out.print("would you like to buy a house? (y/n)");
					userInput = getUserInput();
					if (userInput.equalsIgnoreCase("y")) {
						if (player.getPlayerType().equals("human")) {
							////System.out.print("would you like to buy a hotel? (y/n)");
							userInput = getUserInput();
							if (userInput.equalsIgnoreCase("y")) {
								player.buyHouse(board.getProperties().get(player.getPosition()));
							}
						}
						//computer player
						else {
							player.buyHouse(board.getProperties().get(player.getPosition()));
						}
					}
				}
			}
		}
		
		//helper method to see if the property that was landed on is monopolized
		public boolean isMonopolized(Player player, Board board) {
			String color2check = board.getProperties().get(player.getPosition()).getColor();
			int numOfColor = 0;
			boolean toReturn = false;
			for(int i = 0; i < player.getPlayerProperties().size(); i++) {
				if (player.getPlayerProperties().get(i).getColor().equalsIgnoreCase(color2check)) {
					numOfColor++;
				}
			}
			if (numOfColor == 2) {
				switch(color2check) {
				case "brown": 
				case "dark blue": 
					toReturn = true;
					break;
				}
			}
			if (numOfColor == 3) {
				switch(color2check) {
				case "light blue": 
				case "pink": 
				case "orange": 
				case "red": 
				case "yellow": 
				case "green": 
					toReturn = true;
					break;
				}
			}
			return toReturn;
		}
		
		/**
		 * placeholder method for the jail spot
		 * 
		 * */
		public void doActionBeforeLeavingHere(Player p, int roll, Board gameBoard) {
			
		}	
}