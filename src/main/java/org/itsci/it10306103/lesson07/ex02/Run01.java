package org.itsci.it10306103.lesson07.ex02;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Run01 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = new Person("Somchai Jaidee", 'M', new Date());
        Passport passport = new Passport("1357473", new Date(), "Chiangmai", "Thailand");
        person.setPassport(passport);
        System.out.println("Person's ID [not a persistent object]: " + person.getId());
        try {
            session.beginTransaction();
            session.save(person);
            System.out.println("Person's ID: " + person.getId());
            System.out.println("Person's Name: " + person.getPersonName());
            passport = person.getPassport();
            System.out.println("Passport's ID: " + passport.getId());
            System.out.println("Passport's Number: " + passport.getPassport_no());
            System.out.println("Country: " + passport.getCountry());
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
        sessionFactory.close();
    }
}
