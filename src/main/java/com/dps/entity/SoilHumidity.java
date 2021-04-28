package com.dps.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "soil_humidity")
public class SoilHumidity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "soil_name")
    private String soilName;

    @Column(name = "moisture")
    private Float moisture;

    @Column(name = "wilting")
    private Float wilting;

    @Column(name = "water")
    private Float water;

    @Column(name = "saturation")
    private Float saturation;
}
