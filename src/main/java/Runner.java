import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Programming", "PDA");
        DBHelper.save(course1);
        Student student1 = new Student("Jimmy", 18, 56787, course1);
        DBHelper.save(student1);
        Student student2 = new Student("Yijim", 19, 76587, course1);
        DBHelper.save(student2);
        Lesson lesson1 = new Lesson("Variables", 31, course1);
        DBHelper.save(lesson1);

        DBHelper.addLessonToStudent(lesson1, student2);
        course1.addLesson(lesson1);
        course1.addStudent(student2);

        DBHelper.delete(student1);

        student2.setName("Gus");
        DBHelper.save(student2);


        List<Student> students = DBHelper.getAll(Student.class);

        List<Course> courses = DBHelper.getAll(Course.class);

        Student student = DBHelper.find(Student.class, student1.getId());

        Course course = DBHelper.find(Course.class, course1.getId());


        List<Lesson> foundLessonByStudent = DBHelper.findLessonByStudent(student2);

        List<Student> foundStudentByCourse = DBHelper.findStudentByCourse(course1);

        List<Lesson> foundLessonByCourse = DBHelper.findLessonByCourse(course1);

        Lesson lesson2 = new Lesson("Polymorphs", 666, course1);
        lesson2.addStudent(student2);

        List<Student> foundStudentByLesson = DBHelper.findStudentByLesson(lesson2);
    }
}
