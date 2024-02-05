package org.itsci.it10306214.lesson09.ex02;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ListStudentApp {
  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student1 = session.get(Student.class, 1);
      System.out.println("Student's ID: " + student1.getId());
      System.out.println("Student's Name: " + student1.getName());
      System.out.println("Student's Age: " + student1.getAge());
      Set<Course> courses = student1.getCourses();
      for (Course course : courses) {
        System.out.println("  Course's ID: " + course.getId() + ", " + "Course's Name: " + course.getName());
      }
      Student student2 = session.get(Student.class, 2);
      System.out.println("Student's ID: " + student2.getId());
      System.out.println("Student's Name: " + student2.getName());
      System.out.println("Student's Age: " + student2.getAge());
      courses = student2.getCourses();
      for (Course course : courses) {
        System.out.println("  Course's ID: " + course.getId() + ", " + "Course's Name: " + course.getName());
      }
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
