package org.itsci.it10306103.lesson11.ex05;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306103.lesson11.HibernateConnection;
import org.itsci.it10306103.lesson11.Product;

public class Ex05App5 {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();

    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
    Root<Product> root = criteria.from(Product.class);

    Expression<Double> exp1 = builder.max(root.get("price").as(Double.class));
    Expression<Double> exp2 = builder.min(root.get("price").as(Double.class));
    Expression<Double> exp3 = builder.avg(root.get("price").as(Double.class));
    Expression<Long> exp4 = builder.countDistinct(root.get("description"));

    criteria.multiselect(exp1, exp2, exp3, exp4);

    List<Tuple> results = session.createQuery(criteria).getResultList();
    for (Tuple tuple : results) {
      Number max = tuple.get(exp1); // Number is the superclass of Double
      Number min = tuple.get(exp2); // Number is the superclass of Double
      Double avg = tuple.get(exp3);
      Long cdist = tuple.get(exp4);
      System.out.println("Max: " + max + ", Min: " + min + ", Avg: " + avg + ", Count Distinct: " + cdist);
    }

  }
}
