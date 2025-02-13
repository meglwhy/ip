package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A simple JavaFX GUI for the chatbot.
 */
public class Main extends Application {

    // If your chatbot requires a file path or other parameters,
    // you can provide an overloaded constructor.
    // The no-argument constructor is used by JavaFX.
    private static final String DEFAULT_FILE_PATH = "data/duke.txt";

    private String filePath;

    /**
     * Constructs a Main application with a given file path.
     * @param filePath The file path for loading chatbot data.
     */
    public Main(String filePath) {
        this.filePath = filePath;
    }

    /**
     * No-argument constructor for JavaFX.
     * Calls the parameterized constructor with a default file path.
     */
    public Main() {
        this(DEFAULT_FILE_PATH);
    }

    @Override
    public void start(Stage stage) {
        System.out.println("DEBUG: Main.start() is called.");

        Label helloWorld = new Label("Hello World!");
        AnchorPane root = new AnchorPane(helloWorld);
        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Koji Chatbot");
        stage.show();

        System.out.println("DEBUG: Stage is shown.");
    }
}
