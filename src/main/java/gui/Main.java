package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The main entry point for the JavaFX application.
 * <p>
 * This class initializes and launches the GUI for the Koji application.
 * It loads the {@code MainWindow.fxml} file and sets up the primary stage.
 * </p>
 */
public class Main extends Application {
    private final KojiGui kojiGui = new KojiGui("data/koji.txt");

    /**
     * Starts the JavaFX application by setting up the primary stage.
     * <p>
     * Loads the {@code MainWindow.fxml} layout, sets the scene, and initializes the
     * {@link KojiGui} instance for handling interactions.
     * </p>
     *
     * @param stage The primary stage for the JavaFX application.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Koji - Task Manager");
            fxmlLoader.<MainWindow>getController().setKojiGui(kojiGui);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
