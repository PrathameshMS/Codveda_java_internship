import java.util.*;
import java.io.*;

class Task {
    String description;

    Task(String description) {
        this.description = description;
    }
}

public class TodoManager {

    static List<Task> tasks = new ArrayList<>();
    static final String FILE_NAME = "tasks.txt";

    public static void loadTasks() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                tasks.add(new Task(reader.nextLine()));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error loading tasks.");
        }
    }

    public static void saveTasks() {
        try {
            PrintWriter writer = new PrintWriter(FILE_NAME);
            for (Task t : tasks) {
                writer.println(t.description);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving tasks.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        loadTasks();

        while (true) {

            System.out.println("\nTo Do List Manager");
            System.out.println("1 Add Task");
            System.out.println("2 View Tasks");
            System.out.println("3 Delete Task");
            System.out.println("4 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task description: ");
                    String desc = sc.nextLine();
                    tasks.add(new Task(desc));
                    saveTasks();
                    System.out.println("Task added.");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i).description);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to delete: ");
                    int index = sc.nextInt();
                    if (index > 0 && index <= tasks.size()) {
                        tasks.remove(index - 1);
                        saveTasks();
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
