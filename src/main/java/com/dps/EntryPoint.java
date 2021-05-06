package com.dps;

import com.dps.helpers.WeatherDataRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootApplication
public class EntryPoint extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EntryPoint.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EntryPoint.class, args);

        // TODO: this is for testing purposes, TO REMOVE
//        double e = WeatherDataRequest.getVaporPressureForTemperature(-12.5);
//
//        System.out.println("#####################################################################");
//        System.out.println("E = " + e);
//        System.out.println("#####################################################################");
//
//        BigDecimal bd = new BigDecimal(Double.toString(e));
//        bd = bd.setScale(3, RoundingMode.HALF_UP);
//        double vE = bd.doubleValue();
//
//        System.out.println("#####################################################################");
//        System.out.println("E = " + vE);
//        System.out.println("#####################################################################");

    }
}
