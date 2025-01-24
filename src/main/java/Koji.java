import java.util.Scanner;

public class Koji {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        Scanner sc = new Scanner(System.in);
        String[] list = new String[100];
        int count = 0;

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
                System.out.println("____________________________________________________________");
                if (count == 0) {
                    System.out.println("");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + list[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else {
                list[count] = input;
                count++;
                System.out.println("____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println("____________________________________________________________");
            }
        }
        sc.close();
    }
}
