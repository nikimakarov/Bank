package edu.core.java.bank.domain;

import edu.core.java.bank.Genders;

import java.util.Date;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class Customer extends DomainObject {

    private String name;
    private Date dateOfBirth;
    private Genders gender;
    private CustomerPersonal personalInfo;


    public Customer(Long id, String name, Date dateOfBirth, Genders gender) {
        super.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Customer(String name, Date dateOfBirth, Genders gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() { return dateOfBirth; }

    public Genders getGender() { return gender;}

    public CustomerPersonal getPersonalInfo() {
        return personalInfo;
    }

    public void setCustomerPersonal(CustomerPersonal customerPersonal) { this.personalInfo = customerPersonal;}

}
