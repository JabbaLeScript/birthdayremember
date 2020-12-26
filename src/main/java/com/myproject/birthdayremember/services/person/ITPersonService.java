package com.myproject.birthdayremember.services.person;

import com.myproject.birthdayremember.model.Person;

import java.util.List;

public interface ITPersonService {

    List<Person> findAll();

    void deletePerson(int personId) throws Exception;

    Person findAPerson(String person) throws Exception;

    Person addPerson(Person person);

    Person updatePerson(int personId, Person person) throws Exception;




}
