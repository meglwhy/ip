package commands;

import commands.Command;
import storage.Storage;
import task.TaskList;
import task.Todo;
import ui.Ui;

import java.io.IOException;

public class AddTodoCommand extends Command {
    private final String description;

    public AddTodoCommand(String input) {
        this.description = input.replaceFirst("todo ", "").trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        if (description.isEmpty()) {
            throw new IOException(" Todo description cannot be empty.");
        }
        tasks.add(new Todo(description, false));
        ui.printMessage(" Got it. I've added this task:\n   " + tasks.getLastTask() +
                "\n Now you have " + tasks.size() + " tasks in the list.");
    }
}
