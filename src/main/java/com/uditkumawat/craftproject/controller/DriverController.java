package com.uditkumawat.craftproject.controller;

import com.uditkumawat.craftproject.exception.NoSuchDriverExistsException;
import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@Validated
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;

    @PostMapping("/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver add(@Valid @RequestBody Driver driver){
        logger.info("Got Driver data {} for saving ",driver);
        try {
            return driverService.save(driver);
        }catch(Exception ex){
            throw ex;
        }
    }

    @GetMapping("/driver/{id}")
    public Driver get(@PathVariable("id")long id) throws NoSuchDriverExistsException {
        logger.info("Get Driver data for id {}",id);
        try {
            return driverService.get(id);
        }catch(Exception ex){
            throw ex;
        }
    }

}
