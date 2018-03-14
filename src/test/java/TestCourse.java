import db.DBHelper;
import models.Course;
import models.Student;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TestCourse {


    private Course course;
    private Student student;
    private List<Course> courses;

    @After
    public void tearDown(){
        DBHelper.delete(course);
        DBHelper.delete(student);
    }

    @Before
    public void before(){
        course= new Course("Programming", "PDA");
        courses = new ArrayList<Course>();
        student = new Student("Sara", 31, 97887);
        DBHelper.save(student);
        DBHelper.save(course);
    }

//    private String name;
//    private int age;
//    private int enrolment_number;
//    private Set<Course> courses;
}
//
//    private int id;
//    private String title;
//    private String level;
//    private Student student;
