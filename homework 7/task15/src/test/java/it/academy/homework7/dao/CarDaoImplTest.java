package it.academy.homework7.dao;

import it.academy.homework7.BaseTest;
import it.academy.homework7.config.DataConfig;
import it.academy.homework7.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarDaoImplTest extends BaseTest {
    @Autowired
    CarDao carDao;

    @Test
    public void create() {
        int initialSize = carDao.findAll().size();

        Car car = new Car(null, "Mercedes");
        carDao.create(car);

        int resultSize = carDao.findAll().size();
        assertEquals(initialSize + 1, resultSize);
    }

    @Test
    public void findById() {
        Car car = new Car(null, "KIA");
        carDao.create(car);

        Long id = car.getId();

        Car returnedCar = carDao.findById(id);

        assertEquals(car.getName(), returnedCar.getName());
    }

    @Test
    public void findAll() {
        int initialSize = carDao.findAll().size();

        Car car = new Car(null, "Mercedes");
        carDao.create(car);

        car.setId(null);
        car.setName("BMW");
        carDao.create(car);

        int resultSize = carDao.findAll().size();
        assertEquals(initialSize + 2, resultSize);
    }

    @Test
    public void update() {
        Car car = new Car(null, "Mercedes");
        carDao.create(car);

        car.setName("KIA");
        carDao.update(car);

        Car returnedCar = carDao.findById(car.getId());

        assertEquals("KIA", returnedCar.getName());
    }

    @Test
    public void delete() {
        Car car = new Car(null, "Mercedes");
        carDao.create(car);

        int initialSize = carDao.findAll().size();

        carDao.delete(car);

        int resultSize = carDao.findAll().size();
        assertEquals(initialSize - 1, resultSize);
    }
}