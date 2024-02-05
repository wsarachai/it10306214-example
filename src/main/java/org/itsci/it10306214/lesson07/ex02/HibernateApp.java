package org.itsci.it10306214.lesson07.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateApp {
  public static void main(String[] args) {
    // Read hibernate.cfg.xml file
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("org/itsci/it10306103/lesson07/ex02/hibernate.cfg.xml")
        .build();
    SessionFactory sessionFactory = new MetadataSources(registry)
        .buildMetadata()
        .buildSessionFactory();

    // create session
    Session session = sessionFactory.openSession();

    Student stu1 = new Student();
    stu1.setName("Somchai");
    stu1.setAge(20);
    Student stu2 = new Student();
    stu2.setName("Somsri");
    stu2.setAge(21);

    try {
      session.beginTransaction();
      session.saveOrUpdate(stu1);
      session.saveOrUpdate(stu2);
      session.getTransaction().commit();

    } catch (Exception e) {
      session.getTransaction().rollback();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
