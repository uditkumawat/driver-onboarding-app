package com.uditkumawat.craftproject.controller;

import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;

    @PostMapping("/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver add(@Valid @RequestBody Driver driver){
        logger.info("Save Driver data {}",driver);
        return driverService.save(driver);
    }

    @GetMapping("/driver/{id}")
    public Driver get(@PathVariable("id")long id){
        logger.info("Get Driver data for id {}",id);
        return driverService.get(id);
    }

}
