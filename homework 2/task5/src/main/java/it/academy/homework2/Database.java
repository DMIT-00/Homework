package it.academy.homework2;

import it.academy.homework2.datasource.MysqlJdbcDataSource;

import java.sql.*;
import java.time.LocalDate;

public class Database {
    MysqlJdbcDataSource mysqlJdbcDataSource;

    public Database(MysqlJdbcDataSource mysqlJdbcDataSource) {
        this.mysqlJdbcDataSource = mysqlJdbcDataSource;
    }

    public boolean add(LocalDate date, String receiver, double amount) {
        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            String statement = "INSERT INTO Expenses (date, receiver, amount) VALUES(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setDate(1, Date.valueOf(date));
            preparedStatement.setString(2, receiver);
            preparedStatement.setDouble(3, amount);
            preparedStatement.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void printEverything() {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-6s %-12s %-40s %s\n", "id", "date", "receiver", "amount");
        System.out.println("----------------------------------------------------------------------");

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Expenses");
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%-6d %-12s %-40s %.2f\n", resultSet.getInt("id"),
                        resultSet.getDate("date").toLocalDate(), resultSet.getString("receiver"),
                        resultSet.getDouble("amount"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
