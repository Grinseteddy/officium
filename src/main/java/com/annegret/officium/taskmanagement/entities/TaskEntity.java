package com.annegret.officium.taskmanagement.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class TaskEntity {

    @Id
    @Column(name="id")
    private String  id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="assignee")
    private String assignee;

    @Column(name="status")
    private String status;

    @Column(name="updatedby", nullable = false)
    private String updatedBy;

    @Column(name ="updatedat", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "createdby", nullable = false)
    private String createdBy;

    @Column(name = "createdat", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "thread")
    private String thread;

    @Column(name="duedate")
    private LocalDate duedate;

    @Column(name = "project")
    private String project;

    public TaskEntity() {

    }

    public TaskEntity(String name, String description, String assignee) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.description=description;
        this.assignee=assignee;

        //TODO get status model from project management
        this.status="NEW";

        //TODO get session user from somewhere
        this.updatedBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.updatedAt=LocalDateTime.now();

        this.createdAt=LocalDateTime.now();

        this.createdBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.thread=null;
    }

    public TaskEntity(String name, String description, String assignee, LocalDate duedate) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.description=description;
        this.assignee=assignee;

        //TODO get status model from project management
        this.status="NEW";

        //TODO get session user from somewhere
        this.updatedBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.updatedAt=LocalDateTime.now();

        this.createdAt=LocalDateTime.now();

        this.createdBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.thread=null;

        this.duedate=duedate;
    }

    public TaskEntity(String name, String description, String assignee, LocalDate duedate, String project) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.description=description;
        this.assignee=assignee;

        //TODO get status model from project management
        this.status="NEW";

        //TODO get session user from somewhere
        this.updatedBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.updatedAt=LocalDateTime.now();

        this.createdAt=LocalDateTime.now();

        this.createdBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.thread=null;

        this.duedate=duedate;

        this.project=project;
    }

    public TaskEntity(TaskRequest taskRequest) {
        this.id = UUID.randomUUID().toString();
        this.name=taskRequest.getName();
        this.description=taskRequest.getDescription();
        this.assignee=taskRequest.getAssignee();

        //TODO get status model from project management
        this.status="NEW";

        //TODO get session user from somewhere
        this.updatedBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.updatedAt=LocalDateTime.now();

        this.createdAt=LocalDateTime.now();

        this.createdBy="21a2bac3-a2c4-4e45-b6da-2248bb36b82e";

        this.thread=null;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updateBy) {
        this.updatedBy = updateBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread=thread;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project=project;
    }
}
