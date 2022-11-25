package it.academy.homework4.vehicle.dao;

import it.academy.homework4.vehicle.model.Vehicle;

import java.util.List;

public interface VehicleDao {
    void create(Vehicle vehicle);
    List<Vehicle> finaAll();
}
