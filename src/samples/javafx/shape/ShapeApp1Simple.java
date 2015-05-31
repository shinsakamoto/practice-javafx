package samples.javafx.shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * How to use shape.<br/>
 * 
 * @author sakamoto
 *
 */
public class ShapeApp1Simple extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        Circle circle1 = new Circle(160, 160, 120);
        Circle circle2 = new Circle(100, 120, 20);
        Circle circle3 = new Circle(160, 120, 20);
        Rectangle rectangle = new Rectangle(100, 160, 60, 20);

        circle1.setFill(Color.LINEN);
        circle2.setFill(Color.BLACK);
        circle3.setFill(Color.BLACK);
        rectangle.setFill(Color.RED);

        root.getChildren().add(circle1);
        root.getChildren().add(circle2);
        root.getChildren().add(circle3);
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();

    }
}
