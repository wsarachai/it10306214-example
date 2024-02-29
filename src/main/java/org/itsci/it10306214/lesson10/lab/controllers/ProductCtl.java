package org.itsci.it10306214.lesson10.lab.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson10.lab.HibernateConnection;
import org.itsci.it10306214.lesson10.lab.models.Product;

public class ProductCtl {

    public Product findProductById(int id) {
        Product product = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return product;
    }
}
