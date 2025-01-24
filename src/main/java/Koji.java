import java.util.*;

public class Koji {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Koji");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String input = sc.nextLine().trim();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (input.equals("list")) {
                listTasks();
            } else if (input.startsWith("mark ")) {
                updateTaskStatus(input, true);
            } else if (input.startsWith("unmark ")) {
                updateTaskStatus(input, false);
            } else if (input.startsWith("todo ")) {
                addTask(new Todo(input.substring(5)));
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ", 2);
                addTask(new Deadline(parts[0], parts[1]));
            } else {
                String[] parts = input.substring(6).split(" /from ", 2);
                String[] times = parts[1].split(" /to ", 2);
                addTask(new Event(parts[0], times[0], times[1]));

            }
        }
        sc.close();
    }

    private static void addTask(Task task) {
        tasks.add(task);
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void listTasks() {
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list:");
        if (tasks.isEmpty()) {
            System.out.println("");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i).toString());
            }
        }
        System.out.println("____________________________________________________________");
    }

    private static void updateTaskStatus(String input, boolean markAsDone) {
            int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            if (markAsDone) {
                tasks.get(taskIndex).markAsDone();
            } else {
                tasks.get(taskIndex).markAsNotDone();
            }
            System.out.println("____________________________________________________________");
            System.out.println(markAsDone
                    ? " Nice! I've marked this task as done:"
                    : " OK, I've marked this task as not done yet:");
            System.out.println("   " + tasks.get(taskIndex));
            System.out.println("____________________________________________________________");

    }
}

abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}

