package it.academy.homework2.dao;

import it.academy.homework2.datasource.MysqlJdbcDataSource;
import it.academy.homework2.model.Receiver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiverDaoImpl implements Dao<Receiver> {
    MysqlJdbcDataSource mysqlJdbcDataSource;

    public ReceiverDaoImpl() {
        this.mysqlJdbcDataSource = new MysqlJdbcDataSource();
    }

    @Override
    public void create(Receiver receiver) {
        Connection connection;
        String statement = "INSERT IGNORE INTO Receivers (name) VALUES(?)";

        try {
            connection = mysqlJdbcDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, receiver.getName());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Receiver> readAll() {
        List<Receiver> receivers = new ArrayList<>();
        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM Receivers");
            while (resultSet.next()) {
                final Receiver receiver = new Receiver();
                receiver.setId(resultSet.getInt("id"));
                receiver.setName(resultSet.getString("name"));
                receivers.add(receiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receivers;
    }

    public int getId(Receiver receiver) {
        int id = 0;

        try {
            final Connection connection = mysqlJdbcDataSource.getConnection();
            String statement = "SELECT id FROM Receivers WHERE name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, receiver.getName());
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
