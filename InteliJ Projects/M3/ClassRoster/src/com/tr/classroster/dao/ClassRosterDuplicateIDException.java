package com.tr.classroster.dao;

public class ClassRosterDuplicateIDException extends Exception {

    public ClassRosterDuplicateIDException(String message) {
        super(message);
    }

    public ClassRosterDuplicateIDException(String message, Throwable cause) {
        super(message, cause);
    }

}
