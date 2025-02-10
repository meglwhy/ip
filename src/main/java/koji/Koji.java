package koji;

import storage.Storage;
import task.Task;
import task.*;

import java.io.IOException;
import java.util.Scanner;

public class Koji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("./data/koji.txt");

        try {
            TaskList tasks = new TaskList(storage);
            System.out.println("____________________________________________________________");
            System.out.println(" Hello! I'm Koji.");
            System.out.println(" What can I do for you?");
            System.out.println("____________________________________________________________");

            while (true) {
                String input = sc.nextLine();
                if (input.equals("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Bye. Hope to see you again soon!");
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
                    throw new IOException(" ? what saying");
                }
            }
        } catch (IOException e) {
            System.out.println("____________________________________________________________");
            System.out.println(e.getMessage());
            System.out.println("____________________________________________________________");
        }

        sc.close();
    }

    private static void addTodo(String input, TaskList tasks) throws IOException {
        if (input.trim().equals("todo")) {
            throw new IOException(" todo WHAT?");
        }
        tasks.add(new Todo(input.substring(5).trim(), false));
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.getLastTask());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void addDeadline(String input, TaskList tasks) throws IOException {
        if (!input.contains("/by")) {
            throw new IOException(" deadline by...?");
        }
        String[] parts = input.substring(9).split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new IOException(" Deadline format should be deadline <desc> /by yyyy-MM-dd HHmm");
        }
        tasks.add(new Deadline(parts[0].trim(), parts[1].trim()));
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.getLastTask());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void addEvent(String input, TaskList tasks) throws IOException {
        if (!input.contains("/from") || !input.contains("/to")) {
            throw new IOException(" event from... to... ?");
        }
        String[] parts = input.substring(6).split(" /from | /to ", 3);
        if (parts.length < 3 || parts[0].trim().isEmpty()) {
            throw new IOException(" Event format should be event <desc> /from yyyy-MM-dd HHmm /to yyyy-MM-dd HHmm");
        }
        tasks.add(new Event(parts[0].trim(), parts[1].trim(), parts[2].trim()));
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + tasks.getLastTask());
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    private static void deleteTask(String input, TaskList tasks) throws IOException {
        String[] parts = input.split(" ");

        try {
            int index = Integer.parseInt(parts[1]) - 1;
            Task removedTask = tasks.delete(index);
            System.out.println("____________________________________________________________");
            System.out.println(" Noted. I've removed this task:");
            System.out.println("   " + removedTask);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            System.out.println("____________________________________________________________");
        } catch (NumberFormatException e) {
            throw new IOException(" Task number must be an integer!!");
        }
    }
}