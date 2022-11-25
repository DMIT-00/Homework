package it.academy.homework4.animal.dao;

import it.academy.homework4.animal.model.Animal;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
public class AnimalDaoImpl implements AnimalDao {
    SessionFactory sessionFactory;

    @Override
    public void create(Animal animal) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(animal);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Animal> finaAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Animal", Animal.class).list();
        }
    }
}
