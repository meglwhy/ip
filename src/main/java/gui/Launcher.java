package gui;

import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues when launching JavaFX applications.
 */
public class Launcher {
    public static void main(String[] args) {
        javafx.application.Application.launch(Main.class, args);
    }
}

