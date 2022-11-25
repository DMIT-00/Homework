package it.academy.homework4.vehicle.dao;

import it.academy.homework4.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
public class VehicleDaoImpl implements VehicleDao {
    SessionFactory sessionFactory;

    @Override
    public void create(Vehicle vehicle) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Vehicle> finaAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Vehicle", Vehicle.class).list();
        }
    }
}
