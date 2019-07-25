package com.annegret.officium.taskmanagement.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    public TaskEntity findTaskEntitiesById(String id);

    public ArrayList<TaskEntity> findTaskEntitiesByAssignee(String assignee);

    public ArrayList<TaskEntity> findTaskEntitiesByProject(String project);

}
