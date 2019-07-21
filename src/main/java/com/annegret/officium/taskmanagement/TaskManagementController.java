package com.annegret.officium.taskmanagement;

import com.annegret.officium.taskmanagement.entities.TaskEntity;
import com.annegret.officium.taskmanagement.entities.TaskRepository;
import com.annegret.officium.taskmanagement.entities.TaskRequest;
import com.annegret.officium.taskmanagement.entities.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("tasks/{name}")
    @ResponseBody
    public String getHealthStatus(@PathVariable String name) throws ResponseStatusException {
        try {
            if (name.isEmpty() || name==null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can't be empty");
            }
            return "All things are fine "+name;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nothing known");
        }
    }

}
