package org.itsci.it10306214.lesson11.ex05;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Product;

public class Ex05App3 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
    Root<Product> root = criteria.from(Product.class);

    Predicate predicate = builder.ge(root.get("price").as(Double.class), 100.0);
    criteria.select(root);
    criteria.where(predicate);

    List<Product> results = session.createQuery(criteria).getResultList();
    for (Product product : results) {
      System.out.println(product);
    }

  }
}
