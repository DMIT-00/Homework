package it.academy.homework2;

import it.academy.homework2.datasource.MysqlJdbcDataSource;

public class Task6 {
    public static void main(String[] args) {
        MysqlJdbcDataSource mysqlJdbcDataSource = new MysqlJdbcDataSource();
        Database database = new Database(mysqlJdbcDataSource);

        System.out.println("Список получателей платежей, и сумма платежей по каждому из них:");
        database.printListOfReceivers();

        System.out.println();

        System.out.println("Сумма платежей за тот день, когда был наибольший платеж:");
        database.printSumMaxDay();

        System.out.println();

        System.out.println("Наибольший платеж за тот день, когда сумма платежей была наибольшей:");
        database.printMaxExpenseBiggestDay();
    }
}
