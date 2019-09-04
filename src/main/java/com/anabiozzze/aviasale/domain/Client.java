package com.anabiozzze.aviasale.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;
    private String nationality;
    private String sex;
    private String birthDate;
    private long passNumber;


    public Client() {
    }

    public Client(String firstName, String lastName, String nationality, String sex, Date birthDate, long passNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.sex = sex;

        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.birthDate = mdyFormat.format(birthDate);
        this.passNumber = passNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.birthDate = mdyFormat.format(birthDate);
    }

    public long getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(long passNumber) {
        this.passNumber = passNumber;
    }

    public Integer getId() {
        return id;
    }
}
