package org.itsci.it10306214.lesson09.ex06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.DateUtils;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      TrainingCourseId id1 = new TrainingCourseId("DB 101", DateUtils.StringToDate("20-4-2023"));
      TrainingCourse course1 = new TrainingCourse(id1, "Relational Database",
          30,
          1500);

      TrainingCourseId id2 = new TrainingCourseId("Java 102", DateUtils.StringToDate("24-4-2023"));
      TrainingCourse course2 = new TrainingCourse(id2, "OO Programming", 40,
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
