package com.codesmith.stride.services.impl;

import com.codesmith.stride.domain.entities.TaskList;
import com.codesmith.stride.repositories.TaskListRepository;
import com.codesmith.stride.services.TaskListService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TaskListServiceImpl implements TaskListService {

  private final TaskListRepository taskListRepository;

  public TaskListServiceImpl(TaskListRepository taskListRepository) {
    this.taskListRepository = taskListRepository;
  }

  @Override
  public List<TaskList> listTaskLists() {
    return taskListRepository.findAll();
  }

  @Override
  public TaskList createTaskList(TaskList taskList) {

    if (taskList.getId() != null) {
      throw new IllegalArgumentException("Task List already has an ID!");
    }

    return taskListRepository.save(
        new TaskList(taskList.getTitle(), taskList.getDescription(), null));
  }

  @Override
  public Optional<TaskList> getTaskList(UUID id) {
    return taskListRepository.findById(id);
  }

  @Override
  public TaskList updateTaskList(UUID id, TaskList taskList) {
    TaskList existingTaskList =
        taskListRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Task List not found!"));

    existingTaskList.setTitle(taskList.getTitle());
    existingTaskList.setDescription(taskList.getDescription());

    return taskListRepository.save(existingTaskList);
  }

  @Override
  public void deleteTaskList(UUID id) {

    if (!taskListRepository.existsById(id)) {
      throw new IllegalArgumentException("Task List not found!");
    }

    taskListRepository.deleteById(id);
  }
}
