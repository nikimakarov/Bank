package edu.core.java.bank.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class TransactionVO extends ValueObject{

    public String number;
    public Date date;
    public long cardId;
    public long productId;
    public double salaryWithPrivilege;

    public TransactionVO(Long id, String number, Date date, double salaryWP) {
        super.id = id;
        this.number = number;
        this.date = date;
        this.cardId = cardId;
        this.productId = productId;
        this.salaryWithPrivilege = salaryWP;
    }

    public TransactionVO(String number, Date date, long cardId, long productId, double salaryWP) {
        this.number = number;
        this.date = date;
        this.cardId = cardId;
        this.productId = productId;
        this.salaryWithPrivilege = salaryWP;
    }

//    @Override
//    public String toString() {
//        String datePattern = "dd/mm/yyyy";
//        SimpleDateFormat format = new SimpleDateFormat(datePattern);
//        return "id: " + super.id + " | number: " + number + " | transaction date: " + format.format(date) +
//                " | card id: " + cardId + " | product id: " + productId + " | salary with privilege.json: " + salaryWithPrivilege;
//    }
}
