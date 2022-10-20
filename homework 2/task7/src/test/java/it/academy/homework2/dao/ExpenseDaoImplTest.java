package it.academy.homework2.dao;

import it.academy.homework2.datasource.MysqlJdbcDataSource;
import it.academy.homework2.model.Expense;
import it.academy.homework2.model.Receiver;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ExpenseDaoImplTest {
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
        Expense expense = new Expense();
        Receiver receiver = new Receiver();
        ExpenseDaoImpl expenseDao = new ExpenseDaoImpl(mysqlJdbcDataSource);
        ReceiverDaoImpl receiverDao = new ReceiverDaoImpl(mysqlJdbcDataSource);

        Connection connection = mysqlJdbcDataSource.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("select count(*) from Expenses;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        expense.setAmount(100);
        expense.setDate(LocalDate.now());

        receiver.setName("Test");
        receiverDao.create(receiver);

        expense.setReceiverId(receiverDao.getId(receiver));
        expenseDao.create(expense);


        rs = connection.createStatement().executeQuery("select count(*) from Expenses;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        connection.createStatement().executeUpdate("TRUNCATE TABLE Expenses;");
        connection.createStatement().executeUpdate("TRUNCATE TABLE Receivers;");
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        connection.close();
    }

    @Test
    @SneakyThrows
    public void testReadAll() {
        // Given
        Expense expense = new Expense();
        Receiver receiver = new Receiver();
        ExpenseDaoImpl expenseDao = new ExpenseDaoImpl(mysqlJdbcDataSource);
        ReceiverDaoImpl receiverDao = new ReceiverDaoImpl(mysqlJdbcDataSource);

        Connection connection = mysqlJdbcDataSource.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("select count(*) from Expenses;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        for (int i = 0; i < 10; i++) {
            expense.setAmount(i);
            expense.setDate(LocalDate.now());

            receiver.setName("Test" + i);
            receiverDao.create(receiver);

            expense.setReceiverId(receiverDao.getId(receiver));

            // When
            expenseDao.create(expense);
        }

        // Then
        assertEquals(10, expenseDao.readAll().size());
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
        connection.createStatement().executeUpdate("truncate table Expenses;");
        connection.createStatement().executeUpdate("truncate table Receivers;");
        connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        connection.close();
    }

}