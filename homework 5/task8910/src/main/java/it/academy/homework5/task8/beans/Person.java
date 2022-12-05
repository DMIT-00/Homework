package it.academy.homework5.task8.beans;

import it.academy.homework5.base.beans.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
public class Person {
    @Autowired
    Car car;
}
