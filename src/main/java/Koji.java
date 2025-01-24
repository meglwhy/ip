import java.util.*;

//public class Koji {
//    private static ArrayList<Task> tasks = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("____________________________________________________________");
//        System.out.println(" Hello! I'm Koji");
//        System.out.println(" What can I do for you?");
//        System.out.println("____________________________________________________________");
//
//        while (true) {
//            String input = sc.nextLine().trim();
//
//            if (input.equals("bye")) {
//                System.out.println("____________________________________________________________");
//                System.out.println(" Bye. Hope to see you again soon!");
//                System.out.println("____________________________________________________________");
//                break;
//            } else if (input.equals("list")) {
//                listTasks();
//            } else if (input.startsWith("mark ")) {
//                updateTaskStatus(input, true);
//            } else if (input.startsWith("unmark ")) {
//                updateTaskStatus(input, false);
//            } else if (input.startsWith("todo ")) {
//                addTask(new Todo(input.substring(5)));
//            } else if (input.startsWith("deadline ")) {
//                String[] parts = input.substring(9).split(" /by ", 2);
//                addTask(new Deadline(parts[0], parts[1]));
//            } else {
//                String[] parts = input.substring(6).split(" /from ", 2);
//                String[] times = parts[1].split(" /to ", 2);
//                addTask(new Event(parts[0], times[0], times[1]));
//
//            }
//        }
//        sc.close();
//    }
//
//    private static void addTask(Task task) {
//        tasks.add(task);
//        System.out.println("____________________________________________________________");
//        System.out.println(" Got it. I've added this task:");
//        System.out.println("   " + task);
//        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
//        System.out.println("____________________________________________________________");
//    }
//
//    private static void listTasks() {
//        System.out.println("____________________________________________________________");
//        System.out.println(" Here are the tasks in your list:");
//        if (tasks.isEmpty()) {
//            System.out.println("");
//        } else {
//            for (int i = 0; i < tasks.size(); i++) {
//                System.out.println(" " + (i + 1) + ". " + tasks.get(i).toString());
//            }
//        }
//        System.out.println("____________________________________________________________");
//    }
//
//    private static void updateTaskStatus(String input, boolean markAsDone) {
//            int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
//            if (markAsDone) {
//                tasks.get(taskIndex).markAsDone();
//            } else {
//                tasks.get(taskIndex).markAsNotDone();
//            }
//            System.out.println("____________________________________________________________");
//            System.out.println(markAsDone
//                    ? " Nice! I've marked this task as done:"
//                    : " OK, I've marked this task as not done yet:");
//            System.out.println("   " + tasks.get(taskIndex));
//            System.out.println("____________________________________________________________");
//
//    }
//}
//
//abstract class Task {
//    protected String description;
//    protected boolean isDone;
//
//    public Task(String description) {
//        this.description = description;
//        this.isDone = false;
//    }
//
//    public String getStatusIcon() {
//        return (isDone ? "X" : " ");
//    }
//
//    public void markAsDone() {
//        isDone = true;
//    }
//
//    public void markAsNotDone() {
//        isDone = false;
//    }
//
//    @Override
//    public String toString() {
//        return "[" + getStatusIcon() + "] " + description;
//    }
//}
//
//class Deadline extends Task {
//
//    protected String by;
//
//    public Deadline(String description, String by) {
//        super(description);
//        this.by = by;
//    }
//
//    @Override
//    public String toString() {
//        return "[D]" + super.toString() + " (by: " + by + ")";
//    }
//}
//
//class Todo extends Task {
//    public Todo(String description) {
//        super(description);
//    }
//
//    @Override
//    public String toString() {
//        return "[T]" + super.toString();
//    }
//}
//
//class Event extends Task {
//    protected String from;
//    protected String to;
//
//    public Event(String description, String from, String to) {
//        super(description);
//        this.from = from;
//        this.to = to;
//    }
//
//    @Override
//    public String toString() {
//        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
//    }
//}
//

public class Koji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList tasks = new TaskList();
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Koji");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
        while (true) {
            try {
                String input = sc.nextLine();
                if (input.equals("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("____________________________________________________________");
                    break;
                } else if (input.startsWith("todo")) {
                    addTodo(input, tasks);
                } else if (input.startsWith("deadline")) {
                    addDeadline(input, tasks);
                } else if (input.startsWith("event")) {
                    addEvent(input, tasks);
                } else if (input.equals("list")) {
                    tasks.printTasks();
                } else if (input.startsWith("delete")) {
                    deleteTask(input, tasks);
                } else {
                    throw new KojiException(" ? what saying");
                }
            } catch (KojiException e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
            }
        }

        sc.close();
    }

    private static void addTodo(String input, TaskList tasks) throws KojiException {
        if (input.trim().equals("todo")) {
            throw new KojiException(" todo WHAT?");
        }
        tasks.add(new Todo(input.substring(5).trim()));
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.getLastTask());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void addDeadline(String input, TaskList tasks) throws KojiException {
        if (!input.contains("/by")) {
            throw new KojiException(" what deadline bro");
        }
        String[] parts = input.substring(9).split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new KojiException(" when deadline??");
        }
        tasks.add(new Deadline(parts[0].trim(), parts[1].trim()));
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.getLastTask());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void addEvent(String input, TaskList tasks) throws KojiException {
        if (!input.contains("/from") || !input.contains("/to")) {
            throw new KojiException(" what event u doin");
        }
        String[] parts = input.substring(6).split(" /from | /to ", 3);
        if (parts.length < 3 || parts[0].trim().isEmpty()) {
            throw new KojiException(" when event??");
        }
        tasks.add(new Event(parts[0].trim(), parts[1].trim(), parts[2].trim()));
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.getLastTask());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void deleteTask(String input, TaskList tasks) throws KojiException {
        String[] parts = input.split(" ");

        try {
            int index = Integer.parseInt(parts[1]) - 1;
            Task removedTask = tasks.delete(index);
            System.out.println("____________________________________________________________");
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            System.out.println("____________________________________________________________");
        } catch (NumberFormatException e) {
            throw new KojiException("OOPS!!! Task number must be an integer.");
        }
    }
}


