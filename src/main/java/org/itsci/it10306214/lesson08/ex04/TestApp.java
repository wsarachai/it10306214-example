package org.itsci.it10306103.lesson08.ex04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Company company = new Company("ITSCI");
      Employee employee1 = new Employee("Somchai", 30);
      Employee employee2 = new Employee("Somsri", 25);
      company.getEmployees().add(employee1);
      company.getEmployees().add(employee2);
      session.save(company);
      System.out.println("Company's ID: " + company.getId());
      System.out.println("Company's Name: " + company.getName());

      for (Employee employee : company.getEmployees()) {
        System.out.println("Employee's ID: " + employee.getId());
        System.out.println("Employee's Name: " + employee.getName());
        System.out.println("Employee's Age: " + employee.getAge());
      }

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
