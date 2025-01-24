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
            } else {
                addTask(input);
            }
        }
        sc.close();
    }

    private static void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("____________________________________________________________");
        System.out.println(" added: " + description);
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
        try {
            int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            if (taskIndex < 0 || taskIndex >= tasks.size()) {
                throw new NumberFormatException();
            }
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
        } catch (Exception e) {
            System.out.println("____________________________________________________________");
            System.out.println(" Invalid task number. Please enter a valid task index.");
            System.out.println("____________________________________________________________");
        }
    }
}

class Task {
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