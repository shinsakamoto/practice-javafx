package samples.javafx.base;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class App8FXMLController {

    @FXML
    private Label label1;
    @FXML
    private Button btn1;
    @FXML
    private TextField text1;

    /**
     * This method is mapped in fxml file.<br>
     * see app8.fxml
     */
    public void onAction() {
        btn1.setOnAction((ActionEvent) -> {
            label1.setText(text1.getText());
        });
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        btn1.setOnAction((ActionEvent) -> {
            label1.setText(text1.getText());
        });
    }

}