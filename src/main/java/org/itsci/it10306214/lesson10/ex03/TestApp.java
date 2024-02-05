package org.itsci.it10306214.lesson10.ex03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      Company company1 = new Company("Indythaitester", "Chiang Mai", "053-123456");
      Employee employee1 = new Employee("Somchai Jaidee", 35000, "Programmer");
      Employee employee2 = new Employee("Somsri Jaipak", 55000, "Manager");

      company1.getEmployees().add(employee1);
      company1.getEmployees().add(employee2);
      employee1.setCompany(company1);
      employee2.setCompany(company1);

      Company company2 = new Company("Information Technology", "Chiang Mai", "053-654321");
      Employee employee3 = new Employee("Somrak Jaijing", 25000, "Programmer");
      Employee employee4 = new Employee("Somying Jaimon", 45000, "Manager");

      company2.getEmployees().add(employee3);
      company2.getEmployees().add(employee4);
      employee3.setCompany(company2);
      employee4.setCompany(company2);

      session.save(company1);
      session.save(company2);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
