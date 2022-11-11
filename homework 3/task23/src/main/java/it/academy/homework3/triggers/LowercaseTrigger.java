package it.academy.homework3.triggers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LowercaseTrigger {
    private static void doSqlQuery(SessionFactory sessionFactory, String query) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createNativeQuery(query).executeUpdate();
            tx.commit();
        }
    }
    public static void createManufacturerLowercaseTrigger(SessionFactory sessionFactory) {
        String sqlQuery = "CREATE TRIGGER lcase_insert BEFORE INSERT ON Cars " +
                    "FOR EACH ROW SET NEW.manufacturer = LOWER(NEW.manufacturer);";
        doSqlQuery(sessionFactory, sqlQuery);

    }

    public static void dropManufacturerLowercaseTrigger(SessionFactory sessionFactory) {
        String sqlQuery = "DROP TRIGGER lcase_insert;";
        doSqlQuery(sessionFactory, sqlQuery);
    }
}
