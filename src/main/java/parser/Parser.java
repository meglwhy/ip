package parser;

import commands.*;
import java.io.IOException;

public class Parser {
    public static Command parse(String input) throws IOException {
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.equals("list")) {
            return new ListCommand();
        } else if (input.startsWith("delete")) {
            return new DeleteCommand(input);
        } else if (input.startsWith("todo")) {
            return new AddTodoCommand(input);
        } else if (input.startsWith("deadline")) {
            return new AddDeadlineCommand(input);
        } else if (input.startsWith("event")) {
            return new AddEventCommand(input);
        } else {
            throw new IOException("Unknown command.");
        }
    }
}
