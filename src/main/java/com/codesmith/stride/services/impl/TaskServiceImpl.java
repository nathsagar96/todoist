package com.codesmith.stride.services.impl;

import com.codesmith.stride.domain.entities.Task;
import com.codesmith.stride.domain.entities.TaskList;
import com.codesmith.stride.domain.entities.TaskPriority;
import com.codesmith.stride.domain.entities.TaskStatus;
import com.codesmith.stride.repositories.TaskListRepository;
import com.codesmith.stride.repositories.TaskRepository;
import com.codesmith.stride.services.TaskService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;
  private final TaskListRepository taskListRepository;

  public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
    this.taskRepository = taskRepository;
    this.taskListRepository = taskListRepository;
  }

  @Override
  public List<Task> listTasks(UUID taskListId) {
    return taskRepository.findByTaskListId(taskListId);
  }

  @Override
  public Task createTask(UUID taskListId, Task task) {

    if (task.getId() != null) {
      throw new IllegalArgumentException("Task already has an ID!");
    }

    TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);
    TaskStatus taskStatus = TaskStatus.OPEN;

    TaskList taskList =
        taskListRepository
            .findById(taskListId)
            .orElseThrow(() -> new IllegalArgumentException("Task List not found!"));

    Task taskToSave =
        new Task(
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            taskStatus,
            taskPriority,
            taskList);

    return taskRepository.save(taskToSave);
  }

  @Override
  public Optional<Task> getTask(UUID taskListId, UUID id) {
    return taskRepository.findByTaskListIdAndId(taskListId, id);
  }

  @Override
  public Task updateTask(UUID taskListId, UUID id, Task task) {
    if (task.getPriority() == null) {
      throw new IllegalArgumentException("Task must have a priority!");
    }

    if (task.getStatus() == null) {
      throw new IllegalArgumentException("Task must have a status!");
    }

    Task existingTask =
        taskRepository
            .findByTaskListIdAndId(taskListId, id)
            .orElseThrow(() -> new IllegalArgumentException("Task not found!"));

    existingTask.setTitle(task.getTitle());
    existingTask.setDescription(task.getDescription());
    existingTask.setDueDate(task.getDueDate());
    existingTask.setStatus(task.getStatus());
    existingTask.setPriority(task.getPriority());

    return taskRepository.save(existingTask);
  }

  @Override
  public void deleteTask(UUID taskListId, UUID id) {
    if (taskRepository.findByTaskListIdAndId(taskListId, id).isEmpty()) {
      throw new IllegalArgumentException("Task not found!");
    }

    taskRepository.deleteById(id);
  }
}
