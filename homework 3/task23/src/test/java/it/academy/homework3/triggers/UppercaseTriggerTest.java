package it.academy.homework3.triggers;

import it.academy.homework3.dao.CarDaoImpl;
import it.academy.homework3.model.Car;
import it.academy.homework3.utils.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class UppercaseTriggerTest {
    CarDaoImpl carDao;

    @Before
    public void setUp() throws Exception {
        carDao = new CarDaoImpl(HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
    }

    @After
    public void tearDown() throws Exception {
        carDao = null;
    }

    @Test
    public void checkIfUppercaseTriggerCreated() {
        // Given

        // When

        // Then
    }

    @Test
    public void checkIfUppercaseTriggerExecuted() {
        // Given
        String manufacturer = "Lada";
        Car car = new Car(null, manufacturer, Date.valueOf("2000-02-02"), 10.0);

        // When
        UppercaseTrigger.createManufacturerUppercaseTrigger(
                HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
        carDao.create(car);
        UppercaseTrigger.dropManufacturerUppercaseTrigger(
                HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
        car = carDao.getById(car.getId());

        // Then
        assertEquals(manufacturer.toUpperCase(), car.getManufacturer());
    }

    @Test
    public void checkIfUppercaseTriggerDropped() {
        // Given

        // When

        // Then
    }
}