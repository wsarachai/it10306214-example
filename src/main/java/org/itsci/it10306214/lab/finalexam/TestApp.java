package org.itsci.it10306214.lab.finalexam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestApp {

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void populateData() {
        Customer cus1 = new Customer("Sarah Johnson", "sarah.johnson@gmail.com", "(555) 123-4567",
                "123 Oak Street, Cityville, State 98765");
        Customer cus2 = new Customer("Michael Anderson", "michael.anderson@gmail.com", "(555) 987-6543",
                "456 Maple Avenue, Townsville, State 54321");
        Customer cus3 = new Customer("Emily Davis", "emily.davis@gmail.com", "(555) 567-8901",
                "789 Pine Road, Villagetown, State 12345");
        Customer cus4 = new Customer("Brian Smith", "brian.smit@gmail.com", "(555) 234-5678",
                "234 Cedar Lane, Boroughburg, State 67890");
        Customer cus5 = new Customer("Jessica Taylor", "jessia.taylor@gmail.com", "(555) 345-6789",
                "567 Birch Street, Hamletville, State 34567");

        List<Customer> customers = new ArrayList<Customer>();
        customers.add(cus1);
        customers.add(cus2);
        customers.add(cus3);
        customers.add(cus4);
        customers.add(cus5);

        Product prod1 = new Product("Smartwatch X1", 129.99, 150);
        Product prod2 = new Product("Wireless Headphones Pro", 79.99, 200);
        Product prod3 = new Product("Laptop UltraBook 2023", 999.99, 50);
        Product prod4 = new Product("Fitness Tracker 3.0", 49.99, 100);
        Product prod5 = new Product("HD Smart TV 55\"", 699.99, 30);

        List<Product> products = new ArrayList<Product>();
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);
        products.add(prod5);

        Order ord1 = new Order(parseDate("2023-02-15"), "Shipped", cus1);
        Order ord2 = new Order(parseDate("2023-03-02"), "Processing", cus2);
        Order ord3 = new Order(parseDate("2023-03-10"), "Delivered", cus3);
        Order ord4 = new Order(parseDate("2023-04-05"), "Shipped", cus4);
        Order ord5 = new Order(parseDate("2023-04-20"), "Pending", cus5);
        Order ord6 = new Order(parseDate("2023-05-12"), "Processing", cus1);
        Order ord7 = new Order(parseDate("2023-05-25"), "Delivered", cus2);
        Order ord8 = new Order(parseDate("2023-06-03"), "Shipped", cus3);
        Order ord9 = new Order(parseDate("2023-06-18"), "Pending", cus4);
        Order ord10 = new Order(parseDate("2023-07-01"), "Processing", cus5);
        Order ord11 = new Order(parseDate("2023-07-15"), "Shipped", cus1);
        Order ord12 = new Order(parseDate("2023-08-02"), "Delivered", cus2);

        List<Order> orders = new ArrayList<Order>();
        orders.add(ord1);
        orders.add(ord2);
        orders.add(ord3);
        orders.add(ord4);
        orders.add(ord5);
        orders.add(ord6);
        orders.add(ord7);
        orders.add(ord8);
        orders.add(ord9);
        orders.add(ord10);
        orders.add(ord11);
        orders.add(ord12);

        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        orderDetails.add(new OrderDetail(prod3, 5, ord1));
        orderDetails.add(new OrderDetail(prod2, 3, ord1));
        orderDetails.add(new OrderDetail(prod4, 2, ord2));
        orderDetails.add(new OrderDetail(prod1, 1, ord2));
        orderDetails.add(new OrderDetail(prod5, 4, ord3));
        orderDetails.add(new OrderDetail(prod2, 3, ord3));
        orderDetails.add(new OrderDetail(prod1, 2, ord4));
        orderDetails.add(new OrderDetail(prod4, 1, ord4));
        orderDetails.add(new OrderDetail(prod5, 2, ord4));
        orderDetails.add(new OrderDetail(prod3, 3, ord5));
        orderDetails.add(new OrderDetail(prod1, 4, ord6));
        orderDetails.add(new OrderDetail(prod4, 1, ord7));
        orderDetails.add(new OrderDetail(prod2, 2, ord8));
        orderDetails.add(new OrderDetail(prod1, 3, ord8));
        orderDetails.add(new OrderDetail(prod5, 2, ord9));
        orderDetails.add(new OrderDetail(prod3, 4, ord9));
        orderDetails.add(new OrderDetail(prod2, 2, ord10));
        orderDetails.add(new OrderDetail(prod5, 3, ord10));
        orderDetails.add(new OrderDetail(prod1, 2, ord11));
        orderDetails.add(new OrderDetail(prod4, 1, ord11));
        orderDetails.add(new OrderDetail(prod3, 3, ord11));
        orderDetails.add(new OrderDetail(prod2, 1, ord12));
        orderDetails.add(new OrderDetail(prod5, 2, ord12));
        orderDetails.add(new OrderDetail(prod4, 3, ord12));
        orderDetails.add(new OrderDetail(prod1, 1, ord12));
        orderDetails.add(new OrderDetail(prod2, 4, ord12));

        SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            for (Customer customer : customers) {
                session.saveOrUpdate(customer);
            }

            for (Product product : products) {
                session.saveOrUpdate(product);
            }

            for (Order order : orders) {
                session.saveOrUpdate(order);
            }

            session.getTransaction().commit();
        } finally {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public static void main(String[] args) {
        // populateData();

        OrderCtl orderCtl = new OrderCtl();

        List<Order> orders = orderCtl.findOrderByStatus("Processing");
        System.out.println(orders.size() + " processing orders found");
        for (Order order : orders) {
            System.out.printf("OrderID: #%d, Customer: %s\n", order.getId(), order.getCustomer().getName());
        }

        orders = orderCtl.findOrderByCustomerName("Sarah Johnson");
        System.out.println(orders.size() + " orders found for Sarah Johnson");
        for (Order order : orders) {
            System.out.printf("OrderID: #%d, Status: %s\n", order.getId(), order.getStatus());
        }
    }
}
