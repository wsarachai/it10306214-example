package org.itsci.it10306214.lesson10.ex02;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      Student student = new Student("John Doe", 23, "IT", 3.75);
      session.save(student);
      System.out.println(student);

      Course course = new Course("Java", 3);
      session.save(course);
      System.out.println(course);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
