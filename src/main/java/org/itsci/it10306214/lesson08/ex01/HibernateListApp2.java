package org.itsci.it10306214.lesson08.ex01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HibernateListApp2 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    Query<Student> query = session.createQuery("from Student", Student.class);
    List<Student> students = query.getResultList();
    for (Student student : students) {
      System.out.println("Student (id=" + student.getId() + ") : " + student.getName());
    }
    sessionFactory.close();
  }
}
