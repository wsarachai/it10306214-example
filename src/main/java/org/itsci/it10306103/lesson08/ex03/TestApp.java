package org.itsci.it10306103.lesson08.ex03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        Product product = new Product("Polo", 1412.00);
        ProductDetail productDetail = new ProductDetail("1001", "Shirt", "Sahapat");
        product.setProductDetail(productDetail);

        try {
            session.beginTransaction();
            session.save(product);
            System.out.println("Product's ID: " + product.getId());
            System.out.println("Product's Name: " + product.getName());
            System.out.println("Product's Price: " + product.getPrice());
            productDetail = product.getProductDetail();
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
