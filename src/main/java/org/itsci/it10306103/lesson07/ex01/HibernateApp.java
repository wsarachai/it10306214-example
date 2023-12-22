package org.itsci.it10306103.lesson07.ex01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApp {
  public static void main(String[] args) {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();
    SessionFactory sessionFactory = new MetadataSources(registry)
        .buildMetadata()
        .buildSessionFactory();
    Session session = sessionFactory.openSession();

    Student stu1 = new Student();
    stu1.setName("Somchai");
    stu1.setAge(20);
    Student stu2 = new Student();
    stu2.setName("Somsri");
    stu2.setAge(21);

    try {
      session.beginTransaction();
      session.save(stu1);
      session.save(stu2);
      session.getTransaction().commit();

    } catch (Exception e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
