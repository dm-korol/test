package com.dps.controller;

import com.dps.service.DpsService;
import com.dps.vo.CropVO;
import com.dps.vo.FieldVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class DpsController {

    private final DpsService dpsService;

    @Autowired
    public DpsController(DpsService dpsService) {
        this.dpsService = dpsService;
    }

    @PostMapping(path = "/field")
    public ResponseEntity<String> addField(@RequestBody FieldVO fieldVO) {
        return dpsService.addField(fieldVO);
    }

    @PostMapping(path = "/crop")
    public ResponseEntity<String> addCrop(@RequestBody CropVO cropVO) {
        return dpsService.addCrop(cropVO);
    }

    @GetMapping(path = "/crop/{id}")
    public ResponseEntity<String> getCrop(@PathVariable("id") Integer id) {
        return dpsService.getCrop(id);
    }

    @GetMapping(path = "/live")
    public ResponseEntity<String> getStatus() {
        return dpsService.checkDatabases();
    }
}
