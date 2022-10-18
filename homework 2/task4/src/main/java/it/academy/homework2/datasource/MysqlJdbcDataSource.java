package it.academy.homework2.datasource;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MysqlJdbcDataSource {
    final static String DEFAULT_PROPERTIES_FILE = "expenses.jdbc.properties";

    private final Properties properties;

    public MysqlJdbcDataSource() {
        this(DEFAULT_PROPERTIES_FILE);
    }

    @SneakyThrows
    public MysqlJdbcDataSource(String propertiesFile) {
        properties = new Properties();
        properties.load(MysqlJdbcDataSource.class.getClassLoader().getResourceAsStream(propertiesFile));

        Class.forName(properties.getProperty("driver"));
    }

    @SneakyThrows
    public Connection getConnection() {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }
}