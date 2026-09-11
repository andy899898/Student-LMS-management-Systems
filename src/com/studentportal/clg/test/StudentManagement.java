package com.studentportal.clg.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.studentportal.clg.models.Student;
import com.studentportal.clg.repositories.Studentdao;
import com.studentportal.clg.repositories.StudentdaoImp;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Studentdao dao = new StudentdaoImp();
        while (true) {
            System.out.println("====== Student LMS Management System ======");
            System.out.println("1.Add Student");
            System.out.println("2.Change Course  \n3.Delete Student ");
            System.out.println("4.Search Student by rollno \n5. Display all Student \n6.Exit");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert
                    System.out.println("plz enter name,courses and rollno ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    String courses = sc.next();
                    int rollno = sc.nextInt();
                    Student e = new Student(name, courses, rollno);
                    System.out.println(e);
                    boolean response = dao.addStudent(e);
                    if (response)
                        System.out.println("student added succesfully");
                    else
                        System.err.println("Sorrry!! student is not added");
                    break;

                case 2: // update by university_no
                    System.out.println("Please enter university no and which course you want ");
                    int university_no = sc.nextInt();
                    String course = sc.next();
                    
                    Student f = new Student(university_no, course);
                    System.out.println(f);
                    boolean response_1 = dao.updateStudent(f);
                    if (response_1)
                        System.out.println("student details updated succesfully");
                    else
                        System.err.println("Sorrry!! student detail is not updated");
                    break;

                case 3: // delete by rollno

                    System.out.print("Enter Student Rollno: ");
                    int deleteId = sc.nextInt();

                    boolean response1 = dao.deleteStudentByRoll_No(deleteId);

                    if (response1) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Sorry!! This Student rollno does not exist.");
                    }
                    break;

                case 4: // get by rollno
                    System.out.print("Enter Student rollno to search: ");
                    int searchId = sc.nextInt();

                    Student searchStudent = dao.getStudentByRollno(searchId);

                    if (searchStudent != null) {
                        System.out.println(searchStudent);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5: // display all
                    List<Student> allEmployees = dao.getAllStudents();
                    Iterator<Student> itr = allEmployees.iterator();
                    while (itr.hasNext()) {
                        System.out.println(itr.next());
                    }
                    break;

                case 6: // exit
                    System.out.println("Thank you for Using Student LMS Management System");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter the valid choice: ");
            }
        }
    }
}
