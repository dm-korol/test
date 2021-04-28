package com.dps.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "crop")
public class Crop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "field_id")
    private Integer fieldId;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "culture")
    private String culture;

    @Column(name = "type")
    private String type;

    @Column(name = "current_stage")
    private Integer currentStage;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "fngcd")
    private Boolean fngcd;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "strt")
    private Integer strt;

    @Column(name = "pod")
    private Integer pod;
}
