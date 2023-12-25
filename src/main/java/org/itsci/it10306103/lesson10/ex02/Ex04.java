package org.itsci.it10306103.lesson10.ex02;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Ex04 {

    public static void populateStudent(SessionFactory sessionFactory, List<Integer> ids) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student1 = new Student("Student1", 23, "IT", 3.75);
            Student student2 = new Student("Student2", 23, "CS", 3.00);
            int student1Id = (int) session.save(student1);
            int student2Id = (int) session.save(student2);

            ids.add(student1Id);
            ids.add(student2Id);

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();

        List<Integer> ids = new ArrayList<>();
        populateStudent(sessionFactory, ids);

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, ids.get(0));
            if (student != null) {
                System.out.println(student);
                session.delete(student);
                System.out.printf("Student %d is deleted\n", ids.get(0));
            }

            Student student2 = new Student();
            student2.setId(ids.get(1));
            System.out.println(student2);
            // session.remove(student2);
            session.delete(student2);
            System.out.printf("Student %d is deleted\n", ids.get(1));

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }
}
