package com.dps.vo;

import lombok.Data;

import java.util.List;

@Data
public class SoilPropsVO {

    private List<Integer> siltValues;
    private List<Integer> clayValues;
    private List<Integer> sandValues;
}
