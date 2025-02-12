package commands;

import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

import java.io.IOException;

import java.util.ArrayList;

/**
 * Represents a command to find tasks that match a given keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructs a FindCommand.
     * @param input The full user input containing the search keyword.
     * @throws IOException If the keyword is missing.
     */
    public FindCommand(String input) throws IOException {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new IOException(" Find what?? Keyword required.");
        }
        this.keyword = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> filteredTasks = tasks.findTasks(keyword);

        if (filteredTasks.isEmpty()) {
            ui.printMessage(" No matching tasks found.");
        } else {
            ui.printMessage(" Here are the matching tasks in your list:");
            for (int i = 0; i < filteredTasks.size(); i++) {
                ui.printMessage(" " + (i + 1) + ". " + filteredTasks.get(i));
            }
        }
    }
}
