package org.itsci.it10306214.lesson10.lab.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson10.lab.HibernateConnection;
import org.itsci.it10306214.lesson10.lab.models.Trans;

public class TransactionCtl {

    public Trans findTransactionById(int id) {
        Trans transaction = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            transaction = session.get(Trans.class, id);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return transaction;
    }
}
