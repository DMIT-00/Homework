package it.academy.homework7.service;

import it.academy.homework7.dao.CarDao;
import it.academy.homework7.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    CarDao carDao;

    public void addNewCar(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Car name is invalid!");
        }

        Car car = new Car(null, name);

        carDao.create(car);
    }

    public List<Car> getAllCars() {
        return carDao.findAll();
    }
}
