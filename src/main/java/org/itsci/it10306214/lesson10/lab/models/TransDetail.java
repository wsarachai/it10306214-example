package org.itsci.it10306214.lesson10.lab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransDetail {
    @Id
    @Column(name = "transaction_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "transaction_detail_quantity", nullable = false)
    private int quantity;
    @Column(name = "transaction_detail_price", nullable = false)
    private double price;
    @Column(name = "transaction_detail_total", nullable = false)
    private double total;
    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Trans transaction;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public TransDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Trans getTransaction() {
        return transaction;
    }

    public void setTransaction(Trans transaction) {
        this.transaction = transaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
