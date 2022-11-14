package it.academy.homework3.dao;

import it.academy.homework3.model.Car;

import java.util.List;

public interface CarDao {
    void create(Car car);
    Car loadById(Long id);
    Car getById(Long id);
    void update(Car car);
    void delete(Car car);
    void deleteAndCreate(Car car);
    List<Car> readAll();
}
