package org.itsci.it10306214.lab.lab07;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      String hql = "FROM Invoice";
      Query<Invoice> query = session.createQuery(hql, Invoice.class);
      List<Invoice> invoices = query.getResultList();
      for (Invoice invoice : invoices) {
        System.out.println(invoice.getVendor());
        System.out.println(invoice.getTerm());
        System.out.println("--------------------");
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
