package com.codesmith.stride.mappers;

import com.codesmith.stride.domain.dto.TaskDto;
import com.codesmith.stride.domain.entities.Task;

public interface TaskMapper {
  Task fromDto(TaskDto dto);

  TaskDto toDto(Task task);
}
