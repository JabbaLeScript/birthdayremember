package com.myproject.birthdayremember.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.myproject.birthdayremember.listeners.PersonObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    public static List<Person> personListToObserve = new ArrayList<>();

    private static List<PropertyChangeListener> listeners = new ArrayList<>();

    public static String BIRTHDAY = "birthday";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    @Transient()
    private boolean birthDay;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        personListToObserve.add(this);
        new PersonObserver(this);
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

    public void setBirthDay() {
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonth().getValue();
        int birthdayDay = this.dateOfBirth.getDayOfMonth();
        int birthdayMonth = this.dateOfBirth.getMonth().getValue();
        notifyListeners(this,
                BIRTHDAY,
                this.birthDay,
                this.birthDay = day == birthdayDay && month == birthdayMonth);
        //this.birthDay = day == birthdayDay && month == birthdayMonth;
    }

    @Autowired(required = true)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Autowired(required = true)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Autowired(required = true)
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addChangeListener(PropertyChangeListener newListener)
    {
        listeners.add(newListener);

    }

    private void notifyListeners(Object object, String property, Object oldValue, Object newValue) {
        for (PropertyChangeListener name : listeners) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    public void setBirthDay(boolean birthDay) {
        this.birthDay = birthDay;
    }
}
