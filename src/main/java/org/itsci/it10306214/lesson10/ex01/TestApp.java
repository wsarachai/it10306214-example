package org.itsci.it10306103.lesson10.ex01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student1 = new Student("Somchai Jaidee", 22, "Information Technology", 2.75);
      Student student2 = new Student("Somsri Jaipak", 22, "Computer Science", 3.25);
      Student student3 = new Student("Somrak Jaijing", 22, "Information Technology", 2.5);
      Student student4 = new Student("Sompong Jaimon", 22, "Computer Science", 3.12);
      session.save(student1);
      session.save(student2);
      session.save(student3);
      session.save(student4);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
