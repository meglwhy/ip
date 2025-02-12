package task;

import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private Storage storage;

    public TaskList(Storage storage) throws IOException {
        this.storage = storage;
        this.tasks = storage.load();
    }

    public void add(Task task) throws IOException {
        tasks.add(task);
        storage.save(tasks);
    }

    public int size() {
        return tasks.size();
    }

    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println(" Task list is empty");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public Task delete(int index) throws IOException {
        Task removed = tasks.remove(index);
        storage.save(tasks);
        return removed;
    }
}
