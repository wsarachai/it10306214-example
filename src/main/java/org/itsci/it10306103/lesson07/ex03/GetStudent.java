package org.itsci.it10306103.lesson07.ex03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GetStudent {
    public static void main(String[] args) {
        // Read hibernate.cfg.xml file
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("org/itsci/it10306103/lesson07/ex03/hibernate.cfg.xml")
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Student dbStudent1;
            Student dbStudent2;
            // Get
            dbStudent1 = session.get(Student.class, 1);
            System.out.println("Valid Student get called");
            System.out.println(dbStudent1);

            dbStudent2 = session.get(Student.class, 2);
            System.out.println("Invalid Student get called");
            System.out.println(dbStudent2);

            // Try to load object that does not exist from database
            dbStudent2 = session.get(Student.class, 20);
            System.out.println("Invalid Student get called");
            System.out.println(dbStudent2);

            // Load
            dbStudent1 = session.load(Student.class, 1);
            System.out.println("Valid Student get called");
            System.out.println(dbStudent1);

            // Try to load object that does not exist from memory
            dbStudent2 = session.load(Student.class, 20);
            System.out.println("Invalid Student get called");
            System.out.println(dbStudent2);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
