package it.academy.homework2.dao;

import it.academy.homework2.datasource.MysqlJdbcDataSource;
import it.academy.homework2.model.Receiver;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;

public class ReceiverDaoImplTest {
    MysqlJdbcDataSource mysqlJdbcDataSource;

    @Before
    public void setUp() {
        mysqlJdbcDataSource = new MysqlJdbcDataSource("expenses-test.jdbc.properties");
    }

    @After
    public void tearDown() {
        mysqlJdbcDataSource = null;
    }

    @Test
    @SneakyThrows
    public void testCreate() {
        Receiver receiver = new Receiver();
        ReceiverDaoImpl receiverDao = new ReceiverDaoImpl(mysqlJdbcDataSource);

        Connection connection = mysqlJdbcDataSource.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("select count(*) from Receivers;");
        rs.next();
        int initialSize = rs.getInt(1);
        Assert.assertEquals(0, initialSize);

        receiver.setName("Test");
        receiverDao.create(receiver);

        rs = connection.createStatement().executeQuery("select count(*) from Receivers;");
        rs.next();
        int actualSize = rs.getInt(1);
        Assert.assertEquals(1, actualSize);
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        connection.createStatement().executeUpdate("truncate table Expenses;");
        connection.createStatement().executeUpdate("truncate table Receivers;");
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        connection.close();
    }

    @Test
    @SneakyThrows
    public void testReadAll() {
        // Given
        Receiver receiver = new Receiver();
        ReceiverDaoImpl receiverDao = new ReceiverDaoImpl(mysqlJdbcDataSource);

        Connection connection = mysqlJdbcDataSource.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("select count(*) from Receivers;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        for (int i = 0; i < 10; i++) {
            receiver.setName("Test" + i);
            receiverDao.create(receiver);

            // When
            receiverDao.create(receiver);
        }

        // Then
        assertEquals(10, receiverDao.readAll().size());
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        connection.createStatement().executeUpdate("truncate table Expenses;");
        connection.createStatement().executeUpdate("truncate table Receivers;");
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        connection.close();
    }

    @Test
    @SneakyThrows
    public void testGetId() {
        Receiver receiver = new Receiver();
        ReceiverDaoImpl receiverDao = new ReceiverDaoImpl(mysqlJdbcDataSource);

        Connection connection = mysqlJdbcDataSource.getConnection();

        receiver.setName("Test");

        Assert.assertEquals(0, receiverDao.getId(receiver));

        receiverDao.create(receiver);
        Assert.assertTrue(receiverDao.getId(receiver) != 0);

        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        connection.createStatement().executeUpdate("truncate table Expenses;");
        connection.createStatement().executeUpdate("truncate table Receivers;");
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        connection.close();
    }
}