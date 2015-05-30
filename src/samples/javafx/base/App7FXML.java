package samples.javafx.base;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * How to use <br/>
 * fxml<br/>
 * Handler mapping with Initializable<br/>
 * 
 * @author sakamoto
 *
 */
public class App7FXML extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = FXMLLoader.load(new File("resources/app7.fxml").toURI().toURL());
        Scene scene = new Scene(pane, 520, 320);
        stage.setScene(scene);
        stage.show();
    }
}
