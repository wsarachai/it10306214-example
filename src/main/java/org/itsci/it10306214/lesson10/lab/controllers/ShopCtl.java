package org.itsci.it10306214.lesson10.lab.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson10.lab.HibernateConnection;
import org.itsci.it10306214.lesson10.lab.models.Shop;

public class ShopCtl {

    public Shop findShopById(int id) {
        Shop shop = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            shop = session.get(Shop.class, id);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return shop;
    }
}
