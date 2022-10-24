package it.academy.homework2;

import it.academy.homework2.datasource.MysqlJdbcDataSource;

import java.sql.*;
import java.time.LocalDate;

public class Database {
    MysqlJdbcDataSource mysqlJdbcDataSource;

    public Database(MysqlJdbcDataSource mysqlJdbcDataSource) {
        this.mysqlJdbcDataSource = mysqlJdbcDataSource;
    }

    public void printListOfReceivers() {
        String query = "SELECT receiver, sum(amount) FROM Expenses GROUP BY receiver;";

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("receiver") + " " + resultSet.getDouble("sum(amount)"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSumMaxDay() {
        // TODO: Implement
        String query = "SELECT receiver,amount FROM Expenses";

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("receiver") + " " + resultSet.getDouble("amount"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printMaxExpenseBiggestDay() {
        // TODO: Implement
        String query = "SELECT receiver,amount FROM Expenses";

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("receiver") + " " + resultSet.getDouble("amount"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
