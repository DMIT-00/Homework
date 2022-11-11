package it.academy.homework3.dao;

import it.academy.homework3.model.Car;
import org.hibernate.*;

import java.util.List;

public class CarDaoImpl implements CarDao {
    private final SessionFactory sessionFactory;


    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Car car) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Car> readAll() {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT c FROM Car AS c";
            return session.createQuery(query, Car.class).list();
        }
    }

    @Override
    public Car loadById(Long id) throws HibernateException {
        try (Session session = sessionFactory.openSession()) {
            Car car = session.load(Car.class, id);

            // Initialize lazy object
            Hibernate.initialize(car);

            return car;
        }
    }

    @Override
    public Car getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Car.class, id);
        }
    }

    @Override
    public void update(Car car) {
        create(car);
    }

    @Override
    public void delete(Car car) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.delete(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
