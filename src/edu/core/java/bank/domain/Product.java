package edu.core.java.bank.domain;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class Product extends DomainObject {

    private String name;
    private double price;

    public Product(Long id, String name, double price) {
        super.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
