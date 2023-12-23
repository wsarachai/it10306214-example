package org.itsci.it10306103.lesson09.ex03;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Certification cer = new Certification("Java Certified",
          "Intermediate", new Date());
      Student student = new Student("Somchai", 22, "Information Technology", cer);

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
