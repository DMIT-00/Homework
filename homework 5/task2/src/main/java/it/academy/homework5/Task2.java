package it.academy.homework5;

import it.academy.homework5.beans.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        Car car = (Car) context.getBean("car");

        System.out.println(car);
    }
}
