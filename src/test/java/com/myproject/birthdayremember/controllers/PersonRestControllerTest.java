package com.myproject.birthdayremember.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myproject.birthdayremember.links.PersonLink;
import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.repositories.PersonRepository;
import com.myproject.birthdayremember.services.person.PersonServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;

public class PersonRestControllerTest extends AbstractTest {

    @MockBean
    private PersonServiceImpl personService;

    @MockBean
    private PersonRepository personRepository;
    
    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    @Test
    void createPerson() throws Exception {
        String baseUri = PersonLink.BASE_URL;
        String uri = PersonLink.PERSONS;
        Person person = new Person();

        LocalDate dateOfBirth = LocalDate.of(1992, Month.DECEMBER.getValue(), 1);

        //person.setId(1);
        person.setFirstName("Alexandre");
        person.setLastName("Vieira");
        person.setDateOfBirth(dateOfBirth);

        String inputJson = super.mapToJson(person);

        Mockito.when(this.personService.addPerson(person)).thenReturn(person);
        //Mockito.when(this.personRepository.save(person)).thenReturn(person);

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(baseUri + uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson)
        ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);


        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("content" + content);
        Assertions.assertEquals(person.toString(), content);
    }
}
