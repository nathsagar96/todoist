package com.codesmith.stride.controllers;

import com.codesmith.stride.domain.dto.TaskListDto;
import com.codesmith.stride.mappers.TaskListMapper;
import com.codesmith.stride.services.TaskListService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {

  private final TaskListService taskListService;
  private final TaskListMapper taskListMapper;

  public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
    this.taskListService = taskListService;
    this.taskListMapper = taskListMapper;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<TaskListDto> listTaskLists() {
    return taskListService.listTaskLists().stream().map(taskListMapper::toDto).toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TaskListDto createTaskList(@Valid @RequestBody TaskListDto taskListDto) {
    return taskListMapper.toDto(
        taskListService.createTaskList(taskListMapper.fromDto(taskListDto)));
  }

  @GetMapping(path = "/{task_list_id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") final UUID id) {
    return taskListService.getTaskList(id).map(taskListMapper::toDto);
  }

  @PutMapping(path = "/{task_list_id}")
  @ResponseStatus(HttpStatus.OK)
  public TaskListDto updateTaskList(
      @PathVariable("task_list_id") final UUID id, @Valid @RequestBody TaskListDto taskListDto) {
    return taskListMapper.toDto(
        taskListService.updateTaskList(id, taskListMapper.fromDto(taskListDto)));
  }

  @DeleteMapping(path = "/{task_list_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTaskList(@PathVariable("task_list_id") final UUID id) {
    taskListService.deleteTaskList(id);
  }
}
