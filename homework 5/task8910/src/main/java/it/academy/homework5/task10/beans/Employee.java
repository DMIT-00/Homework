package it.academy.homework5.task10.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class Employee {
    private double salary;
}
