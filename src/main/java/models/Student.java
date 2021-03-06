package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {

    private int id;
    private String name;
    private int age;
    private int enrolment_number;
    private Course course;
    private List<Lesson> lessons;

    public Student() {
    }

    public Student(String name, int age, int enrolment_number, Course course) {
        this.name = name;
        this.age = age;
        this.enrolment_number = enrolment_number;
        this.course = course;
        this.lessons = new ArrayList<Lesson>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "enrolment_number")
    public int getEnrolment_number() {
        return enrolment_number;
    }

    public void setEnrolment_number(int enrolment_number) {
        this.enrolment_number = enrolment_number;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
}
