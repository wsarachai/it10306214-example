package org.itsci.it10306214.lesson11.ex05;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Supplier;

public class Ex05App2 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Supplier> criteria = builder.createQuery(Supplier.class);
    Root<Supplier> root = criteria.from(Supplier.class);

    Predicate predicate = builder.like(root.get("name").as(String.class), "%Gamble%");
    criteria.select(root);
    criteria.where(predicate);

    Supplier result = session.createQuery(criteria).uniqueResult();
    System.out.println(result);

  }

}
