package it.academy.homework3;

import it.academy.homework3.dao.CarDaoImpl;
import it.academy.homework3.model.Car;
import it.academy.homework3.triggers.UppercaseTrigger;
import it.academy.homework3.utils.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class Task23 {
    public static void main(String[] args) {
        CarDaoImpl carDao = new CarDaoImpl(HibernateUtil.getSessionFactory());

        UppercaseTrigger.createManufacturerUppercaseTrigger(HibernateUtil.getSessionFactory());
        add5NewCars(carDao);
        UppercaseTrigger.dropManufacturerUppercaseTrigger(HibernateUtil.getSessionFactory());

        add1CarUsingDeleteAndCreate(carDao);

        printEveryCarInDatabase(carDao);
    }

    public static void add5NewCars(CarDaoImpl carDao) {
        List<Car> cars = List.of(
                new Car(null, "BMW", Date.valueOf("2020-02-08"), 1.0),
                new Car(null, "KIA", Date.valueOf("2014-04-08"), 10.0),
                new Car(null, "Ford", Date.valueOf("2016-08-02"), 20.0),
                new Car(null, "Lada", Date.valueOf("2018-02-02"), 300.0),
                new Car(null, "Ferrari", Date.valueOf("2022-04-04"), 42.0)
        );

        cars.forEach(carDao::create);
    }

    public static void add1CarUsingDeleteAndCreate(CarDaoImpl carDao) {
        Car car = new Car(null, "Mercedes", Date.valueOf("2020-02-08"), 10.0);
        carDao.create(car);

        // Example of using flush() method
        // To create object again we need to delete it, then use flush() and create it again
        carDao.deleteAndCreate(car);
    }

    public static void printEveryCarInDatabase(CarDaoImpl carDao) {
        carDao.readAll().forEach(System.out::println);
    }
}
