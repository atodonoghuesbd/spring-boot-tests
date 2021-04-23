package com.example.springboottests.service.data;

import com.example.springboottests.model.persistence.PersonEntity;
import com.example.springboottests.model.transport.PersonTransportObject;
import com.example.springboottests.repository.PersonRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final MapperFacade mapperFacade;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(MapperFacade mapperFacade, PersonRepository personRepository) {
        this.mapperFacade = mapperFacade;
        this.personRepository = personRepository;
    }

    public List<PersonTransportObject> getPeople() {
        return mapperFacade.mapAsList(personRepository.findAll(), PersonTransportObject.class);
    }

    public PersonTransportObject getPerson(Long id) {
        return mapperFacade.map(personRepository.findById(id), PersonTransportObject.class);
    }

    public void postPerson(PersonTransportObject personTransportObject) {
        personRepository.save(mapperFacade.map(personTransportObject, PersonEntity.class));
    }

    public void savePerson(PersonTransportObject personTransportObject) {
        postPerson(personTransportObject);
    }
}
