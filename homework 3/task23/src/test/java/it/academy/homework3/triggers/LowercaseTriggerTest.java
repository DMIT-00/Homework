package it.academy.homework3.triggers;

import it.academy.homework3.dao.CarDaoImpl;
import it.academy.homework3.utils.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LowercaseTriggerTest {
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
    public void checkIfLowercaseTriggerCreated() {
        // Given

        // When

        // Then
    }

    @Test
    public void checkIfLowercaseTriggerExecuted() {
        // Given

        // When

        // Then
    }

    @Test
    public void checkIfLowercaseTriggerDropped() {
        // Given

        // When

        // Then
    }
}