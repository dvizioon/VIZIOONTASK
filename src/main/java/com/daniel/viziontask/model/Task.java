package com.daniel.viziontask.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe que representa uma tarefa no sistema
 * @author Daniel Estevão
 */
public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private Priority priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public enum Priority {
        HIGH, MEDIUM, LOW
    }
    
    // Construtor
    public Task() {
        this.id = UUID.randomUUID().toString();
        this.completed = false;
        this.priority = Priority.MEDIUM;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public Task(String title, String description, LocalDate dueDate) {
        this();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }
    
    public Task(String title, String description, LocalDate dueDate, Priority priority) {
        this(title, description, dueDate);
        this.priority = priority;
    }
    
    // Getters e Setters
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
        this.updatedAt = LocalDateTime.now();
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    // Métodos de negócio
    public boolean isOverdue() {
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }
    
    public boolean isDueSoon() {
        return dueDate != null && 
               !LocalDate.now().isAfter(dueDate) && 
               LocalDate.now().plusDays(3).isAfter(dueDate);
    }
    
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }
}