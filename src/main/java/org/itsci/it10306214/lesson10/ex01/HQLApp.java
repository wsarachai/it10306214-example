package org.itsci.it10306214.lesson10.ex01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HQLApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      String hql = "FROM Student";
      Query<Student> query = session.createQuery(hql, Student.class);
      List<Student> students = query.list();
      for (Student student : students) {
        System.out.println(student);
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
