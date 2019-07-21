package com.annegret.officium.taskmanagement;

import com.annegret.officium.taskmanagement.entities.taskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TaskManagementController {

    @Autowired
    private taskRepository taskRepository;

    @PostMapping
    @ResponseBody
    public

}
