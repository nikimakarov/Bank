package edu.core.java.bank.domain;

import java.util.Date;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class Transaction extends DomainObject{

    private String number;
    private Date date;
    private Card card;
    private Product product;
    private double salaryWithPrivilege;

    public Transaction(Long id, String number, Date date, double salaryWP) {
        super.id = id;
        this.number = number;
        this.date = date;
        this.salaryWithPrivilege = salaryWP;
    }

    public Transaction(String number, Date date, double salaryWP) {
        this.number = number;
        this.date = date;
        this.salaryWithPrivilege = salaryWP;
    }


    public String getNumber() { return number;}

    public Date getDate() { return date;}

    public Card getCard() { return card;}

    public Product getProduct() { return product;}

    public double getSalaryWithPrivilege() { return salaryWithPrivilege;}

    public void setCard(Card card) { this.card = card;}

    public void setProduct(Product product) { this.product = product; }
}
