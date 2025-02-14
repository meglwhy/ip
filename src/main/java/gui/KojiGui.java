package gui;

import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * The main logic handler for the Koji chatbot application.
 * <p>
 * This class initializes the application's core components, including
 * {@link Storage} and {@link TaskList}, and processes user input to generate responses.
 * Currently, it simply echoes the user input with the prefix "Koji heard: ".
 * </p>
 */
public class KojiGui {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a KojiGui instance and initializes the necessary components.
     *
     * @param filePath The path to the storage file.
     */
    public KojiGui(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage);
        } catch (Exception e) {
            ui.printError("Error loading tasks.");
            throw new RuntimeException(e);
        }
    }

    /**
     * Processes user input and returns the corresponding response.
     * <p>
     * For now, Koji simply echoes the user input with the prefix "Koji heard: ".
     * </p>
     *
     * @param input The user's input command.
     * @return The response message.
     */
    public String getResponse(String input) {
        return "Koji heard: " + input;
    }
}
