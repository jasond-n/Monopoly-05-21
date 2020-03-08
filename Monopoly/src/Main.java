import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Monopoly.fxml"));
		
		Scene scene = new Scene(root);
		Image icon = new Image(getClass().getResourceAsStream("Monopoly.jpg"));
		
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.setTitle("Monopoly");
		stage.show();
	}
}
