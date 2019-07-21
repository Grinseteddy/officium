package com.annegret.officium.taskmanagement.entities;

import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.UUID;

public class TaskResponse {

    private TaskEntity taskEntity;

    private ArrayList<Link> usefulLinks;

    private Message message;

    public TaskResponse() {

    }

    public TaskResponse(TaskEntity taskEntity) {
        this.taskEntity=taskEntity;
        this.usefulLinks=null;
        this.message=new Message("TASKCRATED", Message.severity.SUCCESS,
                "Task has been created "+taskEntity.getId(), UUID.randomUUID().toString());
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity=taskEntity;
    }

    public ArrayList<Link> getUsefulLinks() {
        return usefulLinks;
    }

    public void setUsefulLinks(ArrayList<Link> usefulLinks) {
        this.usefulLinks=usefulLinks;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message=message;
    }
}
