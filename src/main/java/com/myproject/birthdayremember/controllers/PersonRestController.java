package com.myproject.birthdayremember.controllers;

import com.myproject.birthdayremember.links.PersonLink;
import com.myproject.birthdayremember.model.Person;
import com.myproject.birthdayremember.services.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.util.List;

@RestController
@RequestMapping(PersonLink.BASE_URL)
public class PersonRestController {

    private PersonServiceImpl personService;

    @Autowired
    public PersonRestController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping(PersonLink.PERSONS)
    @ResponseBody
    public ResponseEntity<?> createPerson(@RequestBody Person person){
        Person result = this.personService.addPerson(person);
        return ResponseEntity.ok(result);
    }

    @GetMapping(PersonLink.PERSONS)
    public ResponseEntity<?> getPersons(){
        List<Person> results = this.personService.findAll();
        return ResponseEntity.ok(results);
    }

    //Person
    @PutMapping(PersonLink.PERSON)
    public ResponseEntity<?> updatePerson(@PathVariable int personId,
                                          @RequestBody Person person){
        try {
            Person result = this.personService.updatePerson(personId, person);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this person does not exist or was deleted");
        }
    }

    @DeleteMapping(PersonLink.PERSON)
    public ResponseEntity<?> deletePerson(@PathVariable int personId){
        try {
            this.personService.deletePerson(personId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this person does not exist or was already deleted");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted");
    }
}
