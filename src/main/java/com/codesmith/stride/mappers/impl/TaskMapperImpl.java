package com.codesmith.stride.mappers.impl;

import com.codesmith.stride.domain.dto.TaskDto;
import com.codesmith.stride.domain.entities.Task;
import com.codesmith.stride.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
  @Override
  public Task fromDto(TaskDto dto) {
    return new Task(
        dto.title(), dto.description(), dto.dueDate(), dto.status(), dto.priority(), null);
  }

  @Override
  public TaskDto toDto(Task task) {
    return new TaskDto(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getDueDate(),
        task.getStatus(),
        task.getPriority());
  }
}
