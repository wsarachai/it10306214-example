package org.itsci.it10306214.lab.finalexam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class OrderCtl {

  public List<Order> findOrderByStatus(String status) {
    List<Order> orders = null;
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      String hql = "from Order where status = :status";
      Query<Order> query = session.createQuery(hql, Order.class);
      query.setParameter("status", status);

      orders = query.getResultList();
    } finally {
      session.close();
    }
    return orders;
  }

  public List<Order> findOrderByCustomerName(String customerName) {
    List<Order> orders = null;
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      String hql = "from Order where customer.name = :name";
      Query<Order> query = session.createQuery(hql, Order.class);
      query.setParameter("name", customerName);

      orders = query.getResultList();
    } finally {
      session.close();
    }
    return orders;
  }

  public Order findOrderById(int i) {
    Order order = null;
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      order = session.get(Order.class, i);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
    return order;
  }
}
