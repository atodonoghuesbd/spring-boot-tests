package com.example.springboottests.webservice;

import https.springboottests_example_com.ws.person_service.Person;
import java.util.List;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PersonWebService implements com.example.springboottests.api.data.PersonService<Person> {
  private static final String NAMESPACE_URI = "https://springboottests.example.com/ws/person-service";

  @Override
  @ResponsePayload
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPeopleRequest")
  public List<Person> getPeople() {
    return null;
  }

  @Override
  @ResponsePayload
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
  public Person getPerson(@RequestPayload Long id) {
    return null;
  }

  @Override
  @ResponsePayload
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postPersonRequest")
  public void postPerson(@RequestPayload Person postPersonRequest) {
    this.savePerson(postPersonRequest);
  }

  @Override
  public void savePerson(@RequestPayload Person person) {

  }
}
