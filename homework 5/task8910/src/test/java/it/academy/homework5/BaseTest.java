package it.academy.homework5;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    public static ApplicationContext context;
    @BeforeClass
    public static void initializeSpringContext() {
        context = new ClassPathXmlApplicationContext("spring-beans.xml");
    }
}
