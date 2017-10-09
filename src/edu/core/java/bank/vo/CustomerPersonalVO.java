package edu.core.java.bank.vo;

import edu.core.java.bank.Genders;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerPersonalVO extends ValueObject{

    public String phoneNumber;
    public String email;

    public CustomerPersonalVO(Long id, String phoneNumber, String email) {
        super.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public CustomerPersonalVO(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

//    @Override
//    public String toString() {
//        return  "id: " + super.id + " | phone: " + phoneNumber + " | email: " + email;
//    }
}
