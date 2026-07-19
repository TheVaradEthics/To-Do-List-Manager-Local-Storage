package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskCategory category;
    private TaskStatus status;
    private LocalDate dueDate;
    private LocalDate createdDate;

    public Task(String id, String title, String description, TaskPriority priority, TaskCategory category, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.status = TaskStatus.PENDING;
        this.dueDate = dueDate;
        this.createdDate = LocalDate.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public TaskPriority getPriority() { return priority; }
    public void setPriority(TaskPriority priority) { this.priority = priority; }
    public TaskCategory getCategory() { return category; }
    public void setCategory(TaskCategory category) { this.category = category; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return String.format("[%s] %s | Priority: %s | Category: %s | Status: %s | Due: %s", 
                id, title, priority, category, status, (dueDate != null ? dueDate : "None"));
    }
}