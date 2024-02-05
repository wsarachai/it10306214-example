package org.itsci.it10306103.lesson09.ex05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306103.DateUtils;

public class GetTrainingCourse {
  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      TrainingCourseId id1 = new TrainingCourseId("DB 101", DateUtils.StringToDate("20-4-2023"));
      TrainingCourse course = session.get(TrainingCourse.class, id1);
      System.out.println(course.getCourseName());
      System.out.println(course.getCapacity());
      System.out.println(course.getFee());

      TrainingCourseId id2 = new TrainingCourseId("Java 102", DateUtils.StringToDate("24-4-2023"));
      TrainingCourse course2 = session.get(TrainingCourse.class, id2);
      System.out.println(course2.getCourseName());
      System.out.println(course2.getCapacity());
      System.out.println(course2.getFee());

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
