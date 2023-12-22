package org.itsci.it10306103.lesson08.ex03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetProduct {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    Session session = sessionFactory.openSession();
    try {
      session.beginTransaction();
      Product product = session.get(Product.class, 1);
      System.out.println("Product's ID: " + product.getId());
      System.out.println("Product's Name: " + product.getName());
      System.out.println("Product's Price: " + product.getPrice());
      ProductDetail productDetail = product.getProductDetail();
      System.out.println("Product Detail's ID: " + productDetail.getId());
      System.out.println("Product Detail's PartNumber: " + productDetail.getPartNumber());
      System.out.println("Product Detail's Description: " + productDetail.getDescription());
      System.out.println("Product Detail's Manufacturer: " + productDetail.getManufacturer());
      session.getTransaction().commit();
    } finally {
      if (session.getTransaction().isActive()) {
        session.getTransaction().rollback();
      }
      session.close();
    }
    sessionFactory.close();
  }
}
