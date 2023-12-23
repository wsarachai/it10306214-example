package org.itsci.it10306103.lesson09.ex05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      TrainingCourse course1 = new TrainingCourse("DB 101", DateUtils.StringToDate("20-4-2023"), "Relational Database",
          30,
          1500);
      TrainingCourse course2 = new TrainingCourse("Java 102", DateUtils.StringToDate("24-4-2023"), "OO Programming", 40,
          2500);

      session.save(course1);
      session.save(course2);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
