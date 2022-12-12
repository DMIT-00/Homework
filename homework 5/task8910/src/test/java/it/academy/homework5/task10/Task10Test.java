package it.academy.homework5.task10;

import it.academy.homework5.BaseTest;
import it.academy.homework5.task10.beans.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task10Test extends BaseTest {

    @Test
    public void automaticDiscoveryTask() {
        Employee employee = (Employee) context.getBean("employee");

        assertNotNull(employee);
    }
}