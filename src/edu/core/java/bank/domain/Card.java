package edu.core.java.bank.domain;

import edu.core.java.bank.CardTypes;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class Card extends DomainObject {

    private String number;
    private double balance;
    private CardTypes type;
    private Customer customer;


    public Card(Long id, String number, double balance, CardTypes type) {
        super.id = id;
        this.number = number;
        this.balance = balance;
        this.type = type;
    }

    public Card(String number, double balance, CardTypes type) {
        this.number = number;
        this.balance = balance;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public CardTypes getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) { this.customer = customer; }
}
