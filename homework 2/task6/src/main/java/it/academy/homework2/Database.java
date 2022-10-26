package it.academy.homework2;

import it.academy.homework2.datasource.MysqlJdbcDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String query = "SELECT date,SUM(`amount`) FROM Expenses GROUP BY date order by MAX(`amount`) DESC LIMIT 1;";

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getDouble(2));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printMaxExpenseBiggestDay() {
        String query = "SELECT date,MAX(`amount`) FROM Expenses GROUP BY date order by SUM(`amount`) DESC LIMIT 1;";

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getDouble(2));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
