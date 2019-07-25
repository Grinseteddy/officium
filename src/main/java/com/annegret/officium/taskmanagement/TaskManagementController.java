package com.annegret.officium.taskmanagement;

import com.annegret.officium.taskmanagement.entities.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    @PutMapping("tasks/{taskId}")
    public TaskResponse updateTaskById(@PathVariable String taskId, @RequestBody TaskRequest taskRequest) throws ResponseStatusException {
        try {
            if (taskId.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task ID can't be empty.");
            }
            TaskEntity taskEntity=taskRepository.findTaskEntitiesById(taskId);
            if (taskEntity==null) {
                Message message =new Message("NOTASKFOUND", Message.severity.WARNING, "Task "+ taskId+" couldn't be found", UUID.randomUUID().toString());
                return new TaskResponse(message);
            }
            Message message=new Message("TASKUPDATED", Message.severity.SUCCESS, taskEntity.getId(), UUID.randomUUID().toString());
            if (taskEntity.getName()==null && taskRequest.getName()!=null){
                message.setMessage(message.getMessage()+" name: -> "+taskRequest.getName());
                taskEntity.setName(taskRequest.getName());
            } else if (!taskEntity.getName().equals(taskRequest.getName())) {
                message.setMessage(message.getMessage()+" name: "+taskEntity.getName()+" -> "+taskRequest.getName());
                taskEntity.setName(taskRequest.getName());
            }
            if (taskEntity.getDescription()==null && taskRequest.getDescription()!=null) {
                message.setMessage(message.getMessage()+" description: -> "+taskRequest.getDescription());
                taskEntity.setName(taskRequest.getDescription());
            } else if (!taskEntity.getDescription().equals(taskRequest.getDescription())) {
                message.setMessage(message.getMessage()+";description: "+taskEntity.getDescription()+" -> "+taskRequest.getDescription());
                taskEntity.setDescription(taskRequest.getDescription());

            }
            if (taskEntity.getAssignee()==null && taskRequest.getAssignee()!=null) {
                message.setMessage(message.getMessage()+";assignee: -> "+taskRequest.getAssignee());
                taskEntity.setAssignee(taskRequest.getAssignee());
            } else if (!taskEntity.getAssignee().equals(taskRequest.getAssignee())) {
                message.setMessage(message.getMessage()+";assignee: "+taskEntity.getAssignee()+" -> "+taskRequest.getAssignee());
                taskEntity.setAssignee(taskRequest.getAssignee());
            }
            if (taskEntity.getDuedate()==null && taskRequest.getDuedate()!=null) {
                message.setMessage(message.getMessage() + ";duedate: -> " + taskRequest.getDuedate());
                taskEntity.setDuedate(taskRequest.getDuedate());
            } else if (!taskEntity.getDuedate().equals(taskRequest.getDuedate())) {
                message.setMessage(message.getMessage()+";duedate: "+taskEntity.getDuedate().toString()+" -> "+taskRequest.getDuedate().toString());
                taskEntity.setDuedate(taskRequest.getDuedate());
            }
            if (taskEntity.getProject()==null && taskRequest.getProject()!=null) {
                message.setMessage(message.getMessage() + ";project: -> "+taskRequest.getProject());
                taskEntity.setProject(taskRequest.getProject());
            } else if (!taskEntity.getProject().equals(taskRequest.getProject())) {
                message.setMessage(message.getMessage()+";project: "+taskEntity.getProject()+" -> "+taskRequest.getProject());
                taskEntity.setProject(taskRequest.getProject());
            }
            taskRepository.save(taskEntity);
            return new TaskResponse(taskEntity,message);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No suitable task found");
        }

    }

    @GetMapping("tasks/user/{userId}")
    @ResponseBody
    public ArrayList<TaskEntity> getTasksByUser(@PathVariable String userId) throws ResponseStatusException {
        try {
            if (userId==null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID is required");
            }
            ArrayList<TaskEntity> taskList = taskRepository.findTaskEntitiesByAssignee(userId);

            return taskList;


        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Assignee not found");

        }
    }

    @GetMapping("tasks/project/{projectId}")
    @ResponseBody
    public ArrayList<TaskEntity> getTasksByProject(@PathVariable String projectId) throws ResponseStatusException {
        try {
            if (projectId==null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project ID can't be empty.");
            }
            ArrayList<TaskEntity> tasksInProject = taskRepository.findTaskEntitiesByProject(projectId);
            return tasksInProject;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found");
        }
    }

}
