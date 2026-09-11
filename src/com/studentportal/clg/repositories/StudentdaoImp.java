package com.studentportal.clg.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentportal.clg.models.Student;

public class StudentdaoImp implements Studentdao {
    Connection connection;
    PreparedStatement preparedStatement;
    int rowCount;
    String query, user = "root", password = "root";
    String url = "jdbc:mysql://localhost:3306/studentcrud";
    boolean response;

    @Override
    public boolean addStudent(Student student) {
        try {
            response = false;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            query = "insert into student (name, courses, rollno)values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, student.name);
            preparedStatement.setString(2, student.courses);
            preparedStatement.setInt(3, student.rollno);

            rowCount = preparedStatement.executeUpdate();
            if (rowCount == 1)
                response = true;
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public boolean updateStudent(Student student) {

        String sql = "UPDATE student SET courses = ? WHERE university_no = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, student.university_no);
            

            int rowCount = ps.executeUpdate();

            ps.close();
            con.close();

            if (rowCount == 1) {
                return true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean deleteStudentByRoll_No(int rollno) {
        String sql = "DELETE FROM student WHERE rollno = ?";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, rollno);

            int rowCount = ps.executeUpdate();

            if (rowCount == 1) {
                con.close();
                return true;
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public Student getStudentByRollno(int rollno) {

        Student emp = null;
        Student student = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            query = "Select * from student where rollno = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rollno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                student = new Student();

                student.name = resultSet.getString("name");
                student.courses = resultSet.getString("courses");
                student.rollno = resultSet.getInt("rollno");

            }
        }
        // connection.close();

        catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        return student;

    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            query = "Select * from student";
            preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int serial_no = rs.getInt(1);
                String name = rs.getString(2);
                String courses = rs.getString(3);
                int rollno = rs.getInt(4);
                String fees = rs.getString(5);
                Student e = new Student(serial_no, name, courses, rollno);
                allStudents.add(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

}
