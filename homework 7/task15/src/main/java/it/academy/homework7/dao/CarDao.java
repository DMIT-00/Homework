package it.academy.homework7.dao;

import it.academy.homework7.model.Car;

import java.util.List;

public interface CarDao {
    void create(Car car);
    Car findById(Long id);
    List<Car> findAll();
    void update(Car car);
    void delete(Car car);
}
