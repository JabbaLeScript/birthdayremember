package com.myproject.birthdayremember.repositories;

import com.myproject.birthdayremember.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PersonRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired PersonRepository personRepository;

    /*@Test
    void whenFindByBirthDayDate_thenReturnPersonwithTodaysBirthday() {

        LocalDate todaysBirthday = LocalDate.of(1992, Month.DECEMBER, 25);
        LocalDate todaysBirthday2 = LocalDate.of(1999, Month.DECEMBER, 25);
        Person bPerson = new Person("Pierre", "Paul", todaysBirthday);
        Person bPerson2 = new Person("Jean", "Eude", todaysBirthday2);
        LocalDate birthday = LocalDate.of(1992, Month.MARCH, 1);
        Person personNotB = new Person("Alexandre", "vieira", birthday);

        testEntityManager.persist(personNotB);
        testEntityManager.persist(bPerson);
        testEntityManager.flush();

        List<Person> found = personRepository.findByBirthDayIsTrue();

        for (Person person : found) {
            System.out.println("today's birthday of " + person.getName());
        }

        Assertions.assertFalse(found.isEmpty());
    }*/
}
