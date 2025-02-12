package task;

import java.time.LocalDateTime;

/**
 * Represents a task that needs to be completed before a specific deadline.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructs a Deadline task.
     * @param description The task description.
     * @param by The deadline date in yyyy-MM-dd HHmm format.
     * @param isDone Whether the task is already completed.
     * @throws IllegalArgumentException If the deadline date format is invalid.
     */
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = parseDate(by);
        if (this.by == null) {
            throw new IllegalArgumentException(" Invalid deadline");
        }
    }

    /**
     * Constructs a new Deadline task that is initially not completed.
     * @param description The task description.
     * @param by The deadline date in yyyy-MM-dd HHmm format.
     */    public Deadline(String description, String by) {
        this(description, by, false); // calls new Deadline with isDone = false
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by.format(INPUT_FORMAT);
    }
}
