package task;

import java.time.LocalDateTime;

/**
 * Represents an event with a start and end date.
 */
public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    /**
     * Constructs an Event task.
     * @param description The event description.
     * @param from The event start time in yyyy-MM-dd HHmm format.
     * @param to The event end time in yyyy-MM-dd HHmm format.
     * @param isDone Whether the event has already happened.
     * @throws IllegalArgumentException If the date format is invalid.
     */
    public Event(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = parseDate(from);
        this.to = parseDate(to);

        if (this.to == null || this.from == null) {
            throw new IllegalArgumentException(" Invalid date format.");
        }
    }

    /**
     * Constructs an Event task that is initially not completed.
     * @param description The event description.
     * @param from The event start time in yyyy-MM-dd HHmm format.
     * @param to The event end time in yyyy-MM-dd HHmm format.
     */
    public Event(String description, String from, String to) {
        this(description, from, to, false);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(OUTPUT_FORMAT) + " to: " + to.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from.format(INPUT_FORMAT) + " | " + to.format(INPUT_FORMAT);
    }
}
