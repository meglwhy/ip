package task;

/**
 * Represents a Todo task without a specific deadline.
 */
public class Todo extends Task {
    /**
     * Constructs a Todo task.
     * @param description The task description.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
