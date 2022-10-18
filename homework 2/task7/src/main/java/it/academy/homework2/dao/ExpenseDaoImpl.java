package it.academy.homework2.dao;

import it.academy.homework2.datasource.MysqlJdbcDataSource;
import it.academy.homework2.model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImpl implements Dao<Expense> {
    MysqlJdbcDataSource mysqlJdbcDataSource;

    public ExpenseDaoImpl(MysqlJdbcDataSource mysqlJdbcDataSource) {
        this.mysqlJdbcDataSource = mysqlJdbcDataSource;
    }

    @Override
    public void create(Expense expense) {
        Connection connection;
        String statement = "INSERT INTO Expenses (date, receiverId, amount) VALUES(?, ?, ?)";

        try {
            connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setDate(1, Date.valueOf(expense.getDate()));
            preparedStatement.setInt(2, expense.getReceiverId());
            preparedStatement.setDouble(3, expense.getAmount());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> readAll() {
        List<Expense> expenses = new ArrayList<>();
        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM Expenses");
            while (resultSet.next()) {
                final Expense expense = new Expense();
                expense.setId(resultSet.getInt("id"));
                expense.setReceiverId(resultSet.getInt("receiverId"));
                expense.setDate(resultSet.getDate("date").toLocalDate());
                expense.setAmount(resultSet.getDouble("amount"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
