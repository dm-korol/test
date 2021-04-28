package com.dps.controller;

import com.dps.service.DpsService;
import com.dps.vo.CropVO;
import com.dps.vo.FieldVO;
import com.dps.vo.SoilPropsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class DpsController {

    private final DpsService dpsService;

    @Autowired
    public DpsController(DpsService dpsService) {
        this.dpsService = dpsService;
    }

    /*
     *   parameters:
     *   lon - field longitude
     *   lat - field latitude
     *  id - field id
     */
    @PostMapping(path = "/field")
    public SoilPropsVO addField(@RequestBody FieldVO fieldVO) {
        SoilPropsVO res = dpsService.addField(fieldVO);
        return res;
    }

    @PostMapping(path = "/crop")
    public void addCrop(@RequestBody CropVO cropVO) {
        dpsService.addCrop(cropVO);
    }

    @GetMapping(path = "/crop/{id}")
    public CropVO getCrop(@PathVariable("id") Integer id) {
        return dpsService.getCrop(id);
    }

    @GetMapping(path = "/live")
    public HttpStatus getStatus() {

        // TODO: examples:
        // 200
        HttpStatus statusOk = HttpStatus.OK;

        // 503
        HttpStatus statusUnavailable = HttpStatus.SERVICE_UNAVAILABLE;

        return statusOk;
    }
}
