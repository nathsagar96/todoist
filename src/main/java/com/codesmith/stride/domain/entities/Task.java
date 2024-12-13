package com.codesmith.stride.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String title;
  private String description;
  private LocalDateTime dueDate;
  private TaskStatus status;
  private TaskPriority priority;

  @ManyToOne
  @JoinColumn(name = "task_list_id")
  private TaskList taskList;

  @CreationTimestamp private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;

  public Task() {}

  public Task(
      String title,
      String description,
      LocalDateTime dueDate,
      TaskStatus status,
      TaskPriority priority,
      TaskList taskList) {
    this.title = title;
    this.description = description;
    this.dueDate = dueDate;
    this.status = status;
    this.priority = priority;
    this.taskList = taskList;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public TaskPriority getPriority() {
    return priority;
  }

  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }

  public TaskList getTaskList() {
    return taskList;
  }

  public void setTaskList(TaskList taskList) {
    this.taskList = taskList;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(id, task.id)
        && Objects.equals(title, task.title)
        && Objects.equals(description, task.description)
        && Objects.equals(dueDate, task.dueDate)
        && status == task.status
        && priority == task.priority
        && Objects.equals(taskList, task.taskList)
        && Objects.equals(createdAt, task.createdAt)
        && Objects.equals(updatedAt, task.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, title, description, dueDate, status, priority, taskList, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "Task{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", description='"
        + description
        + '\''
        + ", dueDate="
        + dueDate
        + ", status="
        + status
        + ", priority="
        + priority
        + ", taskList="
        + taskList
        + ", created="
        + createdAt
        + ", updated="
        + updatedAt
        + '}';
  }
}
