package org.itsci.it10306214.lesson10.lab;

import org.itsci.it10306214.DateUtils;
import org.itsci.it10306214.lesson10.lab.controllers.TransactionCtl;
import org.itsci.it10306214.lesson10.lab.models.Trans;
import org.itsci.it10306214.lesson10.lab.models.TransDetail;

public class TestApp {

    public static final int tax = 7;

    public static void main(String[] args) {
        TransactionCtl transactionCtl = new TransactionCtl();

        Trans transaction = transactionCtl.findTransactionById(1);

        System.out.println("----------------------------------------------------------");
        System.out.printf("%36s\n", "Invoice / Billing");
        System.out.println("----------------------------------------------------------");
        System.out.printf("Date: %s\n", DateUtils.DateToString(transaction.getDate()));
        System.out.printf("Transaction ID: %d\n", transaction.getId());
        System.out.printf("Customer ID: %d\n", transaction.getCustomer().getId());
        System.out.printf("Customer Name: %s\n", transaction.getCustomer().getName());
        System.out.printf("Email: %s\n\n", transaction.getCustomer().getEmail());
        System.out.printf("Shop: %s\n", transaction.getShop().getName());
        System.out.printf("Employee: %s\n\n", transaction.getEmployee().getName());
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-17s|%9s |%11s |%12s |\n", "Product Name", "Quantity", "Unit Price",
                "Total Price");
        System.out.println("----------------------------------------------------------");
        for (TransDetail detail : transaction.getTransactionDetails()) {
            System.out.printf("| %-17s|%6d    |%8.2f    |%10.2f   |\n", detail.getProduct().getName(),
                    detail.getQuantity(), detail.getPrice(), detail.getTotal());
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("\n%s%.2f\n", "Subtotal: ", transaction.getSubtotal());
        System.out.printf("Tax (%d%%): %.2f\n", tax, transaction.getVat());
        System.out.printf("Total Amount: %.2f", transaction.getTotal());
        System.out.println("\n----------------------------------------------------------");
        System.out.printf("Payment Status: %s\n", transaction.getPaymentStatus());
        System.out.printf("Payment Type: %s\n", transaction.getPaymentType());
        System.out.println("----------------------------------------------------------");
        System.out.printf("\nThank you for shopping with us.");
    }
}
