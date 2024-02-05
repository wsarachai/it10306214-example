package org.itsci.it10306214.lesson09.ex02;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ListStudentApp2 {
  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Course course1 = session.get(Course.class, 1);
      System.out.println("Course's ID: " + course1.getId());
      System.out.println("Course's Name: " + course1.getName());
      System.out.println("Course's Credit: " + course1.getCredit());
      Set<Student> students = course1.getStudents();
      for (Student student : students) {
        System.out.println("  Student's ID: " + student.getId() + ", " + "Student's Name: " + student.getName());
      }
      Course course2 = session.get(Course.class, 2);
      System.out.println("Course's ID: " + course2.getId());
      System.out.println("Course's Name: " + course2.getName());
      System.out.println("Course's Credit: " + course2.getCredit());
      students = course2.getStudents();
      for (Student student : students) {
        System.out.println("  Student's ID: " + student.getId() + ", " + "Student's Name: " + student.getName());
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
