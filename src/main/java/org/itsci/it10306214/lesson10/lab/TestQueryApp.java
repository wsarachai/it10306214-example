package org.itsci.it10306214.lesson10.lab;

import java.util.List;

import org.itsci.it10306214.lesson10.lab.controllers.CustomerCtl;
import org.itsci.it10306214.lesson10.lab.models.Customer;

public class TestQueryApp {
    public static void main(String[] args) {
        CustomerCtl customerCtl = new CustomerCtl();

        List<Customer> customers = customerCtl.searchCustomerByName("sa");

        for (Customer customer : customers) {
            System.out.printf("ID: %d, Name: %s, Email: %s\n", customer.getId(), customer.getName(),
                    customer.getEmail());
        }
    }
}
