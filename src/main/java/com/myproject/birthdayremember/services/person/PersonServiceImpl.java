package com.myproject.birthdayremember.services.person;

import com.myproject.birthdayremember.model.Model;
import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements ITPersonService {

    /*@Autowired
    PersonRepository personRepository;*/

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        List<Person> allPersons = this.personRepository.findAll();
        for (Person person:allPersons
             ) {
            person.setBirthDay();
        }
        return allPersons;
    }

    @Override
    public Person addPerson(Person person) {
        person.setBirthDay();
        return this.personRepository.save(person);
    }


    @Override
    public void deletePerson(int personId) throws Exception{
        this.personRepository.deleteById(personId);
    }


    @Override
    public Person findAPerson(String person) {
        return this.personRepository.findByFirstName(person);
    }

    @Override
    public Person updatePerson(int personId, Person person) throws Exception {
        Optional<Person> optionalPerson = this.personRepository.findById(personId);
        if (optionalPerson.isPresent()) {
            Person rPerson = optionalPerson.get();

            rPerson.setFirstName(person.getFirstName());
            rPerson.setLastName(person.getLastName());
            rPerson.setDateOfBirth(person.getDateOfBirth());
            rPerson.setBirthDay();
            personRepository.save(rPerson);
            return rPerson;
        }
        else return null;
    }

}
