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

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public TaskResponse addTask(@RequestBody TaskRequest taskRequest) throws Exception {
        try {

            TaskEntity taskEntity=new TaskEntity(taskRequest);
            
            taskRepository.save(taskEntity);
            return new TaskResponse(taskEntity);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task couldn't be created");
        }

    }

    @GetMapping("tasks/{name}")
    @ResponseBody
    public String getHealthStatus(@PathVariable String name) throws Exception {
        try {
            return "All things are fine "+name;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nothing known");
        }
    }

}
