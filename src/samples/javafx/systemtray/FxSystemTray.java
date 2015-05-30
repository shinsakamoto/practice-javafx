package samples.javafx.systemtray;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

/**
 * System Tray sample for JavaFX Application.
 * 
 * @author sakamoto
 */
public class FxSystemTray extends Application {

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Platform.setImplicitExit(false);
        SwingUtilities.invokeLater(this::createTray);
        stage.setOnCloseRequest((ev) -> {
            stage.hide();
        });

        VBox pane = FXMLLoader.load(getClass().getResource("app.fxml"));
        Scene scene = new Scene(pane, 520, 320);
        stage.setScene(scene);
        stage.show();
    }

    private void showStage() {
        if (stage != null) {
            stage.show();
            stage.toFront();
        }
    }

    private void createTray() {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = ImageIO.read(getClass().getResourceAsStream("icon.png"));
            TrayIcon trayIcon = new TrayIcon(image);

            PopupMenu menu = new PopupMenu();
            MenuItem menu1 = new MenuItem("Setting...");
            menu1.addActionListener(event -> Platform.runLater(this::showStage));

            MenuItem menu2 = new MenuItem("Exit");
            menu2.addActionListener(event -> {
                Platform.exit();
                tray.remove(trayIcon);
            });

            menu.add(menu1);
            menu.add(menu2);
            trayIcon.setPopupMenu(menu);
            tray.add(trayIcon);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
