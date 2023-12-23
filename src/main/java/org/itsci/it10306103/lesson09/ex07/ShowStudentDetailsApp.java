package org.itsci.it10306103.lesson09.ex07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ShowStudentDetailsApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      System.out.println("====================================");
      Student student = (Student) session.get(Student.class, 1);
      System.out.println("Student name: " + student.getName());
      System.out.println("Student age: " + student.getAge());
      System.out.println("Student major: " + student.getMajor());
      System.out.println("Student registered courses: ");
      for (Registration registration : student.getRegistrations()) {
        System.out.println("Course name: " + registration.getId().getCourse().getName());
        System.out.println("Course credit: " + registration.getId().getCourse().getCredit());
        System.out.println("Grade: " + registration.getGrade());
      }
      System.out.println("====================================");
      Course course = (Course) session.get(Course.class, 1);
      System.out.println("Course name: " + course.getName());
      System.out.println("Course credit: " + course.getCredit());
      System.out.println("Course registered students: ");
      for (Registration registration : course.getRegistrations()) {
        System.out.println("Student name: " + registration.getId().getStudent().getName());
        System.out.println("Student age: " + registration.getId().getStudent().getAge());
        System.out.println("Student major: " + registration.getId().getStudent().getMajor());
        System.out.println("Grade: " + registration.getGrade());
      }
      System.out.println("====================================");
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }

  }
}
