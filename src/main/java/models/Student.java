package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {

    private int id;
    private String name;
    private int age;
    private int enrolment_number;
    private List<Course> courses;

    public Student() {
    }

    public Student(String name, int age, int enrolment_number) {
        this.name = name;
        this.age = age;
        this.enrolment_number = enrolment_number;
        this.courses = new ArrayList<Course>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEnrolment_number() {
        return enrolment_number;
    }

    public void setEnrolment_number(int enrolment_number) {
        this.enrolment_number = enrolment_number;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
