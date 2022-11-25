package it.academy.homework4.vehicle.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "BIKE")
@PrimaryKeyJoinColumn(name = "VEHICLE_ID")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@SuperBuilder
public class Bike extends Vehicle {
    @Column
    private BigDecimal price;

    @Column
    private String manufacturer;
}
