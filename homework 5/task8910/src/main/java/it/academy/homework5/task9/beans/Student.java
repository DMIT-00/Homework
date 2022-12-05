package it.academy.homework5.task9.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
public class Student {
    @Autowired
    @ContactAnnotated
    ContactInformation contactInformation;
}
