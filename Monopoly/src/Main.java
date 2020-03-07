import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Monopoly.fxml"));
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("Monopoly");
		stage.show();
		
		Alert badGrade = new Alert(AlertType.CONFIRMATION);
		badGrade.setTitle("Please make a decision");
		badGrade.setHeaderText("either type yes or no");
	
		badGrade.showAndWait();
		//return;
	}
}
