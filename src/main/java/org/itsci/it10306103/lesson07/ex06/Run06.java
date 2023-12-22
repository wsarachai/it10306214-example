package org.itsci.it10306103.lesson07.ex06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Run06 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      Company company = new Company("ITSCI");
      Employee employee1 = new Employee("Somchai", 30);
      Employee employee2 = new Employee("Somsri", 25);
      employee1.setCompany(company);
      employee2.setCompany(company);
      company.getEmployees().add(employee1);
      company.getEmployees().add(employee2);

      session.save(employee1);
      session.save(employee2);

      System.out.println("Company's ID: " + company.getId());
      System.out.println("Company's Name: " + company.getName());
      System.out.println("Employee's 1 ID: " + employee1.getId());
      System.out.println("Employee's 1 Name: " + employee1.getName());
      System.out.println("Employee's 1 Age: " + employee1.getAge());
      System.out.println("Employee's 2 ID: " + employee2.getId());
      System.out.println("Employee's 2 Name: " + employee2.getName());
      System.out.println("Employee's 2 Age: " + employee2.getAge());
      Company company1 = employee1.getCompany();
      Company company2 = employee2.getCompany();

      System.out.println("Company's 1 ID: " + company1.getId());
      System.out.println("Company's 2 ID: " + company2.getId());

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
