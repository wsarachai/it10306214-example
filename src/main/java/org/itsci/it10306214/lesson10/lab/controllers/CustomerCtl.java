package org.itsci.it10306214.lesson10.lab.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson10.lab.HibernateConnection;
import org.itsci.it10306214.lesson10.lab.models.Customer;

public class CustomerCtl {

    public Customer findCustomerById(int id) {
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

    public void saveCustomer(Customer customer) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public void updateCustomer(Customer customer) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public void deleteCustomer(Customer customer) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public void deleteCustomerById(int id) {
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

    public void deleteAllCustomer() {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Customer").executeUpdate();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public Customer findCustomerByName(String name) {
        Customer customer = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer WHERE name = :name")
                    .setParameter("name", name).uniqueResult();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return customer;
    }

    public Customer findCustomerByEmail(String email) {
        Customer customer = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer WHERE email = :email")
                    .setParameter("email", email).uniqueResult();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return customer;
    }

    public Customer findCustomerByTel(String tel) {
        Customer customer = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer WHERE tel = :tel")
                    .setParameter("tel", tel).uniqueResult();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return customer;
    }

    public Customer findCustomerByMemberID(String memberID) {
        Customer customer = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            customer = (Customer) session.createQuery("FROM Customer WHERE memberID = :memberID")
                    .setParameter("memberID", memberID).uniqueResult();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return customer;
    }

    public List<Customer> findAllCustomer() {
        List<Customer> customers = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            customers = session.createQuery("FROM Customer", Customer.class).list();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return customers;
    }

    public List<Customer> searchCustomerByName(String name) {
        List<Customer> customers = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            customers = session.createQuery("FROM Customer WHERE name LIKE :name", Customer.class)
                    .setParameter("name", "%" + name + "%").list();
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return customers;
    }
}
