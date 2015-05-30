package samples.javafx.canvas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CanvasApp1Controller implements Initializable {

    private GraphicsContext gc;
    private Color color = Color.BLACK;;

    @FXML
    private Canvas canvas;
    @FXML
    private Button btnBlack;
    @FXML
    private Button btnRed;
    @FXML
    private Button btnBlue;
    @FXML
    private Button btnClear;
    @FXML
    private TextField text1;
    @FXML
    private ScrollPane pane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged((ev) -> {
            double x = ev.getX();
            double y = ev.getY();
            gc.setFill(color);
            gc.fillOval(x, y, 10, 10);
        });
        btnBlack.setOnAction((ev) -> {
            color = Color.BLACK;
        });
        btnRed.setOnAction((ev) -> {
            color = Color.RED;
        });
        btnBlue.setOnAction((ev) -> {
            color = Color.BLUE;
        });

        btnClear.setOnAction((ev) -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });
    }

}