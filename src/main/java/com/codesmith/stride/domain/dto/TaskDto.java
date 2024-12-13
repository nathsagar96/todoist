package com.codesmith.stride.domain.dto;

import com.codesmith.stride.domain.entities.TaskPriority;
import com.codesmith.stride.domain.entities.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
    UUID id,
    @NotBlank(message = "Task must have a title!") String title,
    String description,
    LocalDateTime dueDate,
    TaskStatus status,
    TaskPriority priority) {}
