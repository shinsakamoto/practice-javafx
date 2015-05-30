package samples.javafx.base;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class App7FXMLController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private Button btn1;
    @FXML
    private TextField text1;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btn1.setOnAction((ActionEvent) -> {
            label1.setText(text1.getText());
        });
    }

}