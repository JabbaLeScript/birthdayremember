package com.myproject.birthdayremember.services.person;

import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements ITPersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        List<Person> allPersons = this.personRepository.findAll();
        for (Person person:allPersons
             ) {
            this.setbirthDay(person);
        }
        return allPersons;
        //return this.personRepository.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        this.setbirthDay(person);
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
        Person rPerson = optionalPerson.get();

        rPerson.setFirstName(person.getFirstName());
        rPerson.setLastName(person.getLastName());
        rPerson.setDateOfBirth(person.getDateOfBirth());

        this.setbirthDay(rPerson);
        personRepository.save(rPerson);
        return rPerson;
    }

    private void setbirthDay(Person person){
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonth().getValue();
        int birthdayDay = person.getDateOfBirth().getDayOfMonth();
        //int birthdayDay = this.dateOfBirth.getDayOfMonth();
        int birthdayMonth = person.getDateOfBirth().getMonth().getValue();
        if (day == birthdayDay && month == birthdayMonth) person.setBirthDay(true);
        //return day == birthdayDay && month == birthdayMonth;
    }
}
