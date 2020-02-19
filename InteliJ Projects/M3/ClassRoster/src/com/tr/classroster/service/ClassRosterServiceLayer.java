package com.tr.classroster.service;

import com.tr.classroster.dao.ClassRosterDao;
import com.tr.classroster.dao.ClassRosterDataValidationException;
import com.tr.classroster.dao.ClassRosterDuplicateIDException;
import com.tr.classroster.dao.ClassRosterPersistenceException;
import com.tr.classroster.dto.Student;

import java.util.List;

public interface ClassRosterServiceLayer {

    void createStudent(Student student) throws ClassRosterPersistenceException, ClassRosterDuplicateIDException, ClassRosterDataValidationException;

    List<Student> getAllStudent() throws ClassRosterPersistenceException;

    Student getStudent(String studentID) throws ClassRosterPersistenceException;

    Student removeStudent (String studentId) throws ClassRosterPersistenceException;

}
