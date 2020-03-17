

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenuController extends Board {
	private int playerCount;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="pane"
    private Pane pane; // Value injected by FXMLLoader
    
    @FXML // fx:id="textField"
    private TextField textField; // Value injected by FXMLLoader
    
    @FXML // fx:id="textFieldAI"
    private TextField textFieldAI; // Value injected by FXMLLoader
    
    public void setPlayerCount(int playerCount) {
    	this.playerCount = playerCount; 
    }
    
    public int getPlayerCount() {
    	return playerCount;
    }
    
    public void alert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR. INVALID INPUT");
		alert.setHeaderText("YOU HAVE ENTERED AN INVALID INPUT");
		alert.setContentText(message);
		alert.showAndWait();
    }
    
    public void prompt(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("ERROR. INVALID INPUT");
		alert.setHeaderText("YOU HAVE ENTERED AN INVALID INPUT");
		alert.setContentText(message);
		alert.showAndWait();
    }
    
    @FXML
    void enterNumberPlayersButton(ActionEvent event) {
    	if (textField.getText().equals("2")) {
    		playerCount = 2;
    		prompt("Enter a name");
    	}
    	else if (textField.getText().equals("3")) {
    		playerCount = 3;
    	}
    	else if (textField.getText().equals("4")) {
    		playerCount = 4;
    	}
    	else {
    		alert("Please enter a number between 2-4.");
    	}
    	textField.clear();
    }

    @FXML
    void enterNumberOfAIButton(ActionEvent event) {
    	if (textFieldAI.getText().equals("1")) {
    		playerCount = 2;
    	}
    	else if (textFieldAI.getText().equals("2")) {
    		playerCount = 3;
    	}
    	else if (textFieldAI.getText().equals("3")) {
    		playerCount = 4;
    	}
    	else {
    		alert("Please enter a number between 1-3.");
    	}
    	textFieldAI.clear();
    }

    @FXML
    void openGameButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/Monopoly.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));  
			stage.show();
			
			Image icon = new Image(getClass().getClassLoader().getResourceAsStream("images/Monopoly.png"));
    		
    		stage.getIcons().add(icon);
			
			pane.getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }
}