package com.myproject.birthdayremember;

import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.repositories.PersonRepository;
import com.myproject.birthdayremember.services.person.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class BirthdayrememberApplicationTests {

    @Test
    void contextLoads() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BirthdayrememberApplicationTests.class);
        //TODO:remove this. The entity class is not a bean.
        /*Person personBean = ctx.getBean(Person.class);
        Assertions.assertNotNull(personBean);*/

        PersonServiceImpl personService = ctx.getBean(PersonServiceImpl.class);
        Assertions.assertNotNull(PersonServiceImpl.class);
    }

}
