package it.academy.homework5.base.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car {

    private String name;
    private int year;

    public static Car getInstance() {
        return new Car();
    }
}
