package edu.core.java.bank.vo;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class PrivilegeVO extends ValueObject{

    public long cardId;
    public double salePercent;

    public PrivilegeVO(Long id, long cardId, double salePercent) {
        super.id = id;
        this.cardId = cardId;
        this.salePercent = salePercent;
    }

    public PrivilegeVO(long cardId, double salePercent) {
        this.cardId = cardId;
        this.salePercent = salePercent;
    }

//    @Override
//    public String toString() {
//        return  "id: " + super.id + " | card: " + cardId +  " | sale percent: " + salePercent;
//    }
}
