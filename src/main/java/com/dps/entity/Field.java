package com.dps.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "field")
public class Field {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "soil_type")
    private String soilType;
}
