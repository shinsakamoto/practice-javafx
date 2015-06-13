package samples.javafx.base;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * How to use <br>
 * javafx.scene.layout.VBox<br>
 * javafx.scene.layout.HBox<br>
 * 
 * @author sakamoto
 *
 */
public class App4VBoxHbox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // VBox
        VBox box = new VBox(5.0d);
        Label label = new Label("Label");
        Text text = new Text("Text");
        TextField field = new TextField("TextField");
        Button button = new Button("Button");

        Separator separator = new Separator();

        HBox hbox1 = new HBox(5.0d);
        CheckBox checkBox1 = new CheckBox("CheckBox1");
        CheckBox checkBox2 = new CheckBox("CheckBox2");
        hbox1.getChildren().add(checkBox1);
        hbox1.getChildren().add(checkBox2);

        HBox hbox2 = new HBox(5.0d);
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("RadioButton1");
        RadioButton radioButton2 = new RadioButton("RadioButton2");
        RadioButton radioButton3 = new RadioButton("RadioButton3");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        hbox2.getChildren().add(radioButton1);
        hbox2.getChildren().add(radioButton2);
        hbox2.getChildren().add(radioButton3);

        ObservableList<String> list = FXCollections.observableArrayList("Menu1", "Menu2", "Menu3");
        ComboBox<String> comboBox = new ComboBox<>(list);
        comboBox.setValue(list.get(0));

        Slider slider = new Slider(0, 100, 0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);

        box.getChildren().add(label);
        box.getChildren().add(text);
        box.getChildren().add(field);
        box.getChildren().add(button);
        box.getChildren().add(separator);

        box.getChildren().add(hbox1);
        box.getChildren().add(hbox2);
        box.getChildren().add(comboBox);
        box.getChildren().add(slider);

        Scene scene = new Scene(box, 520, 320);
        stage.setScene(scene);
        stage.show();
    }
}
