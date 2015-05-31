package samples.javafx.shape;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * How to use javafx animation<br/>
 * 
 * @author sakamoto
 *
 */
public class ShapeApp2Animation extends Application {

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

        Rotate rotate = Transform.rotate(0, 160, 110);
        root.getTransforms().add(rotate);

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), -45)), new KeyFrame(Duration.millis(1_000), new KeyValue(rotate.angleProperty(), 45, Interpolator.EASE_BOTH)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();

    }
}
