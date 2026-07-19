package main;

import model.Task;
import model.TaskCategory;
import model.TaskPriority;
import model.TaskStatus;
import service.TaskService;
import utility.InputValidator;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static TaskService taskService = new TaskService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  Welcome to To-Do List Manager  ");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. View Overdue Tasks");
            System.out.println("6. Exit");

            int choice = InputValidator.getValidInteger(scanner, "Select an option: ", 1, 6);

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks(taskService.getAllTasks());
                    break;
                case 3:
                    changeTaskStatus(TaskStatus.COMPLETED);
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    viewTasks(taskService.getOverdueTasks());
                    break;
                case 6:
                    running = false;
                    System.out.println("Data saved automatically. Exiting application. Goodbye!");
                    break;
            }
        }
        scanner.close();
    }

    private static void addTask() {
        System.out.print("Enter Task Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Task Description: ");
        String description = scanner.nextLine();

        int prioChoice = InputValidator.getValidInteger(scanner, "Select Priority (1.LOW, 2.MEDIUM, 3.HIGH, 4.CRITICAL): ", 1, 4);
        TaskPriority priority = TaskPriority.values()[prioChoice - 1];

        int catChoice = InputValidator.getValidInteger(scanner, "Select Category (1.PERSONAL, 2.STUDY, 3.WORK, 4.HEALTH, 5.SHOPPING, 6.OTHER): ", 1, 6);
        TaskCategory category = TaskCategory.values()[catChoice - 1];

        LocalDate dueDate = InputValidator.getValidDate(scanner, "Enter Due Date");

        String id = taskService.generateId();
        Task newTask = new Task(id, title, description, priority, category, dueDate);
        taskService.addTask(newTask);
        System.out.println("Task added successfully! Task ID: " + id);
    }

    private static void viewTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\n--- Task List ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void changeTaskStatus(TaskStatus status) {
        System.out.print("Enter Task ID to update: ");
        String id = scanner.nextLine().toUpperCase();
        if (taskService.updateTaskStatus(id, status)) {
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        String id = scanner.nextLine().toUpperCase();
        if (taskService.deleteTask(id)) {
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task ID not found.");
        }
    }
}