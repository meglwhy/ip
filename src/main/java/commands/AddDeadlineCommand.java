package commands;

import storage.Storage;
import task.Deadline;
import task.TaskList;
import ui.Ui;

import java.io.IOException;

public class AddDeadlineCommand extends Command {
    private final String description;
    private final String by;

    public AddDeadlineCommand(String input) throws IOException {
        if (!input.contains("/by ")) {
            throw new IOException(" Deadline format: deadline <desc> /by yyyy-MM-dd HHmm");
        }
        String[] parts = input.replaceFirst("deadline ", "").split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new IOException(" Deadline format: deadline <desc> /by yyyy-MM-dd HHmm");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        try {
            tasks.add(new Deadline(description, by));
            ui.printMessage(" Got it. I've added this task:\n   " + tasks.getLastTask() +
                    "\n Now you have " + tasks.size() + " tasks in the list.");
        } catch (IllegalArgumentException e) {
            ui.printError(" Invalid date format :( - Try using yyyy-MM-dd HHmm.");
        }
    }
}
