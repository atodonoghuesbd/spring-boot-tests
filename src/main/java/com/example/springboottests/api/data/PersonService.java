package com.example.springboottests.api.data;

import java.util.List;

public interface PersonService<T> {

  List<T> getPeople();

  T getPerson(Long id);

  void postPerson(T person);

  void savePerson(T person);
}
