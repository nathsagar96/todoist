package com.codesmith.stride.repositories;

import com.codesmith.stride.domain.entities.TaskList;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {}
