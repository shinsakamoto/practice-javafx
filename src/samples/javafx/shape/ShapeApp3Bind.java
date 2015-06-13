package samples.javafx.shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * How to use bind<br>
 * 
 * @author sakamoto
 *
 */
public class ShapeApp3Bind extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Face face1 = new Face();
        Face face2 = new Face();

        Arrow lines = new Arrow(200);
        lines.translateXProperty().bind(face1.translateXProperty().add(300));
        lines.translateYProperty().bind(face1.translateYProperty().add(150));

        face2.translateXProperty().bind(face1.translateXProperty().add(500));
        face2.translateYProperty().bind(face1.translateYProperty());

        root.getChildren().add(lines);
        root.getChildren().add(face1);
        root.getChildren().add(face2);

        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.show();

    }
}

class Arrow extends Group {
    public Arrow(double length) {
        Line line1 = new Line(0, 0, length, 0);
        line1.setStroke(Color.LIGHTGREEN);
        line1.setStrokeWidth(10);
        Line line2 = new Line(length, 0, length - 20, 10);
        line2.setStroke(Color.LIGHTGREEN);
        line2.setStrokeWidth(10);
        Line line3 = new Line(length, 0, length - 20, -10);
        line3.setStroke(Color.LIGHTGREEN);
        line3.setStrokeWidth(10);
        getChildren().add(line1);
        getChildren().add(line2);
        getChildren().add(line3);
    }
}

class Face extends Group {
    private double dragBaseX;
    private double dragBaseY;

    public Face() {
        Circle circle1 = new Circle(160, 160, 120);
        Circle circle2 = new Circle(100, 120, 20);
        Circle circle3 = new Circle(160, 120, 20);
        Rectangle rectangle = new Rectangle(100, 160, 60, 20);
        Text text = new Text("drag me");
        text.setX(115);
        text.setY(20);

        circle1.setFill(Color.LINEN);
        circle2.setFill(Color.BLACK);
        circle3.setFill(Color.BLACK);
        rectangle.setFill(Color.RED);

        getChildren().add(circle1);
        getChildren().add(circle2);
        getChildren().add(circle3);
        getChildren().add(rectangle);
        getChildren().add(text);

        circle1.setOnMousePressed((ev) -> {
            dragBaseX = ev.getSceneX() - getTranslateX();
            dragBaseY = ev.getSceneY() - getTranslateY();
        });

        circle1.setOnMouseDragged((ev) -> {
            try {
                setTranslateX(ev.getSceneX() - dragBaseX);
                setTranslateY(ev.getSceneY() - dragBaseY);
            } catch (Throwable e) {
                System.err.println("bind is one way.");
                text.setText("bind is one way");
                text.setStroke(Color.RED);
            }
        });

    }
}
