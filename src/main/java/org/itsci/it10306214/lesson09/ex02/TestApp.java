package org.itsci.it10306214.lesson09.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student1 = new Student("Somchai", 22, "Information Technology");
      Student student2 = new Student("Somsri", 23, "Computer Science");
      Course course1 = new Course("Java", 3);
      Course course2 = new Course("Uml", 3);

      student1.getCourses().add(course1);
      student1.getCourses().add(course2);
      student2.getCourses().add(course1);
      student2.getCourses().add(course2);

      course1.getStudents().add(student1);
      course1.getStudents().add(student2);
      course2.getStudents().add(student1);
      course2.getStudents().add(student2);

      session.save(student1);
      session.save(student2);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
