package org.itsci.it10306214.lesson10.lab;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.it10306214.lesson10.lab.controllers.CustomerCtl;
import org.itsci.it10306214.lesson10.lab.controllers.EmployeeCtl;
import org.itsci.it10306214.lesson10.lab.controllers.ProductCtl;
import org.itsci.it10306214.lesson10.lab.controllers.ShopCtl;
import org.itsci.it10306214.lesson10.lab.models.Customer;
import org.itsci.it10306214.lesson10.lab.models.Employee;
import org.itsci.it10306214.lesson10.lab.models.Product;
import org.itsci.it10306214.lesson10.lab.models.Shop;
import org.itsci.it10306214.lesson10.lab.models.Trans;
import org.itsci.it10306214.lesson10.lab.models.TransDetail;

public class PopulateDataApp {

    public static void populateCustomer() {

        Customer customer1 = new Customer();
        customer1.setMemberID("C001");
        customer1.setName("Napat Srisawat");
        customer1.setTel("081-1234567");
        customer1.setEmail("napat.srisawat@xxx.com");

        Customer customer2 = new Customer();
        customer2.setMemberID("C002");
        customer2.setName("Saranya Thongchai");
        customer2.setTel("081-2345678");
        customer2.setEmail("saranya.thongchai@yyy.com");

        Customer customer3 = new Customer();
        customer3.setMemberID("C003");
        customer3.setName("Tawan Chaiyapoom");
        customer3.setTel("081-3456789");
        customer3.setEmail("tawan.chaiyapoom@hhh.com");

        Customer customer4 = new Customer();
        customer4.setMemberID("C004");
        customer4.setName("Araya Wongthanakorn");
        customer4.setTel("081-4567890");
        customer4.setEmail("araya.wongthanakorn@iii.com");

        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(customer1);
            session.save(customer2);
            session.save(customer3);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public static void populateEmployee() {
        Employee employee1 = new Employee();
        employee1.setCode("E001");
        employee1.setName("Pongpat Tanarak");
        employee1.setTel("081-1234567");
        employee1.setEmail("pongpat.tanarak@abc.com");

        Employee employee2 = new Employee();
        employee2.setCode("E002");
        employee2.setName("Supansa Somboon");
        employee2.setTel("081-2345678");
        employee2.setEmail("supansa.somboon@abc.com");

        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(employee1);
            session.save(employee2);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public static void populateShop() {
        Shop shop1 = new Shop();
        shop1.setCode("S001");
        shop1.setName("7-Eleven");
        shop1.setAddress("123/456");
        shop1.setCity("Bangkok");
        shop1.setCountry("Thailand");

        Shop shop2 = new Shop();
        shop2.setCode("S002");
        shop2.setName("Family Mart");
        shop2.setAddress("456/789");
        shop2.setCity("Chiang Mai");
        shop2.setCountry("Thailand");

        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(shop1);
            session.save(shop2);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public static void populateProduct() {
        Product product1 = new Product();
        product1.setCode("P001");
        product1.setName("Coca Cola");
        product1.setPrice(15.0);
        product1.setType("Drink");

        Product product2 = new Product();
        product2.setCode("P002");
        product2.setName("Lay's");
        product2.setPrice(20.0);
        product2.setType("Snack");

        Product product3 = new Product();
        product3.setCode("P003");
        product3.setName("Oishi Green Tea");
        product3.setPrice(25.0);
        product3.setType("Drink");

        Product product4 = new Product();
        product4.setCode("P004");
        product4.setName("Oreo");
        product4.setPrice(30.0);
        product4.setType("Snack");

        Product product5 = new Product();
        product5.setCode("P005");
        product5.setName("Pepsi");
        product5.setPrice(15.0);
        product5.setType("Drink");

        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(product1);
            session.save(product2);
            session.save(product3);
            session.save(product4);
            session.save(product5);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }

    }

    public static void populateTransaction() {
        CustomerCtl customerCtl = new CustomerCtl();
        ShopCtl shopCtl = new ShopCtl();
        EmployeeCtl employeeCtl = new EmployeeCtl();
        ProductCtl productCtl = new ProductCtl();

        Trans transaction1 = new Trans();
        transaction1.setCode("T001");
        transaction1.setDate(new Date());
        transaction1.setCustomer(customerCtl.findCustomerById(1));
        transaction1.setShop(shopCtl.findShopById(1));
        transaction1.setEmployee(employeeCtl.findEmployeeById(1));

        Product product1 = productCtl.findProductById(1);
        Product product2 = productCtl.findProductById(2);
        Product product3 = productCtl.findProductById(3);

        TransDetail transactionDetail1 = new TransDetail();
        transactionDetail1.setTransaction(transaction1);
        transactionDetail1.setProduct(product1);
        transactionDetail1.setQuantity(5);
        transactionDetail1.setPrice(product1.getPrice());
        transactionDetail1.setTotal(transactionDetail1.getQuantity() * transactionDetail1.getPrice());

        TransDetail transactionDetail2 = new TransDetail();
        transactionDetail2.setTransaction(transaction1);
        transactionDetail2.setProduct(product2);
        transactionDetail2.setQuantity(3);
        transactionDetail2.setPrice(product2.getPrice());
        transactionDetail2.setTotal(transactionDetail2.getQuantity() * transactionDetail2.getPrice());

        TransDetail transactionDetail3 = new TransDetail();
        transactionDetail3.setTransaction(transaction1);
        transactionDetail3.setProduct(product3);
        transactionDetail3.setQuantity(2);
        transactionDetail3.setPrice(product3.getPrice());
        transactionDetail3.setTotal(transactionDetail3.getQuantity() * transactionDetail3.getPrice());

        transaction1.setSubtotal(
                transactionDetail1.getTotal() + transactionDetail2.getTotal() + transactionDetail3.getTotal());
        transaction1.setVat(transaction1.getSubtotal() * TestApp.tax);
        transaction1.setTotal(transaction1.getSubtotal() + transaction1.getVat());
        transaction1.setPaymentType("Cash");
        transaction1.setPaymentStatus("completed");

        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(transaction1);
            session.save(transactionDetail1);
            session.save(transactionDetail2);
            session.save(transactionDetail3);
            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public static void main(String[] args) {
        populateCustomer();
        populateEmployee();
        populateShop();
        populateProduct();
        populateTransaction();
    }
}
