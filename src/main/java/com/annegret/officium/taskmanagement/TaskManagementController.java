package com.annegret.officium.taskmanagement;

import com.annegret.officium.taskmanagement.entities.TaskEntity;
import com.annegret.officium.taskmanagement.entities.TaskRepository;
import com.annegret.officium.taskmanagement.entities.TaskRequest;
import com.annegret.officium.taskmanagement.entities.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TaskManagementController {

    private final TaskRepository taskRepository;

    public TaskManagementController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/tasks")
    public TaskResponse addTask(@RequestBody TaskRequest taskRequest) throws ResponseStatusException {
        try {

            if (taskRequest==null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task Request needs to be filled");
            }
            if (taskRequest.getName()==null || taskRequest.getName().isEmpty() ) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task name needs to be filled");
            }
            TaskEntity taskEntity=new TaskEntity(taskRequest);

            taskRepository.save(taskEntity);
            return new TaskResponse(taskEntity);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task couldn't be created");
        }

    }

    @GetMapping("tasks/{taskId}")
    @ResponseBody
    public TaskResponse getTaskById(@PathVariable String taskId) throws ResponseStatusException {
        try {
            if (taskId.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task ID required");
            }
            TaskEntity taskEntity=taskRepository.findTaskEntitiesById(taskId);
            return new TaskResponse(taskEntity);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No task found");
        }
    }

}
