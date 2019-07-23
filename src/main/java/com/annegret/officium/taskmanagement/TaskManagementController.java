package com.annegret.officium.taskmanagement;

import com.annegret.officium.taskmanagement.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

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
            if (taskEntity==null) {
                Message message =new Message("NOTASKFOUND", Message.severity.WARNING, "Task "+ taskId+" couldn't be found", UUID.randomUUID().toString());
                return new TaskResponse(message);
            }
            return new TaskResponse(taskEntity);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No task found");
        }
    }

}
