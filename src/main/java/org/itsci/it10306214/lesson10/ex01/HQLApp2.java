package org.itsci.it10306214.lesson10.ex01;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HQLApp2 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      SQLQuery query = session.createSQLQuery("select * from students");
      List<Object[]> students = query.list();

      for (Object[] row : students) {
        System.out.print("Student ID: " + row[0]);
        System.out.print(" Name: " + row[1]);
        System.out.print(" Major: " + row[2]);
        System.out.println(" and GPA: " + row[3]);
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
