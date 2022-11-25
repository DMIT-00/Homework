package it.academy.homework4.animal.dao;

import it.academy.homework4.animal.model.Animal;
import it.academy.homework4.animal.model.Cat;
import it.academy.homework4.animal.model.Dog;
import it.academy.homework4.utils.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalDaoImplTest {
    AnimalDao targetObject;

    @Before
    public void setUp() {
        targetObject = new AnimalDaoImpl(HibernateUtil.getSessionFactory("hibernate_test.cfg.xml"));
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void create() {
        // Given
        Animal cat = Cat.builder()
                .age(2).color("BLACK")
                .build();

        Animal dog = Dog.builder()
                .age(10).vaccinated(true)
                .build();

        Animal animal = Animal.builder()
                .age(14)
                .build();

        int initialSize = targetObject.finaAll().size();

        // When
        targetObject.create(cat);
        targetObject.create(dog);
        targetObject.create(animal);

        // Then
        int actualSize = targetObject.finaAll().size();
        assertEquals(initialSize + 3, actualSize);
    }

    @Test
    public void finaAll() {
        // Given
        Animal cat = Cat.builder()
                .age(2).color("BLACK")
                .build();

        Animal dog = Dog.builder()
                .age(10).vaccinated(true)
                .build();

        Animal animal = Animal.builder()
                .age(14)
                .build();

        int initialSize = targetObject.finaAll().size();

        targetObject.create(cat);
        targetObject.create(dog);
        targetObject.create(animal);

        // When
        int actualSize = targetObject.finaAll().size();

        // THen
        assertEquals(initialSize + 3, actualSize);
    }
}