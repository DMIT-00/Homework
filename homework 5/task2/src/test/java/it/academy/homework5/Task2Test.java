package it.academy.homework5;

import it.academy.homework5.beans.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class Task2Test {

    @Test
    public void testBeanExists() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        Car car = (Car) context.getBean("car");

        assertNotNull(car);
    }
}