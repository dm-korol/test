package com.dps.vo;

import lombok.Data;

@Data
public class WeatherHistoryVO {

    Long date;
    Double p;
    Double hag;
    Double tsmax;
    Double tsmin;
    Double t0max;
    Double t0min;
}
