package it.academy.homework4;

import it.academy.homework4.animal.dao.AnimalDao;
import it.academy.homework4.animal.dao.AnimalDaoImpl;
import it.academy.homework4.animal.model.Animal;
import it.academy.homework4.animal.model.Cat;
import it.academy.homework4.animal.model.Dog;
import it.academy.homework4.embeddable.Address;
import it.academy.homework4.person.dao.PersonDao;
import it.academy.homework4.person.dao.PersonDaoImpl;
import it.academy.homework4.person.model.Employee;
import it.academy.homework4.person.model.Person;
import it.academy.homework4.person.model.Student;
import it.academy.homework4.utils.HibernateUtil;
import it.academy.homework4.vehicle.dao.VehicleDao;
import it.academy.homework4.vehicle.dao.VehicleDaoImpl;
import it.academy.homework4.vehicle.model.Bike;
import it.academy.homework4.vehicle.model.Car;
import it.academy.homework4.vehicle.model.Vehicle;

import java.math.BigDecimal;

public class Task678 {
    public static void main(String[] args) {
        makeAndSave3DifferentPersons();
        makeAndSave3DifferentAnimals();
        makeAndSave3DifferentVehicles();

        printEveryPerson();
        printEveryAnimal();
        printEveryVehicle();
    }

    private static void printEveryVehicle() {
        VehicleDao vehicleDao = new VehicleDaoImpl(HibernateUtil.getSessionFactory());

        System.out.println("Vehicles in database:");
        vehicleDao.finaAll().forEach(System.out::println);
    }

    private static void printEveryAnimal() {
        AnimalDao animalDao = new AnimalDaoImpl(HibernateUtil.getSessionFactory());

        System.out.println("Animals in database:");
        animalDao.finaAll().forEach(System.out::println);
    }

    private static void printEveryPerson() {
        PersonDao personDao = new PersonDaoImpl(HibernateUtil.getSessionFactory());

        System.out.println("Persons in database:");
        personDao.finaAll().forEach(System.out::println);
    }

    private static void makeAndSave3DifferentVehicles() {
        Vehicle car = Car.builder()
                .weight(2000.5).maxSpeed(280.0).color("RED")
                .build();

        Vehicle bike = Bike.builder()
                .weight(200.0).price(new BigDecimal("1000.5")).manufacturer("Suzuki")
                .build();

        Vehicle vehicle = Vehicle.builder()
                .weight(500.5)
                .build();

        VehicleDaoImpl vehicleDao = new VehicleDaoImpl(HibernateUtil.getSessionFactory());

        vehicleDao.create(car);
        vehicleDao.create(bike);
        vehicleDao.create(vehicle);
    }

    private static void makeAndSave3DifferentAnimals() {
        Animal cat = Cat.builder()
                .age(2).color("BLACK")
                .build();

        Animal dog = Dog.builder()
                .age(10).vaccinated(true)
                .build();

        Animal animal = Animal.builder()
                .age(14)
                .build();

        AnimalDaoImpl animalDao = new AnimalDaoImpl(HibernateUtil.getSessionFactory());

        animalDao.create(cat);
        animalDao.create(dog);
        animalDao.create(animal);
    }

    private static void makeAndSave3DifferentPersons() {
        Person employee = Employee.builder()
                .age(28).name("Mark").lastName("Conder").salary(new BigDecimal("800.2")).department("IT")
                .address(new Address("Lenina", 1))
                .build();

        Person student = Student.builder()
                .age(18).name("John").lastName("Doe").year(1)
                .address(new Address("Kirova", 8))
                .build();

        Person person = Person.builder()
                .age(42).name("Nadine").lastName("Dante")
                .address(new Address("Markova", 10))
                .build();

        PersonDaoImpl personDao = new PersonDaoImpl(HibernateUtil.getSessionFactory());

        personDao.create(employee);
        personDao.create(student);
        personDao.create(person);
    }
}
