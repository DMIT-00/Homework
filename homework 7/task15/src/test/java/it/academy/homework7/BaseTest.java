package it.academy.homework7;

import it.academy.homework7.config.DataConfig;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:/application-test.properties")
@ContextConfiguration(classes = DataConfig.class)
public class BaseTest {
    static ApplicationContext context;
    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("spring.xml");
    }
}
