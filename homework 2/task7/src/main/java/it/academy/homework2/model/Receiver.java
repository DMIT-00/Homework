package it.academy.homework2.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Receiver implements Serializable {
    int id;
    String name;
}