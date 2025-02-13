package commands;

import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to list the added tasks.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printMessage(" Here are the tasks in your list:");
        tasks.printTasks();
    }
}
