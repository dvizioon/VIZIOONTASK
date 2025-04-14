package com.daniel.viziontask.service;

import com.daniel.viziontask.model.Task;
import com.daniel.viziontask.repository.TaskRepository;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe de serviço para manipulação de tarefas
 * @author User
 */
public class TaskService {
    private final TaskRepository taskRepository;
    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public Task createTask(String title, String description, LocalDate dueDate, Task.Priority priority) {
        Task task = new Task(title, description, dueDate, priority);
        return taskRepository.save(task);
    }
    
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    
    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }
    
    public Task findTaskById(String taskId) {
        return taskRepository.findById(taskId);
    }
    
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    
    public List<Task> findCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }
    
    public List<Task> findIncompleteTasks() {
        return taskRepository.findByCompleted(false);
    }
    
    public List<Task> findOverdueTasks() {
        return taskRepository.findOverdueTasks();
    }
    
    public List<Task> findTasksDueSoon() {
        return taskRepository.findTasksDueSoon();
    }
    
    public void markTaskAsCompleted(String taskId) {
        Task task = taskRepository.findById(taskId);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
    }
    
    public void markTaskAsIncomplete(String taskId) {
        Task task = taskRepository.findById(taskId);
        if (task != null) {
            task.setCompleted(false);
            taskRepository.save(task);
        }
    }
}