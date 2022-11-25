package it.academy.homework4.vehicle.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CAR")
@PrimaryKeyJoinColumn(name = "VEHICLE_ID")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@SuperBuilder
public class Car extends Vehicle {
    @Column
    private double maxSpeed;

    @Column
    private String color;
}
