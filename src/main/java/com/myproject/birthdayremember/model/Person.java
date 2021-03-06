package com.myproject.birthdayremember.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @Transient
    private boolean birthDay;

    protected Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.birthDay = false;
    }

    protected boolean setbirthDay(){
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonth().getValue();
        int birthdayDay = this.dateOfBirth.getDayOfMonth();
        int birthdayMonth = this.dateOfBirth.getMonth().getValue();
        return day == birthdayDay && month == birthdayMonth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isBirthDay() {
        return birthDay;
    }

    public void setBirthDay(boolean birthDay) {
        this.birthDay = birthDay;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String surname) {
        this.lastName = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surname='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", birthDay=" + birthDay +
                '}';
    }
}
