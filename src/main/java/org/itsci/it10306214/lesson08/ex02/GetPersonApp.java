package org.itsci.it10306214.lesson08.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetPersonApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Person person = session.get(Person.class, 1L);
      System.out.println("Person's ID: " + person.getId());
      System.out.println("Person's Name: " + person.getPersonName());
      Passport passport = person.getPassport();
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
