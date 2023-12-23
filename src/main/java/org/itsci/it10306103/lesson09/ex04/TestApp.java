package org.itsci.it10306103.lesson09.ex04;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Certification cer1 = new Certification("Java Certified", "Intermediate", new Date());
      Certification cer2 = new Certification("Oracle Certified", "Beginner", new Date());
      Certification cer3 = new Certification("Test Certified", "Advanced", new Date());
      Student student = new Student("Somchai", 22, "Information Technology");
      student.getCertificates().add(cer1);
      student.getCertificates().add(cer2);
      student.getCertificates().add(cer3);

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
