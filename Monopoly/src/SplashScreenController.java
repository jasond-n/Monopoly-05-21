/**
 * Sample Skeleton for 'splash screen.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SplashScreenController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="pane"
    private Pane pane; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'Splash Screen.fxml'.";
    }
    
    class SplashScreen extends Thread {
    	
    	@Override
    	public void run() {
    		try {
    		Thread.sleep(2500);
    		
    		Platform.runLater(new Runnable() {
    			@Override
    			public void run() {
    				Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Main Menu Screen.fxml"));
					} catch (IOException e) {
						Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, e);
					}
    	    		Scene scene = new Scene(root);
    	    		Stage stage = new Stage();
    	    		
    	    		Image icon = new Image(getClass().getClassLoader().getResourceAsStream("images/Monopoly.png"));
    	    		
    	    		stage.getIcons().add(icon);
    	    		stage.setScene(scene);
    	    		stage.setTitle("Monopoly");
    	    		stage.show();
    	    		
    	    		pane.getScene().getWindow().hide();
    			}
    		});
    		
    		} catch (InterruptedException ex) {
    			Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
    		}
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		new SplashScreen().start();
	}
}
