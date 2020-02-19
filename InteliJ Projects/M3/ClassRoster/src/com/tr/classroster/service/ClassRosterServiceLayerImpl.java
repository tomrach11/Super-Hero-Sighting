package com.tr.classroster.service;

import com.tr.classroster.dao.*;
import com.tr.classroster.dto.Student;

import java.util.List;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterPersistenceException, ClassRosterDuplicateIDException, ClassRosterDataValidationException {
        if (dao.getStudent(student.getStudentID()) != null) {
            throw new ClassRosterDuplicateIDException("ERROR: Could not create student. Student ID " + student.getStudentID() + " already exists.");
        }
        validateStudentData(student);

        dao.addStudent(student.getStudentID(),student);

        auditDao.writeAuditEntry("Student " + student.getStudentID() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudent() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentID) throws ClassRosterPersistenceException {
        return dao.getStudent(studentID);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + removedStudent.getStudentID() + " REMOVED.");
        return removedStudent;
    }

    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
            || student.getFirstName().trim().length() == 0
            || student.getLastName() == null
            || student.getLastName().trim().length() == 0
            || student.getCohort() == null
            || student.getCohort().trim().length() == 0) {
            throw new ClassRosterDataValidationException("ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
