package it.academy.homework4.person.dao;

import it.academy.homework4.embeddable.Address;
import it.academy.homework4.person.model.Employee;
import it.academy.homework4.person.model.Person;
import it.academy.homework4.person.model.Student;
import it.academy.homework4.utils.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PersonDaoImplTest {
    PersonDao targetObject;

    @Before
    public void setUp() {
        targetObject = new PersonDaoImpl(HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void create() {
        // Given
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

        int initialSize = targetObject.finaAll().size();

        // When
        targetObject.create(employee);
        targetObject.create(person);
        targetObject.create(student);

        // Then
        int actualSize = targetObject.finaAll().size();
        assertEquals(initialSize + 3, actualSize);
    }

    @Test
    public void finaAll() {
        // Given
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

        int initialSize = targetObject.finaAll().size();
        targetObject.create(employee);
        targetObject.create(person);
        targetObject.create(student);

        // When
        int actualSize = targetObject.finaAll().size();

        // Then
        assertEquals(initialSize + 3, actualSize);
    }
}