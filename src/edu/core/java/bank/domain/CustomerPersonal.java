package edu.core.java.bank.domain;

import edu.core.java.bank.Genders;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerPersonal extends DomainObject{

    private String phoneNumber;
    private String email;

    public CustomerPersonal(Long id, String phoneNumber, String email) {
        super.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public CustomerPersonal(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
