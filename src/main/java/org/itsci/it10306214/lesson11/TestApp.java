package org.itsci.it10306214.lesson11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Student student1 = new Student("Somchai Jaidee", 20, "Information Technology", 2.75);
      Student student2 = new Student("Somsri Jaipak", 22, "Computer Science", 3.25);
      Student student3 = new Student("Somrak Jaijing", 21, "Information Technology", 2.5);
      Student student4 = new Student("Sompong Jaimon", 25, "Computer Science", 3.12);
      session.save(student1);
      session.save(student2);
      session.save(student3);
      session.save(student4);

      Supplier supplier1 = new Supplier("Procor & Gamble", "USA");
      Supplier supplier2 = new Supplier("Unilever", "UK");
      Product product1 = new Product("Dove", "Shampoo", 112.0);
      Product product2 = new Product("Head & Shoulders", "Shampoo", 99.0);
      Product product3 = new Product("Pantene", "Shampoo", 120.0);
      Product product4 = new Product("Sunsilk", "Shampoo", 80.0);
      Product product5 = new Product("Lux", "Soap", 25.0);
      Product product6 = new Product("Lifebuoy", "Soap", 20.0);
      Product product7 = new Product("Dettol", "Soap", 30.0);
      Product product8 = new Product("Safeguard", "Soap", 35.0);
      Product product10 = new Product("Tide", "laundry detergent", 45.0);
      Product product11 = new Product("Ariel", "laundry detergent", 50.0);
      Product product12 = new Product("Downy", "fabric softener", 60.0);
      Product product13 = new Product("Bounce", "fabric softener", 55.0);
      Product product14 = new Product("Febreze", "fabric freshener", 70.0);

      supplier1.getProducts().add(product1);
      supplier1.getProducts().add(product2);
      supplier1.getProducts().add(product3);
      supplier1.getProducts().add(product4);
      supplier1.getProducts().add(product5);
      supplier1.getProducts().add(product6);
      supplier1.getProducts().add(product7);
      supplier2.getProducts().add(product8);
      supplier2.getProducts().add(product10);
      supplier2.getProducts().add(product11);
      supplier2.getProducts().add(product12);
      supplier2.getProducts().add(product13);
      supplier2.getProducts().add(product14);

      session.save(supplier1);
      session.save(supplier2);

      Doctor doctor1 = new Doctor("Dr. Sombat Jaidee", "General Practitioner");
      Doctor doctor2 = new Doctor("Dr. Somchai Jaipak", "Allergist");
      Doctor doctor3 = new Doctor("Dr. Somrak Jaijing", "Surgery");
      Patient patient1 = new Patient("Somsri Jaipak", "Stomachache");
      Patient patient2 = new Patient("Sompong Jaimon", "Headache");
      Patient patient3 = new Patient("Somchai Jaidee", "Heart attack");
      Patient patient4 = new Patient("Somrak Jaijing", "Broken leg");

      doctor1.getPatients().add(patient1);
      doctor1.getPatients().add(patient2);
      patient1.setDoctor(doctor1);
      patient2.setDoctor(doctor1);

      doctor2.getPatients().add(patient3);
      doctor2.getPatients().add(patient4);
      patient3.setDoctor(doctor2);
      patient4.setDoctor(doctor2);

      session.save(doctor1);
      session.save(doctor2);
      session.save(doctor3);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
