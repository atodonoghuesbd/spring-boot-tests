package com.example.springboottests.controller;

import com.example.springboottests.api.data.PersonService;
import com.example.springboottests.model.transport.PersonTransportObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController implements PersonService<PersonTransportObject>{

  private final PersonService<PersonTransportObject> personService;

  @Autowired
  public PersonController(PersonService<PersonTransportObject> personService) {
    this.personService = personService;
  }

  @Override
  @GetMapping(value = "/")
  public List<PersonTransportObject> getPeople() {
    return personService.getPeople();
  }

  @Override
  @GetMapping(value = "/{id}")
  public PersonTransportObject getPerson(@PathVariable(value = "id") Long id) {
    return personService.getPerson(id);
  }

  @Override
  @PostMapping(value = "/")
  @ResponseStatus(HttpStatus.CREATED)
  public void postPerson(@RequestBody PersonTransportObject person) {
    savePerson(person);
  }

  @Override
  public void savePerson(PersonTransportObject person) {
    personService.postPerson(person);
  }
}
