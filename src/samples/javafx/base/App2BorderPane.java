package samples.javafx.base;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * How to use <br/>
 * javafx.scene.layout.BorderPane<br/>
 * javafx.scene.Scene <br/>
 * javafx.scene.control.Label<br/>
 * javafx.stage.Stage<br/>
 * 
 * @author sakamoto
 *
 */
public class App2BorderPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hello JavaFX");
        BorderPane pane = new BorderPane();
        pane.setCenter(label);
        Scene scene = new Scene(pane, 520, 320);
        stage.setScene(scene);
        stage.show();
    }
}
