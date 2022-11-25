package it.academy.homework4.animal.dao;

import it.academy.homework4.animal.model.Animal;

import java.util.List;

public interface AnimalDao {
    void create(Animal animal);
    List<Animal> finaAll();
}
