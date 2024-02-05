package org.itsci.it10306214.lesson11.ex05;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson11.HibernateConnection;
import org.itsci.it10306214.lesson11.Product;

public class Ex05App6 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
    Root<Product> root = criteria.from(Product.class);

    Path<String> productName = root.get("name");
    Path<String> productDesc = root.get("description");

    criteria.multiselect(productName, productDesc);

    List<Tuple> results = session.createQuery(criteria).getResultList();
    for (Tuple tuple : results) {
      String pname = tuple.get(productName);
      String pdesc = tuple.get(productDesc);
      System.out.println("" + pname + ", " + pdesc);
    }

  }
}
