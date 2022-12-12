package it.academy.homework5.task9;

import it.academy.homework5.BaseTest;
import it.academy.homework5.task9.beans.Student;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class Task9Test extends BaseTest {

    @Test
    public void qualifyingTask() {
        Student student = (Student) context.getBean("student");

        assertNotNull(student.getContactInformation());
    }
}