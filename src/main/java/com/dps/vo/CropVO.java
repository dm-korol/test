package com.dps.vo;

import lombok.Data;

@Data
public class CropVO {

    private Integer fieldId;
    private Long startDate;
    private String culture;
    private String type;
    private Integer currentStage;
    private Integer depth;
    private Boolean fngcd;
    private Integer rate;
    private Integer strt;
    private Integer pod;
}
