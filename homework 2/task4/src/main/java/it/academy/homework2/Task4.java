package it.academy.homework2;

import it.academy.homework2.dao.ExpenseDaoImpl;
import it.academy.homework2.dao.ReceiverDaoImpl;
import it.academy.homework2.model.Expense;
import it.academy.homework2.model.Receiver;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        Expense expense = new Expense();
        Receiver receiver = new Receiver();
        ExpenseDaoImpl expenseDao = new ExpenseDaoImpl();
        ReceiverDaoImpl receiverDao = new ReceiverDaoImpl();


        if (parseArguments(args, expense, receiver)) {
            receiverDao.create(receiver);

            expense.setReceiverId(receiverDao.getId(receiver));
            expenseDao.create(expense);
        }

        List<Expense> expenses = expenseDao.readAll();
        Map<Integer, String> receivers = receiverDao.readAll().stream()
                .collect(Collectors.toMap(Receiver::getId, Receiver::getName));

        System.out.printf("%-4s %-12s %-40s %s\n", "id", "date", "receiver", "amount");
        System.out.println("----------------------------------------------------------------------");
        for (Expense ex : expenses) {
            String receiverName = receivers.getOrDefault(ex.getReceiverId(), "[no data]");
            System.out.printf("%-4d %-12s %-40s %.2f\n", ex.getId(), ex.getDate(), receiverName, ex.getAmount());
        }
    }

    static boolean parseArguments(String[] args, Expense expense, Receiver receivers) {
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

        double amount;

        try {
            amount = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Can't parse argument 3 as double, please use a valid format! Data won't be added to the database.");
            return false;
        }

        expense.setDate(date);
        expense.setAmount(amount);
        receivers.setName(receiver);

        return true;
    }
}
