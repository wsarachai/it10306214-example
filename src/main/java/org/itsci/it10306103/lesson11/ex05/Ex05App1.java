package org.itsci.it10306103.lesson11.ex05;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306103.lesson11.HibernateConnection;
import org.itsci.it10306103.lesson11.Supplier;

public class Ex05App1 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Supplier> criteria = builder.createQuery(Supplier.class);
    Root<Supplier> root = criteria.from(Supplier.class);
    criteria.select(root);

    List<Supplier> results = session.createQuery(criteria).getResultList();

    for (Supplier obj : results) {
      System.out.println(obj);
    }

  }
}
