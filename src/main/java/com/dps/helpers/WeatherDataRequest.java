package com.dps.helpers;

import com.dps.entity.SaturatedOverWater;
import com.dps.repository.SaturatedOverWaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Component
public class WeatherDataRequest {

    private static SaturatedOverWaterRepository saturatedOverWaterRepository;

    @Autowired
    public WeatherDataRequest(SaturatedOverWaterRepository saturatedOverWaterRepository) {
        WeatherDataRequest.saturatedOverWaterRepository = saturatedOverWaterRepository;
    }

    public static double getVaporPressureForTemperature(double t) {

        // Get int key for database table from temperature before dot
        int key = (int) t;

        // Get value key from first digit after dot
        double absTemp = Math.abs(t);
        double doubleKey = Math.abs(key);
        double tenth = absTemp - doubleKey;
        int valueKey = (int) (tenth * 10);

        // Vapor pressure value from static tale
        float result = 0.0f;
        Optional<SaturatedOverWater> byId = saturatedOverWaterRepository.findById(key);

        SaturatedOverWater data = byId.get();

        switch (valueKey) {
            case 0:
                result = data.getZero();
                break;
            case 1:
                result = data.getOne();
                break;
            case 2:
                result = data.getTwo();
                break;
            case 3:
                result = data.getThree();
                break;
            case 4:
                result = data.getFour();
                break;
            case 5:
                result = data.getFive();
                break;
            case 6:
                result = data.getSix();
                break;
            case 7:
                result = data.getSeven();
                break;
            case 8:
                result = data.getEight();
                break;
            case 9:
                result = data.getNine();
                break;
        }

        // Trim number to three digits after dot
        BigDecimal bd = new BigDecimal(Double.toString( result ));
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        double resultTrimmed = bd.doubleValue();

        return resultTrimmed;
    }


}
