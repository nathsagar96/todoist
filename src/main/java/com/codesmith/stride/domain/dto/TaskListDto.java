package com.codesmith.stride.domain.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

public record TaskListDto(
    UUID id,
    @NotBlank(message = "Task list must have a title!") String title,
    String description,
    Integer count,
    Double progress,
    List<TaskDto> tasks) {}
