package org.itsci.it10306214.lesson10.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EX06 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = new Student("John Doe", 23, "IT", 3.75);
            System.out.println(student);
            student.setId(1);
            student.setMajor("CS");
            // Student mergeStudent = (Student) session.merge(student);
            // System.out.println(mergeStudent);
            session.saveOrUpdate(student);

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

}
