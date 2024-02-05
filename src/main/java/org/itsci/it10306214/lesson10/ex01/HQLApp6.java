package org.itsci.it10306103.lesson10.ex01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HQLApp6 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    try {
      session.beginTransaction();

      String hql = "from Student where gpa > 2.5";
      Query<Student> query = session.createQuery(hql, Student.class);
      query.setMaxResults(1);
      Student student = query.uniqueResult();
      System.out.println(student);

      // Query<Double> query = session.createQuery("select sum(gpa) from Student",
      // Double.class);
      // double sumGpa = query.uniqueResult();
      // System.out.println("Sum of all GPA= " + sumGpa);

      // Query<Double> query = session.createQuery("select sum(gpa) from Student",
      // Double.class);
      // List<Double> sumGpa = query.getResultList();
      // System.out.println("Sum of all GPA= " + sumGpa);

      // Query<Double> query = session.createQuery("select avg(gpa) from Student",
      // Double.class);
      // double avgGpa = query.uniqueResult();
      // System.out.println("Average GPA = " + avgGpa);

      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }

  }
}
