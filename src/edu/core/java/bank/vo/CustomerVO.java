package edu.core.java.bank.vo;

import edu.core.java.bank.Genders;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerVO extends ValueObject{

    public String name;
    public Date dateOfBirth;
    public Genders gender;
    public long personalInfo;


    public CustomerVO(Long id, String name, Date dateOfBirth, Genders gender, long personalInfo) {
        super.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.personalInfo = personalInfo;
    }

    public CustomerVO(String name, Date dateOfBirth, Genders gender, long personalInfo) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.personalInfo = personalInfo;
    }

    @Override
    public String toString() {
        String datePattern = "dd/mm/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return  "id: " + super.id + " | name: " + name +  " | date of birth:  " +
                format.format(dateOfBirth) +  " | gender: " + gender.toString() + " | personal information: " + personalInfo;
    }
}
