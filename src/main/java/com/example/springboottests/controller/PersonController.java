package com.example.springboottests.controller;

import com.example.springboottests.model.transport.PersonTransportObject;
import com.example.springboottests.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<PersonTransportObject>> getPeople() {
        return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonTransportObject> getPeople(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> postPerson(@RequestBody PersonTransportObject personTransportObject) {
        personService.postPerson(personTransportObject);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
