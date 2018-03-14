package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUnique(Criteria criteria) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria cr = session.createCriteria(classType);
        results = getList(cr);
        return results;
    }

    public static <T> T find(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.eq("id", id));
        result = getUnique(cr);
        return result;
    }

    public static List<Student> findStudentByCourse(Course course) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = null ;
        Criteria cr = session.createCriteria(Student.class);
        cr.add(Restrictions.eq("course", course));
        results = getList(cr);
        return results;
    }

    public static List<Lesson> findLessonByCourse(Course course) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results = null ;
        Criteria cr = session.createCriteria(Lesson.class);
        cr.add(Restrictions.eq("course", course));
        results = getList(cr);
        return results;
    }

    public static List<Student> findStudentByLesson(Lesson lesson) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results = null ;
        Criteria cr = session.createCriteria(Student.class);
        cr.add(Restrictions.eq("lessons", lesson));
        results = getList(cr);
        return results;
    }

    public static List<Lesson> findLessonByStudent(Student student) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results = null ;
        Criteria cr = session.createCriteria(Lesson.class);
        cr.add(Restrictions.eq("students", student));
        results = getList(cr);
        return results;
    }

    public static void addLessonToStudent(Lesson lesson, Student student){
        student.addLesson(lesson);
        lesson.addStudent(student);
        save(student);
        save(lesson);
    }

}
