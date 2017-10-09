package edu.core.java.bank.vo;

import edu.core.java.bank.CardTypes;
import edu.core.java.bank.domain.Customer;
import edu.core.java.bank.domain.DomainObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CardVO extends ValueObject {

    public String number;
    public double balance;
    public CardTypes type;
    public long customerId;


    public CardVO(Long id, String number, double balance, CardTypes type, long customerId) {
        super.id = id;
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.customerId = customerId;
    }

    public CardVO(String number, double balance, CardTypes type, long customerId) {
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.customerId = customerId;
    }

//    @Override
//    public String toString() {
//        return  "id: " + super.id + " | number: " + number + " | balance:  " + balance + " | type: " + type.toString() + " | customer: " + customerId;
//    }
}
