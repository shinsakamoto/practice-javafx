package samples.javafx.base;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX application have to extends javafx.application.Application class. <br>
 * <img alt="image" src="./doc-files/App1Simple.png">
 * 
 * @author sakamoto
 *
 */
public class App1Simple extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
	}
}
