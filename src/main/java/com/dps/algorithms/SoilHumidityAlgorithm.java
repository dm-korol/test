package com.dps.algorithms;


import com.dps.helpers.WeatherDataRequest;

public class SoilHumidityAlgorithm {


    /*  Input data:
     *      t - average air temperature from agromonitoring.com
     *
     *
     *
     *
     *
     *
     */


    public static void determineSoilHumidity() {

        // #1 get weather and soil data:
//        double t = WeatherDataRequest.getAverageTemperature();
        double t = -12.5;
//        double f = WeatherDataRequest.getAverageRelativeHumidityOfAir();
//        double p = WeatherDataRequest.getTotalPrecipitation();
//        double H0 = WeatherDataRequest.getAverageHumidityOfSoil();

        double E = WeatherDataRequest.getVaporPressureForTemperature( t );

        // #2 get secondary input data:
//        double avp = (E * f) / 100.0;
//        double d = E - avp;
//        double EE = 140;
//        double BBC = 0; // ???
//        double EVA = 0; // ???


    }


}
