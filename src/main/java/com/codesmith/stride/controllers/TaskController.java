package com.codesmith.stride.controllers;

import com.codesmith.stride.domain.dto.TaskDto;
import com.codesmith.stride.mappers.TaskMapper;
import com.codesmith.stride.services.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/task-lists/{task_list_id}/tasks")
public class TaskController {

  private final TaskService taskService;
  private final TaskMapper taskMapper;

  public TaskController(TaskService taskService, TaskMapper taskMapper) {
    this.taskService = taskService;
    this.taskMapper = taskMapper;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<TaskDto> listTasks(@PathVariable("task_list_id") final UUID taskListId) {
    return taskService.listTasks(taskListId).stream().map(taskMapper::toDto).toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TaskDto createTask(
      @PathVariable("task_list_id") final UUID taskListId, @Valid @RequestBody TaskDto taskDto) {
    return taskMapper.toDto(taskService.createTask(taskListId, taskMapper.fromDto(taskDto)));
  }

  @GetMapping(path = "/{task_id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<TaskDto> getTask(
      @PathVariable("task_list_id") final UUID taskListId, @PathVariable("task_id") final UUID id) {
    return taskService.getTask(taskListId, id).map(taskMapper::toDto);
  }

  @PutMapping(path = "/{task_id}")
  @ResponseStatus(HttpStatus.OK)
  public TaskDto updateTask(
      @PathVariable("task_list_id") final UUID taskListId,
      @PathVariable("task_id") final UUID id,
      @Valid @RequestBody TaskDto taskDto) {
    return taskMapper.toDto(taskService.updateTask(taskListId, id, taskMapper.fromDto(taskDto)));
  }

  @DeleteMapping(path = "/{task_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTask(
      @PathVariable("task_list_id") final UUID taskListId, @PathVariable("task_id") final UUID id) {
    taskService.deleteTask(taskListId, id);
  }
}
