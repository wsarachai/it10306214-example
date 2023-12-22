package org.itsci.ex01;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateList {
  public static void main(String[] args) {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();
    SessionFactory sessionFactory = new MetadataSources(registry)
        .buildMetadata()
        .buildSessionFactory();

    Session session = sessionFactory.openSession();

    Query<Student> query = session.createQuery("from Student", Student.class);
    List<Student> students = query.getResultList();
    for (Student student : students) {
      System.out.println("Student (id=" + student.getId() + ") : " + student.getName());
    }
    sessionFactory.close();
  }
}
