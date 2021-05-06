package com.dps.service;

import com.dps.algorithms.SoilTypeAlgorithm;
import com.dps.entity.Crop;
import com.dps.entity.Field;
import com.dps.entity.SoilHumidity;
import com.dps.repository.CropRepository;
import com.dps.repository.FieldRepository;
import com.dps.repository.SoilHumidityRepository;
import com.dps.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

import static com.dps.helpers.SoilPropertiesRequest.getSoil;

@Service
public class DpsService {

    private FieldRepository fieldRepository;
    private CropRepository cropRepository;
    private SoilHumidityRepository soilHumidityRepository;

    @Autowired
    public DpsService(FieldRepository fieldRepository, CropRepository cropRepository, SoilHumidityRepository soilHumidityRepository) {
        this.fieldRepository = fieldRepository;
        this.cropRepository = cropRepository;
        this.soilHumidityRepository = soilHumidityRepository;
    }

    public ResponseEntity<String> addField(FieldVO vo) {
        // part #1 - get soil data from http://rest.isric.org/soilgrids/v2.0/docs
        // ERROR 422
        if (Objects.isNull(vo.getFieldId()))
            return ResponseEntity.status(422).body("Field Id is null");
        if (Objects.isNull(vo.getLongitude()))
            return ResponseEntity.status(422).body("Longitude is null");
        if (Objects.isNull(vo.getLatitude()))
            return ResponseEntity.status(422).body("Latitude is null");
        if (vo.getLongitude() > 180) { // long <= 180
            return ResponseEntity.status(422).body("Longitude can't be more than 180");
        }
        if (vo.getLatitude() > 90) {// lat <=90
            return ResponseEntity.status(422).body("Latitude can't be more than 90");
        }
        SoilPropsVO soilPropsVO = getSoil(vo.getLongitude(), vo.getLatitude());

        // TODO: check - create Algorithm for determining the type of soil
        // part #2
        // call Algorithm for determining the type of soil

        // TODO: check - is this class should be marked as spring component
        SoilTypeAlgorithm.determineSoilType();


        if (!fieldRepository.findAllById(Collections.singleton(vo.getFieldId())).isEmpty()) {
            return ResponseEntity.status(409).body("Field is already exists");
        }
        Field field = new Field();

        field.setLongitude(vo.getLongitude());
        field.setLatitude(vo.getLatitude());
        field.setFieldId(vo.getFieldId());

        // TODO: this field should be filled with result of the algorithm work
        // field.setSoilType("empty");

        // TODO: this record contains data about soil humidity requested by id

        SoilHumidity soilRecord = soilHumidityRepository.getOne(3);
        fieldRepository.save(field);


        if (fieldRepository.findAllById(Collections.singleton(field.getFieldId())).isEmpty()) // if after save repository FieldRepository with new id is Empty
            return ResponseEntity.status(503).body("Field Repository is not connected (Data didn't be saved to the repository)");
        return ResponseEntity.status(201).body("Field created"); // if all check is fine
    }


    public ResponseEntity<String> addCrop(CropVO vo) {
        Crop crop = new Crop();
        crop.setFieldId(vo.getFieldId());
        crop.setStartDate(vo.getStartDate());
        crop.setCulture(vo.getCulture());
        crop.setType(vo.getType());
        crop.setCurrentStage(vo.getCurrentStage());
        crop.setDepth(vo.getDepth());
        crop.setFngcd(vo.getFngcd());
        crop.setRate(vo.getRate());
        crop.setStrt(vo.getStrt());
        crop.setPod(vo.getPod());

        cropRepository.save(crop);
        return ResponseEntity.status(201).body("Crop created"); // if all check is fine
    }

    public ResponseEntity<String> getCrop(Integer id) {
        return ResponseEntity.status(200).body("Crop data"); // if all check is fine
    }


    public ResponseEntity<String> checkDatabases() {
        if (soilHumidityRepository.findAll().isEmpty()) {
            return ResponseEntity.status(503).body("Soil Humidity Repository is empty");
        }
        return ResponseEntity.status(200).body("Everything is ok");
    }
}
