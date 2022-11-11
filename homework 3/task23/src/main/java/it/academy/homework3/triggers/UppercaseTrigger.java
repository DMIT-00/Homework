package it.academy.homework3.triggers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UppercaseTrigger {
    private static void doSqlQuery(SessionFactory sessionFactory, String query) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery(query).executeUpdate();
            tx.commit();
        }
    }
    public static void createManufacturerUppercaseTrigger(SessionFactory sessionFactory) {
        String sqlQuery = "CREATE TRIGGER ucase_insert BEFORE INSERT ON Cars " +
                    "FOR EACH ROW SET NEW.manufacturer = UPPER(NEW.manufacturer);";
        doSqlQuery(sessionFactory, sqlQuery);

    }

    public static void dropManufacturerUppercaseTrigger(SessionFactory sessionFactory) {
        String sqlQuery = "DROP TRIGGER ucase_insert;";
        doSqlQuery(sessionFactory, sqlQuery);
    }
}
