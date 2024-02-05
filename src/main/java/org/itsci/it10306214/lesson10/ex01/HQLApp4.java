package org.itsci.it10306103.lesson10.ex01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HQLApp4 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      String hql = "SELECT stu.name FROM Student stu";
      Query<String> query = session.createQuery(hql, String.class);
      List<String> students = query.list();
      System.out.println("Student Details: ");
      for (String studentName : students) {
        System.out.println(studentName);
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
