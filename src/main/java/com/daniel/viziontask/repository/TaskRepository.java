package com.daniel.viziontask.repository;

import com.daniel.viziontask.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe responsável por armazenar e recuperar tarefas
 * @author User
 */
public class TaskRepository {
    private static final Map<String, Task> tasks = new HashMap<>();
    
    public Task save(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }
    
    public Task findById(String id) {
        return tasks.get(id);
    }
    
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }
    
    public List<Task> findByCompleted(boolean completed) {
        return tasks.values().stream()
                .filter(task -> task.isCompleted() == completed)
                .collect(Collectors.toList());
    }
    
    public void delete(Task task) {
        tasks.remove(task.getId());
    }
    
    public void deleteById(String id) {
        tasks.remove(id);
    }
    
    public List<Task> findOverdueTasks() {
        return tasks.values().stream()
                .filter(task -> !task.isCompleted() && task.isOverdue())
                .collect(Collectors.toList());
    }
    
    public List<Task> findTasksDueSoon() {
        return tasks.values().stream()
                .filter(task -> !task.isCompleted() && task.isDueSoon())
                .collect(Collectors.toList());
    }
}