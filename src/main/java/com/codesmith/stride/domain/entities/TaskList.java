package com.codesmith.stride.domain.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "task_lists")
public class TaskList {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String title;
  private String description;

  @OneToMany(
      mappedBy = "taskList",
      cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
  private List<Task> tasks;

  @CreationTimestamp private LocalDateTime created;

  @UpdateTimestamp private LocalDateTime updated;

  public TaskList() {}

  public TaskList(String title, String description, List<Task> tasks) {
    this.title = title;
    this.description = description;
    this.tasks = tasks;
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

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    TaskList taskList = (TaskList) o;
    return Objects.equals(id, taskList.id)
        && Objects.equals(title, taskList.title)
        && Objects.equals(description, taskList.description)
        && Objects.equals(tasks, taskList.tasks)
        && Objects.equals(created, taskList.created)
        && Objects.equals(updated, taskList.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, tasks, created, updated);
  }

  @Override
  public String toString() {
    return "TaskList{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", description='"
        + description
        + '\''
        + ", tasks="
        + tasks
        + ", created="
        + created
        + ", updated="
        + updated
        + '}';
  }
}
