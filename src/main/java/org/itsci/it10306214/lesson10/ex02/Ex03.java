package org.itsci.it10306103.lesson10.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Ex03 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 1);
            Course course = session.get(Course.class, 1);
            System.out.println(student);
            System.out.println(course);

            session.clear();

            student.setMajor("CS");
            course.setCredit(2);

            session.update(student);
            session.merge(course);

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }
}
