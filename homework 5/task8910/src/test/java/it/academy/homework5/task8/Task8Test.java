package it.academy.homework5.task8;

import it.academy.homework5.BaseTest;
import it.academy.homework5.task8.beans.Person;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class Task8Test extends BaseTest {
    @Test
    public void autowiredTask() {
        Person person = (Person) context.getBean("person");

        assertNotNull(person.getCar());
    }
}