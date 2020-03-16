package GUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Splash Screen.fxml"));
		
		Scene scene = new Scene(root);
		Image icon = new Image(getClass().getClassLoader().getResourceAsStream("images/Monopoly.png"));
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.getIcons().add(icon);
		stage.setScene(scene);
		stage.show();
	}
}
