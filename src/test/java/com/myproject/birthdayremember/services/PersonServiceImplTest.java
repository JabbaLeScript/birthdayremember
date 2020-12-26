package com.myproject.birthdayremember.services;

import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.repositories.PersonRepository;
import com.myproject.birthdayremember.services.person.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService = new PersonServiceImpl();

    Person person;
    
    List<Person> personsBirthDay; 

    @BeforeEach
    void setMockOutput() {
        LocalDate todaysBirthday = LocalDate.of(1992, Month.DECEMBER, 25);
        LocalDate todaysBirthday2 = LocalDate.of(1999, Month.DECEMBER, 25);
        Person bPerson = new Person("Pierre", "Paul", todaysBirthday);
        Person bPerson2 = new Person("Jean", "Eude", todaysBirthday2);
        LocalDate birthday = LocalDate.of(1992, Month.MARCH, 1);
        this.person = new Person("Alexandre", "vieira", birthday);

        this.personsBirthDay = Arrays.asList(
                bPerson, bPerson2
        );
        Mockito.when(personRepository.save(person)).thenReturn(person);
        Mockito.when(personRepository.findByName("Alexandre")).thenReturn(person);
        Mockito.when(personRepository.save(bPerson)).thenReturn(bPerson);
        Mockito.when(personRepository.save(bPerson2)).thenReturn(bPerson2);
        //Mockito.when(personRepository.findByBirthDayIsTrue()).thenReturn(personsBirthDay);
    }

    @Test
    void testFindByName() {

        Assertions.assertEquals(person, personService.findAPerson("Alexandre"));
    }

    @Test
    void testWhenFindAllCall_ThenSetBirthday() {
    }

}
