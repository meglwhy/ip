package task;

public class Deadline extends Task {
    protected String by;

    // load from file
    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    // calls new Deadline with isDone == false
    public Deadline(String description, String by) {
        this(description, by, false);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
