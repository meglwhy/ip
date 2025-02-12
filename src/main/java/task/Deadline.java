package task;

import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime by;

    // load from file
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = parseDate(by);
        if (this.by == null) {
            throw new IllegalArgumentException(" Invalid deadline");
        }
    }

    // calls new Deadline with isDone == false
    public Deadline(String description, String by) {
        this(description, by, false);
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
