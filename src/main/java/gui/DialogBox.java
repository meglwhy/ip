package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Collections;

/**
 * Represents a dialog box consisting of an ImageView for the speaker's face
 * and a Label for the text message. Provides static factory methods to create
 * dialog boxes for user and system messages.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    /**
     * Private constructor that initializes the DialogBox by loading the FXML layout.
     * After loading, it sets the provided text and image.
     *
     * @param text The message text.
     * @param img  The image representing the speaker.
     */
    private DialogBox(String text, Image img) {
        loadFXML();
        dialog.setText(text);
        displayPicture.setImage(img);
    }

    /**
     * Loads the FXML layout for the dialog box and sets this object as both
     * the root and the controller.
     */
    private void loadFXML() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/DialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Flips the dialog box so that the ImageView is on the left and the text on the right.
     * This is used to differentiate between user and system messages.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Creates a dialog box for the user's message.
     * The dialog box displays text on the left and the user's image on the right.
     *
     * @param text The user's message.
     * @param img  The user's avatar image.
     * @return A DialogBox instance representing the user's message.
     */
    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img);
    }

    /**
     * Creates a dialog box for the system (Koji) message.
     * The dialog box is flipped so that the system's image appears on the left and the text on the right.
     *
     * @param text The system's message.
     * @param img  The system's avatar image.
     * @return A DialogBox instance representing the system's message.
     */
    public static DialogBox getKojiDialog(String text, Image img) {
        DialogBox db = new DialogBox(text, img);
        db.flip();
        return db;
    }
}