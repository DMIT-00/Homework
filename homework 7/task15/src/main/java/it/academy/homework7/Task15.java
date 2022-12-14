package it.academy.homework7;

import it.academy.homework7.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task15 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        CarService carService = (CarService) context.getBean("carService");

        carService.addNewCar("BMW");

        carService.getAllCars().forEach(System.out::println);
    }
}