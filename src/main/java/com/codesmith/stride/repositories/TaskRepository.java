package com.codesmith.stride.repositories;

import com.codesmith.stride.domain.entities.Task;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

  List<Task> findByTaskListId(UUID taskListId);

  Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id);
}
