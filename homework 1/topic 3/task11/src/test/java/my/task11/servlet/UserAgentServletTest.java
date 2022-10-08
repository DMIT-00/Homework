package my.task11.servlet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class UserAgentServletTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/ua_test.csv", numLinesToSkip = 1)
    void getBrowserName(String input, String expected) {
        assertEquals(expected, UserAgentServlet.getBrowserName(input));
    }
}