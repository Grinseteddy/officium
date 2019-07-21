package com.annegret.officium.taskmanagement.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class taskEntity {

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

    public taskEntity() {

    }

    public taskEntity(String name, String description, String assignee) {
        this.id= UUID.randomUUID().toString();
        this.name=name;
        this.description=description;
        this.assignee=assignee;
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
}
