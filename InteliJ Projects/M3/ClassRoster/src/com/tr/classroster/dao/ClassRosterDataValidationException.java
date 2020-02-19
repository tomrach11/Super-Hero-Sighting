package com.tr.classroster.dao;

public class ClassRosterDataValidationException extends Exception {

    public ClassRosterDataValidationException(String message) {
        super(message);
    }
    public ClassRosterDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
