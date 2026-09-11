package com.studentportal.clg.models;

public class Student {

    public int university_no;
    public String name;
    public String courses;
    public int rollno;
    

    public Student(String name,String courses,int rollno){
        this.name = name;
        this.courses = courses;
        this.rollno = rollno;
        
    }

    public Student(int university_no,String name,String courses, int rollno){
        this.university_no = university_no;
        this.name = name;
        this.courses= courses;
        this.rollno = rollno;
        

    }

    public Student() {
        //TODO Auto-generated constructor stub
    }

    public Student(int university_no2) {
        //TODO Auto-generated constructor stub
    }

    public Student(int university_no2, String course) {
        //TODO Auto-generated constructor stub
    }

    public String toString(){
        return "Employee {university_no =" +university_no +" name ="+ name +" courses ="+ courses + "rollno ="+ rollno + "]";
    }

}
