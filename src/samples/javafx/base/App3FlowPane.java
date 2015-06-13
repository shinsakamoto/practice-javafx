package samples.javafx.base;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * How to use <br>
 * javafx.scene.layout.FlowPane<br>
 * <img alt="image" src="./doc-files/App3FlowPane.png">
 * 
 * @author sakamoto
 *
 */
public class App3FlowPane extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label label = new Label("Hello JavaFX");
		FlowPane pane = new FlowPane();
		pane.getChildren().add(label);
		Scene scene = new Scene(pane, 520, 320);
		stage.setScene(scene);
		stage.show();
	}
}
