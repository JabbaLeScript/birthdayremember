package com.myproject.birthdayremember.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class PersonTest {

    private Person person, person2;

    @BeforeEach
    void setUp() {
        LocalDate birthday = LocalDate.now();
        LocalDate notBirthday = LocalDate.of(1992, Month.DECEMBER.getValue(), 27);
        this.person = new Person("a","n", birthday);
        this.person2 = new Person("b", "n", notBirthday);
    }

    @Test
    void whentodayisbirthday_thenBirdayIsTrue() {
        Assertions.assertTrue(person.isBirthDay());
    }

    @Test
    void whentodayisNotbirthday_thenBirdayIsFalse() {
        Assertions.assertFalse(person2.isBirthDay());
    }

    @Test
    void whenInstantiatePerson_thenItsAddedInTheStaticPersonList(){
        List<Person> personList = Person.personListToObserve;
        Assertions.assertEquals(2, personList.size());
    }

    @Test
    void name() {
    }
}
