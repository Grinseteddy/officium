package com.annegret.officium.taskmanagement.entities;

public class message {

    public enum severity {
        SUCCESS,
        WARNING,
        ERROR,
        CRITICALERROR
    }

    private String code;

    private severity severity;
}
