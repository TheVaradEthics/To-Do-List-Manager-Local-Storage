package service;

import model.Task;
import model.TaskStatus;
import repository.FileTaskRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskService {
    private List<Task> tasks;
    private FileTaskRepository repository;

    public TaskService() {
        repository = new FileTaskRepository();
        tasks = repository.loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        repository.saveTasks(tasks);
    }

    public String generateId() {
        return UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(String id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean updateTaskStatus(String id, TaskStatus status) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setStatus(status);
            repository.saveTasks(tasks);
            return true;
        }
        return false;
    }

    public boolean deleteTask(String id) {
        boolean removed = tasks.removeIf(t -> t.getId().equals(id));
        if (removed) repository.saveTasks(tasks);
        return removed;
    }

    public List<Task> getOverdueTasks() {
        LocalDate today = LocalDate.now();
        return tasks.stream()
                .filter(t -> t.getDueDate() != null && t.getDueDate().isBefore(today) && t.getStatus() != TaskStatus.COMPLETED)
                .collect(Collectors.toList());
    }
}