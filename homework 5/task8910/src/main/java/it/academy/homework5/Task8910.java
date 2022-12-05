package it.academy.homework5;

import it.academy.homework5.task10.Task10;
import it.academy.homework5.task8.Task8;
import it.academy.homework5.task9.Task9;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task8910 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        Task8.autowiredTask(context); // Задание 8
        Task9.qualifyingTask(context); // Задание 9
        Task10.automaticDiscoveryTask(context); // Задание 10
    }

}
