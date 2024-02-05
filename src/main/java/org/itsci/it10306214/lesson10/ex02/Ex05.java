package org.itsci.it10306214.lesson10.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Ex05 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = new Student("John Doe5", 23, "IT", 3.75);
            int id1 = (int) session.save(student);
            System.out.println("id1 = " + id1);
            System.out.println(student);
            // session.evict(student);
            int id2 = (int) session.save(student);
            System.out.println("id2 = " + id2);
            System.out.println(student);

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

}
