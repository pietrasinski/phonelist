package phonelist.java.fx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("phone.fxml"));
		VBox stackPane = loader.load();
		Scene scena = new Scene(stackPane);	
		primaryStage.setScene(scena);
		primaryStage.setTitle("Phone List");
		primaryStage.show();
		
	}

}
