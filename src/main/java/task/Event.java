package task;

import java.time.LocalDateTime;


public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = parseDate(from);
        this.to = parseDate(to);
    }

    public Event(String description, String from, String to) {
        this(description, from, to, false);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
