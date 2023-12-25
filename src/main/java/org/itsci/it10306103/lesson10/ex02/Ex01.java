package org.itsci.it10306103.lesson10.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ex01 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 1);
            System.out.println(student);
            student.setGpa(3.00);
            // student.setGpa(3.75);

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }
}
