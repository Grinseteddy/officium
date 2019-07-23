package com.annegret.officium.taskmanagement.entities;

import java.time.LocalDate;

public class TaskRequest {

    private String name;
    private String description;
    private String assignee;
    private LocalDate duedate;

    public TaskRequest() {

    }

    public TaskRequest(String name, String description, String assignee) {
        this.name=name;
        this.description=description;
        this.assignee=assignee;
    }

    public TaskRequest(String name, String description, String assignee, LocalDate duedate) {
        this.name=name;
        this.description=description;
        this.assignee=assignee;
        this.duedate=duedate;
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

    public LocalDate getDuedate() { return duedate;}

    public void setDuedate(LocalDate duedate) { this.duedate=duedate;}
}
