package it.academy.homework5.task9;

import it.academy.homework5.task9.beans.Student;
import org.springframework.context.ApplicationContext;

public class Task9 {
    public static void qualifyingTask(ApplicationContext context) {
        Student student = (Student) context.getBean("student");

        student.getContactInformation().setContact("+375 44 222-33-44");

        System.out.println(student);
    }
}
