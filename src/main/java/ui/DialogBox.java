package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a custom dialog box consisting of a message and an avatar image.
 */
public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    /**
     * Private constructor for creating a DialogBox.
     * @param s The dialog text.
     * @param i The avatar image.
     */
    private DialogBox(String s, Image i) {
        text = new Label(s);
        text.setWrapText(true);
        displayPicture = new ImageView(i);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);

        // Set margin on the text node to pad it away from the image.
        HBox.setMargin(text, new Insets(0, 10, 0, 10));
    }

    /**
     * Creates a DialogBox for the user's message.
     * The dialog box is right-aligned with the text on the left and the image on the right.
     * @param s The user's message.
     * @param i The user's avatar image.
     * @return A DialogBox instance representing the user's message.
     */
    public static DialogBox getUserDialog(String s, Image i) {
        DialogBox db = new DialogBox(s, i);
        db.getChildren().addAll(db.text, db.displayPicture);
        db.setAlignment(Pos.TOP_RIGHT);
        return db;
    }

    /**
     * Creates a DialogBox for the bot's (Koji's) message.
     * The dialog box is left-aligned with the image on the left and the text on the right.
     * @param s The bot's message.
     * @param i The bot's avatar image.
     * @return A DialogBox instance representing the bot's message.
     */
    public static DialogBox getKojiDialog(String s, Image i) {
        DialogBox db = new DialogBox(s, i);
        db.getChildren().addAll(db.displayPicture, db.text);
        db.setAlignment(Pos.TOP_LEFT);
        return db;
    }
}
