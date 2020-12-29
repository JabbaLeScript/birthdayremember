package com.myproject.birthdayremember.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.myproject.birthdayremember.links.PersonLink;
import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.repositories.PersonRepository;
import com.myproject.birthdayremember.services.person.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

@ExtendWith(MockitoExtension.class)
public class PersonControllerMockMvCStandaloneTest {

    private MockMvc mockMvc;

    private Person person;

    private LocalDate localDate;

    @Mock
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonRestController personRestController;

    // This object will be magically initialized by the initFields method below.
    private JacksonTester<Person> jsonPerson;

    @BeforeEach
    void setUp() {
        this.localDate = LocalDate.of(1992, Month.DECEMBER.getValue(), 28);
        this.person = new Person();
        //person.setId(1);
        person.setFirstName("Alex");
        person.setLastName("Vieira");
        person.setDateOfBirth(localDate);

        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.personRestController)
                .build();

    }

    @Test
    void canCreateANewPerson() throws Exception {

        MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(PersonLink.BASE_URL+ PersonLink.PERSONS);

        //Mockito.when(personService.addPerson(person)).thenReturn(person);

        MockHttpServletResponse response = mockMvc.perform(
                postBuilder.contentType(MediaType.APPLICATION_JSON).content(
                        jsonPerson.write(person).getJson()
                )).andReturn().getResponse();

        JsonContent<Person> jsonContent = jsonPerson.write(person);
        response.getWriter().write(jsonContent.getJson());
        //Assertions.assertEquals(response.getStatus(), HttpStatus.CREATED.value());
        Assertions.assertEquals(200, response.getStatus());

        String responseContent = response.getContentAsString();
        System.out.println("content simple string method " + responseContent.toString());
        System.out.println("content " + responseContent);// always return empty
    }
}
