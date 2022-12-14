package it.academy.homework7;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
    static ApplicationContext context;
    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("spring.xml");
    }
}
