package it.academy.homework2.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Expense implements Serializable {
    int id;
    LocalDate date;
    int receiverId;
    double amount;
}