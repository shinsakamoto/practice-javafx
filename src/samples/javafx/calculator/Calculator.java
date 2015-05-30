package samples.javafx.calculator;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Just samples
 * 
 * @author sakamoto
 *
 */
public class Calculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = FXMLLoader.load(new File("resources/calculator.fxml").toURI().toURL());
        Scene scene = new Scene(pane, 520, 320);
        stage.setScene(scene);
        stage.show();
    }
}
