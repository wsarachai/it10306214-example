package org.itsci.it10306214.lesson10.lab.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson10.lab.HibernateConnection;
import org.itsci.it10306214.lesson10.lab.models.Employee;

public class EmployeeCtl {

    public Employee findEmployeeById(int id) {
        Employee employee = null;
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        return employee;
    }
}
