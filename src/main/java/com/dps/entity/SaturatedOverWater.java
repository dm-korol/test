package com.dps.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "saturated_over_water")
public class SaturatedOverWater {

    @Id
    @Column(name = "temp")
    private Integer temperature;

    @Column(name = "zero")
    private Float zero;

    @Column(name = "one")
    private Float one;

    @Column(name = "two")
    private Float two;

    @Column(name = "three")
    private Float three;

    @Column(name = "four")
    private Float four;

    @Column(name = "five")
    private Float five;

    @Column(name = "six")
    private Float six;

    @Column(name = "seven")
    private Float seven;

    @Column(name = "eight")
    private Float eight;

    @Column(name = "nine")
    private Float nine;
}
