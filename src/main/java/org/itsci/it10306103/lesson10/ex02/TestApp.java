package org.itsci.it10306103.lesson10.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TestApp {

  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();
      // Student student = new Student("John Doe", 23, "IT", 3.75);
      // session.save(student);
      // student.setMajor("IT");

      // String hql = "from Student where name = 'John Doe'";
      // Query<Student> query = session.createQuery(hql, Student.class);
      // query.setMaxResults(1);
      // Student student = query.uniqueResult();
      // session.clear();
      // student.setMajor("CS");

      // String hql = "from Student where name = 'John Doe'";
      // Query<Student> query = session.createQuery(hql, Student.class);
      // query.setMaxResults(1);
      // Student student = query.uniqueResult();
      // session.evict(student);
      // student.setMajor("CS");

      // String hql = "from Student where name = 'John Doe'";
      // Query<Student> query = session.createQuery(hql, Student.class);
      // query.setMaxResults(1);
      // Student student = query.uniqueResult();
      // student.setMajor("CS");

      // String hql = "from Student where name = 'John Doe'";
      // Query<Student> query = session.createQuery(hql, Student.class);
      // query.setMaxResults(1);
      // Student student = query.uniqueResult();
      // session.delete(student);
      // student.setMajor("CS");

      String hql = "from Student where name = 'John Doe'";
      Query<Student> query = session.createQuery(hql, Student.class);
      query.setMaxResults(1);
      Student student = query.uniqueResult();
      session.clear();
      student.setMajor("IT");
      session.merge(student);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
  }
}
