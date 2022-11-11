package it.academy.homework3.dao;

import it.academy.homework3.model.Car;
import it.academy.homework3.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CarDaoImplTest {
    CarDaoImpl testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new CarDaoImpl(HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
    }

    @After
    public void tearDown() throws Exception {
        testObject = null;
    }

    @Test
    public void create() {
        // Given
        int sizeBefore = testObject.readAll().size();
        Car car = new Car(null, "BMW", Date.valueOf("2000-02-02"), 100.0);

        // When
        testObject.create(car);

        // Then
        int sizeAfter = testObject.readAll().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void readAll() {
        // Given
        int sizeBefore = testObject.readAll().size();
        List<Car> cars = List.of(
                new Car(null, "BMW", Date.valueOf("2020-02-08"), 1.0),
                new Car(null, "KIA", Date.valueOf("2014-04-08"), 10.0),
                new Car(null, "Ford", Date.valueOf("2016-08-02"), 20.0),
                new Car(null, "Lada", Date.valueOf("2018-02-02"), 300.0),
                new Car(null, "Ferrari", Date.valueOf("2022-04-04"), 42.0)
        );
        cars.forEach(testObject::create);

        // When
        int sizeAfter = testObject.readAll().size();

        // Then
        assertEquals(sizeBefore + cars.size(), sizeAfter);
    }

    @Test
    public void loadById() {
        // Given
        Car car = new Car(null, "Lada", Date.valueOf("2000-02-02"), 10.0);
        testObject.create(car);

        // When
        Car newCar = testObject.loadById(car.getId());

        // Then
        assertEquals(car.getId(), newCar.getId());
        assertEquals(car.getManufacturer(), newCar.getManufacturer());
        assertEquals(car.getMileage(), newCar.getMileage());
        assertEquals(car.getManufactureDate(), newCar.getManufactureDate());
    }

    @Test
    public void loadByIdShouldThrowException() {
        // Given
        Long id = -1L; // because id can't be < 0

        // When
        // Then
        assertThrows(HibernateException.class, () -> testObject.loadById(id));
    }

    @Test
    public void getByIdShouldReturnNull() {
        // Given
        Long id = -1L; // because id can't be < 0

        // When
        // Then
        assertNull(testObject.getById(id));
    }

    @Test
    public void getById() {
        // Given
        Car car = new Car(null, "Lada", Date.valueOf("2000-02-02"), 10.0);
        testObject.create(car);

        // When
        Car newCar = testObject.getById(car.getId());

        // Then
        assertEquals(car.getId(), newCar.getId());
        assertEquals(car.getManufacturer(), newCar.getManufacturer());
        assertEquals(car.getMileage(), newCar.getMileage());
        assertEquals(car.getManufactureDate(), newCar.getManufactureDate());
    }

    @Test
    public void update() {
        // Given
        Car car = new Car(null, "BMW", Date.valueOf("2000-02-02"), 100.0);
        testObject.create(car);

        // When
        String newManufacturer = "KIA";
        car.setManufacturer(newManufacturer);
        testObject.update(car);

        // Then
        Car newCar = testObject.getById(car.getId());
        assertEquals(newManufacturer, newCar.getManufacturer());
    }

    @Test
    public void delete() {
        // Given
        Car car = new Car(null, "BMW", Date.valueOf("2000-02-02"), 100.0);
        testObject.create(car);
        int sizeBefore = testObject.readAll().size();

        // When
        testObject.delete(car);

        // Then
        int sizeAfter = testObject.readAll().size();
        assertEquals(sizeBefore - 1, sizeAfter);
    }
}