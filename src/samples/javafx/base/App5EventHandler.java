package samples.javafx.base;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * How to use <br/>
 * javafx.event.EventHandler<br/>
 * 
 * @author sakamoto
 *
 */
public class App5EventHandler extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Label label;
    private TextField text;
    private Button button;

    @Override
    public void start(Stage stage) throws Exception {
        label = new Label("How to use EventHandler");
        text = new TextField("Initial Text");
        button = new Button("Set text");

        VBox box = new VBox(5.0d);
        box.getChildren().add(label);
        box.getChildren().add(text);
        box.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText(text.getText());
            }
        });

        Scene scene = new Scene(box, 520, 320);
        stage.setScene(scene);
        stage.show();
    }
}
