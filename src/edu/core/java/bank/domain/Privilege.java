package edu.core.java.bank.domain;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class Privilege extends DomainObject {

    private Card card;
    private double salePercent;

    public Privilege(Long id, double salePercent) {
        super.id = id;
        this.salePercent = salePercent;
    }

    public Privilege(double salePercent) {
        this.salePercent = salePercent;
    }

    public Card getCard() {
        return card;
    }

    public double getSalePercent() {
        return salePercent;
    }

    public void setCard(Card card) { this.card = card; }
}
