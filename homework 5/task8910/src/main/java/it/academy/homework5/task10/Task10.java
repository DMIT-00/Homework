package it.academy.homework5.task10;

import it.academy.homework5.task10.beans.Employee;
import org.springframework.context.ApplicationContext;

public class Task10 {
    public static void automaticDiscoveryTask(ApplicationContext context) {
        Employee employee = (Employee) context.getBean("employee");

        employee.setSalary(200.0);

        System.out.println(employee);
    }
}
