package org.itsci.it10306214.lesson09.ex08;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student = new Student("Somsri Jaipak", 22, "IT");
      Course course1 = new Course("Java", 3);
      Course course2 = new Course("Uml", 3);
      session.save(course1);
      session.save(course2);
      session.save(student);

      Registration registration1 = new Registration();
      registration1.setStudent(student);
      registration1.setCourse(course1);
      registration1.setGrade("B+");
      Registration registration2 = new Registration();
      registration2.setStudent(student);
      registration2.setCourse(course2);
      registration2.setGrade("B");

      // Student register courses
      student.getRegistrations().add(registration1);
      student.getRegistrations().add(registration2);

      session.save(student);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
