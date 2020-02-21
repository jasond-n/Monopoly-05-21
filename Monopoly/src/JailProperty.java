
public class JailProperty extends Property {
	
	//railroads
	public SpecialProperty(int price, int positionOnBoard, int rentBase, int rent2, int rent3, int rent4, int mortgageValue, String owner, String name) {
		super(price, positionOnBoard, rentBase, rent2, rent3, rent4, mortgageValue, owner, name);
	}
	
	//utilities
	public SpecialProperty(int price, int positionOnBoard, int rentBase, int rent2, int mortgageValue, String owner, String name) {
		super(price, positionOnBoard, rentBase, rent2, mortgageValue, owner, name);
	}

}
