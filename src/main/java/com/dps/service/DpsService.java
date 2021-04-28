package com.dps.service;

import com.dps.algorithms.SoilTypeAlgorithm;
import com.dps.entity.Crop;
import com.dps.entity.Field;
import com.dps.entity.SoilHumidity;
import com.dps.repository.CropRepository;
import com.dps.repository.FieldRepository;
import com.dps.repository.SoilHumidityRepository;
import com.dps.vo.CropVO;
import com.dps.vo.FieldVO;
import com.dps.vo.SoilPropsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public SoilPropsVO addField(FieldVO vo) {
        // part #1 - get soil data from http://rest.isric.org/soilgrids/v2.0/docs
        SoilPropsVO soilPropsVO = getSoil(vo.getLongitude(), vo.getLatitude());

        // TODO: check - create Algorithm for determining the type of soil
        // part #2
        // call Algorithm for determining the type of soil


        // TODO: check - is this class should be marked as spring component
        SoilTypeAlgorithm.determineSoilType();

        Field field = new Field();

        field.setLongitude(vo.getLongitude());
        field.setLatitude(vo.getLatitude());
        field.setFieldId(vo.getFieldId());

        // TODO: this field should be filled with result of the algorithm work
        // field.setSoilType("empty");

        fieldRepository.save(field);

        // TODO: this record contains data about soil humidity requested by id
        SoilHumidity soilRecord = soilHumidityRepository.getOne(3);
        return soilPropsVO;
    }



    public void addCrop(CropVO vo) {

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
    }

    public CropVO getCrop(Integer id) {


        return null;
    }
}
