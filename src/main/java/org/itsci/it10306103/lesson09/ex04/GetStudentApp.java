package org.itsci.it10306103.lesson09.ex04;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetStudentApp {
  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student = session.get(Student.class, 1);
      System.out.println("Student's ID: " + student.getId());
      System.out.println("Student's Name: " + student.getName());
      System.out.println("Student's Age: " + student.getAge());
      System.out.println("Student's Major: " + student.getMajor());
      Collection<Certification> certificates = student.getCertificates();
      for (Certification cer : certificates) {
        System.out.println("Student's Certification name: " + cer.getCerName());
        System.out.println("Student's Certification level: " + cer.getLevel());
        System.out.println("Student's Certification issue date: " + cer.getIssueDate());
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
