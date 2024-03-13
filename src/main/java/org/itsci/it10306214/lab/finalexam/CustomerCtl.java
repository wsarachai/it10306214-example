package org.itsci.it10306214.lab.finalexam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerCtl {

  public void saveCustomer(Customer customer) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      session.saveOrUpdate(customer);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

  public Customer getCustomerByID(int id) {
    Customer customer = null;
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      customer = session.get(Customer.class, id);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
    return customer;
  }

  public List<Customer> getAllCustomers() {
    List<Customer> customers = null;
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      customers = session.createQuery("from Customer", Customer.class).getResultList();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
    return customers;
  }

  public void updateCustomer(Customer customer) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      session.saveOrUpdate(customer);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

  public void deleteCustomer(int id) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Customer customer = session.get(Customer.class, id);
      session.delete(customer);
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }

}
