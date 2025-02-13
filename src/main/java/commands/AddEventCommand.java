package commands;

import java.io.IOException;

import storage.Storage;
import task.Event;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to add an Event task.
 */
public class AddEventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Constructs an AddEventCommand.
     * @param input The full user input containing the event description and dates.
     * @throws IOException If the format is incorrect.
     */
    public AddEventCommand(String input) throws IOException {
        if (!input.contains("/from ") || !input.contains("/to ")) {
            throw new IOException(" Event format: event <desc> /from yyyy-MM-dd HHmm /to yyyy-MM-dd HHmm");
        }
        String[] parts = input.replaceFirst("event ", "").split(" /from | /to ", 3);
        if (parts.length < 3 || parts[0].trim().isEmpty()) {
            throw new IOException(" Event format: event <desc> /from yyyy-MM-dd HHmm /to yyyy-MM-dd HHmm");
        }
        this.description = parts[0].trim();
        this.from = parts[1].trim();
        this.to = parts[2].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        try {
            tasks.add(new Event(description, from, to));
            ui.printMessage(" Got it. I've added this task:\n   " + tasks.getLastTask()
                    + "\n Now you have " + tasks.size() + " tasks in the list.");
        } catch (IllegalArgumentException e) {
            ui.printError(" Invalid date format :( - Try using yyyy-MM-dd HHmm.");
        }
    }
}
