package samples.javafx.canvas;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * <img alt="image" src="./doc-files/CanvasApp1Simple.png">
 * 
 * @author sakamoto
 *
 */
public class CanvasApp1Simple extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = FXMLLoader.load(new File("resources/canvas1.fxml").toURI().toURL());

        Scene scene = new Scene(pane, 520, 320);
        stage.setScene(scene);
        stage.show();
    }
}
