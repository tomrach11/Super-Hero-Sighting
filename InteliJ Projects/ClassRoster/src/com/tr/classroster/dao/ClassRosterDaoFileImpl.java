package com.tr.classroster.dao;

import com.tr.classroster.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRosterDaoFileImpl implements ClassRosterDao{

    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student) {
        Student newStudent = students.put(studentId, student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) {
        Student removedStudent = students.remove(studentId);
        return removedStudent;
    }





}
