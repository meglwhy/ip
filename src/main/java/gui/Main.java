package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.DialogBox;

/**
 * The main JavaFX application for the chatbot.
 */
public class Main extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    // Load images from the resources folder (ensure images are at /src/main/resources/images/)
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.png"));
    private Image kojiImage = new Image(this.getClass().getResourceAsStream("/images/Koji.png"));

    @Override
    public void start(Stage stage) {
        // Set up the dialog container and scroll pane
        dialogContainer = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setContent(dialogContainer);

        // Set up user input field and send button
        userInput = new TextField();
        sendButton = new Button("Send");

        // Create the main layout and add all components
        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        // Set padding on the AnchorPane
        mainLayout.setStyle("-fx-padding: 10;");

        scene = new Scene(mainLayout);
        stage.setScene(scene);

        // Format the window
        stage.setTitle("Koji Chatbot");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);
        mainLayout.setPrefSize(400.0, 600.0);

        // Set scroll pane size and center it horizontally
        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
        AnchorPane.setTopAnchor(scrollPane, 10.0);
        AnchorPane.setLeftAnchor(scrollPane, 7.5);  // (400 - 385) / 2 = 7.5
        AnchorPane.setRightAnchor(scrollPane, 7.5);

        // Set user input field and send button so that their total width equals the scroll pane width (385)
        userInput.setPrefWidth(330.0);
        sendButton.setPrefWidth(55.0);
        // Position them at the bottom with padding
        AnchorPane.setLeftAnchor(userInput, 10.0);
        AnchorPane.setBottomAnchor(userInput, 10.0);
        AnchorPane.setRightAnchor(sendButton, 10.0);
        AnchorPane.setBottomAnchor(sendButton, 10.0);

        // Add a sample dialog box to the dialog container
        // For a bot message (Koji's message)
        DialogBox botDialog = DialogBox.getKojiDialog("Hello! I'm Koji.", kojiImage);
        dialogContainer.getChildren().add(botDialog);

        // For a user message
        DialogBox userDialog = DialogBox.getUserDialog("Hi Koji!", userImage);
        dialogContainer.getChildren().add(userDialog);


        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
