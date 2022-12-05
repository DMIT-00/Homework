package it.academy.homework5.task8;

import it.academy.homework5.task8.beans.Person;
import org.springframework.context.ApplicationContext;

public class Task8 {
    public static void autowiredTask(ApplicationContext context) {
        Person person = (Person) context.getBean("person");

        System.out.println(person);
    }
}
