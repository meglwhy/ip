package koji;

import task.Task;
import task.TaskList;
import task.Event;

import java.util.Scanner;

public class Koji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskList tasks = new TaskList();
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm koji.Koji");
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
            throw new KojiException("OOPS!!! task.Task number must be an integer.");
        }
    }
}


