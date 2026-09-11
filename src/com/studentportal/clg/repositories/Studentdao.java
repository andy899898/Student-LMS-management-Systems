package com.studentportal.clg.repositories;

import java.util.List;

import com.studentportal.clg.models.Student;

public interface Studentdao {

    

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudentByRoll_No(int rollno);

    Student getStudentByRollno(int rollno);

    List<Student> getAllStudents();
}


