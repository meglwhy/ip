package ui;

import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public void printWelcome() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Koji.");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    public void printGoodbye() {
        System.out.println(" Bye. Hope to see you again soon!");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String errorMessage) {
        System.out.println(" Error: " + errorMessage);
    }

    public String readCommand() {
        return sc.nextLine();
    }
}
