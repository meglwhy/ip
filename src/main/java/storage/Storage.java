package storage;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.io.*;

import java.util.ArrayList;

public class Storage {
    private File file;

    public Storage(String filePath) {
        this.file = new File(filePath);
        verifyFileExistence();
    }

    private void verifyFileExistence() {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating file");
        }
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                } else {
                    System.out.println("Skipped corrupted line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return tasks;
    }

    public void save(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private Task parseTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];

            switch (type) {
                case "T":
                    return new Todo(description, isDone);
                case "D":
                    return new Deadline(description, Task.parseDate(parts[3]).format(Task.INPUT_FORMAT), isDone);
                case "E":
                    return new Event(description,
                            Task.parseDate(parts[3]).format(Task.INPUT_FORMAT),
                            Task.parseDate(parts[4]).format(Task.INPUT_FORMAT),
                            isDone);
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
