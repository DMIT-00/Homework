package it.academy.homework4.person.dao;

import it.academy.homework4.person.model.Person;

import java.util.List;

public interface PersonDao {
    void create(Person person);
    List<Person> finaAll();
}
