package it.academy.homework4.vehicle.dao;

import it.academy.homework4.utils.HibernateUtil;
import it.academy.homework4.vehicle.model.Bike;
import it.academy.homework4.vehicle.model.Car;
import it.academy.homework4.vehicle.model.Vehicle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class VehicleDaoImplTest {
    VehicleDao targetObject;

    @Before
    public void setUp() {
        targetObject = new VehicleDaoImpl(HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void create() {
        // Given
        Vehicle car = Car.builder()
                .weight(2000.5).maxSpeed(280.0).color("RED")
                .build();

        Vehicle bike = Bike.builder()
                .weight(200.0).price(new BigDecimal("1000.5")).manufacturer("Suzuki")
                .build();

        Vehicle vehicle = Vehicle.builder()
                .weight(500.5)
                .build();

        int initialSize = targetObject.finaAll().size();

        // When
        targetObject.create(car);
        targetObject.create(bike);
        targetObject.create(vehicle);

        // Then
        int actualSize = targetObject.finaAll().size();
        assertEquals(initialSize + 3, actualSize);
    }

    @Test
    public void finaAll() {
        // Given
        Vehicle car = Car.builder()
                .weight(2000.5).maxSpeed(280.0).color("RED")
                .build();

        Vehicle bike = Bike.builder()
                .weight(200.0).price(new BigDecimal("1000.5")).manufacturer("Suzuki")
                .build();

        Vehicle vehicle = Vehicle.builder()
                .weight(500.5)
                .build();

        int initialSize = targetObject.finaAll().size();

        targetObject.create(car);
        targetObject.create(bike);
        targetObject.create(vehicle);

        // When
        int actualSize = targetObject.finaAll().size();

        // Then
        assertEquals(initialSize + 3, actualSize);
    }
}