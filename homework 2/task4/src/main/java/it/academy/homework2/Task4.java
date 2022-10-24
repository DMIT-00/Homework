package it.academy.homework2;

import it.academy.homework2.datasource.MysqlJdbcDataSource;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Task4 {
    public static void main(String[] args) {
        MysqlJdbcDataSource mysqlJdbcDataSource = new MysqlJdbcDataSource();
        Database database = new Database(mysqlJdbcDataSource);

        if (!addToDatabase(args, database)) {
            System.out.println("Error occurred when adding to the database!");
        }

        database.printEverything();
    }

    static boolean addToDatabase(String[] args, Database database) {
        if (args.length != 3) {
            System.out.println("Usage: " + Task4.class.getSimpleName() + " <date> <receiver> <amount>");
            return false;
        }

        LocalDate date;

        try {
            date = LocalDate.parse(args[0]);
        } catch (DateTimeException e) {
            System.out.println("Can't parse argument 1 as date, please use a valid format! Valid format is (xxxx-xx-xx). Data won't be added to the database.");
            return false;
        }

        String receiver = args[1];
        if (!receiver.matches("[A-Za-z0-9-]+")) {
            System.out.println("Receiver name can only contain letters, digits and '-' symbol. Data won't be added to the database.");
            return false;
        }

        double amount;

        try {
            amount = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Can't parse argument 3 as double, please use a valid format! Data won't be added to the database.");
            return false;
        }

        return database.add(date, receiver, amount);
    }
}
