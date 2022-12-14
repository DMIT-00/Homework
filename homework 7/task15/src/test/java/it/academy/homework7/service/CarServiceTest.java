package it.academy.homework7.service;

import it.academy.homework7.BaseTest;
import it.academy.homework7.config.DataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceTest extends BaseTest {
    @Autowired
    CarService carService;

    @Test
    public void addNewCar() {
        int initialSize = carService.getAllCars().size();

        carService.addNewCar("Ferrari");

        assertEquals(initialSize + 1, carService.getAllCars().size());
    }

    @Test
    public void addNewCarCheckNull() {
        assertThrows(IllegalArgumentException.class, () -> carService.addNewCar(null));
    }

    @Test
    public void addNewCarCheckZeroLength() {
        assertThrows(IllegalArgumentException.class, () -> carService.addNewCar(""));
    }

    @Test
    public void getAllCars() {
        int initialSize = carService.getAllCars().size();

        carService.addNewCar("Ferrari");

        assertEquals(initialSize + 1, carService.getAllCars().size());
    }
}