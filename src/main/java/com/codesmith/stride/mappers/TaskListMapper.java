package com.codesmith.stride.mappers;

import com.codesmith.stride.domain.dto.TaskListDto;
import com.codesmith.stride.domain.entities.TaskList;

public interface TaskListMapper {
  TaskList fromDto(TaskListDto dto);

  TaskListDto toDto(TaskList taskList);
}
