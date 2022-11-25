package it.academy.homework4.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final String HIBERNATE_CFG_DEFAULT_FILENAME = "hibernate.cfg.xml";
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(String hibernateCfgFilename) {
        try {
            return new Configuration().configure(hibernateCfgFilename).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("build SeesionFactory failed :" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return getSessionFactory(HIBERNATE_CFG_DEFAULT_FILENAME);
    }

    public static SessionFactory getSessionFactory(String hibernateCfgFilename) {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory(hibernateCfgFilename);
        }
        return sessionFactory;
    }
}
