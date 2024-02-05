package org.itsci.it10306214.lesson09.ex01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp2 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student = session.get(Student.class, 1);
      for (Course course : student.getCourses()) {
        System.out.println("Course ID: " + course.getId());
        System.out.println("Course Name: " + course.getName());
        System.out.println("Course Credit: " + course.getCredit());
      }

      student = session.get(Student.class, 2);
      for (Course course : student.getCourses()) {
        System.out.println("Course ID: " + course.getId());
        System.out.println("Course Name: " + course.getName());
        System.out.println("Course Credit: " + course.getCredit());
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
