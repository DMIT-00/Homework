package it.academy.homework7.dao;

import it.academy.homework7.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void create(Car car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public Car findById(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public List<Car> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Car", Car.class).list();
    }

    @Override
    public void update(Car car) {
        create(car);
    }

    @Override
    public void delete(Car car) {
        Car loadedCar = sessionFactory.getCurrentSession().load(Car.class, car.getId());
        sessionFactory.getCurrentSession().delete(loadedCar);
    }
}
