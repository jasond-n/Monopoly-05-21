

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController extends Board {
	private int playerCount;
	private String playerName;

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
    
    public void setPlayerName(String playerName) {
    	this.playerName = playerName;
    }
    
    public String getPlayerName() {
    	return playerName;
    }
    
    public void alert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR. INVALID INPUT");
		alert.setHeaderText("YOU HAVE ENTERED AN INVALID INPUT");
		alert.setContentText(message);
		alert.showAndWait();
    }
    
    public void prompt(String message) {
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setTitle("Enter your character name?");
    	window.setMinWidth(350);
    	window.setMinHeight(250);
    	Label label = new Label();
    	label.setText(message);
		/*
		 * Button closeButton = new Button("Close Window"); Button enterButton = new
		 * Button("Enter"); TextField textFieldName = new TextField();
		 * 
		 * closeButton.setOnAction(e -> { window.close(); });
		 * 
		 * enterButton.setOnAction(e -> { playerName = textFieldName.getText();
		 * textFieldName.clear(); });
		 * 
		 * VBox vbox = new VBox(10); vbox.getChildren().addAll(label, textFieldName,
		 * enterButton, closeButton); vbox.setAlignment(Pos.CENTER); Scene scene = new
		 * Scene(vbox); window.setScene(scene);
		 */
    	window.showAndWait();
    }
    
    @FXML
    void openGameButton(ActionEvent event) {
    	String humanPlayerString = textField.getText();
    	String aiPlayerString = textFieldAI.getText();
    	int humanPlayerCount = Integer.parseInt(humanPlayerString);
		int aiPlayerCount = Integer.parseInt(aiPlayerString);
		if(humanPlayerCount + aiPlayerCount > 4 || humanPlayerCount + aiPlayerCount < 0)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR. INVALID INPUT");
			alert.setHeaderText("You entered more than 4 or less than 0 players");
			alert.showAndWait();
			return;
		}
		else
		{
			setPlayerCount(humanPlayerCount + aiPlayerCount);
			//prompt("Enter your name");
		}
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