package com.uditkumawat.craftproject.controller;

import com.uditkumawat.craftproject.exception.EmailAlreadyExistsException;
import com.uditkumawat.craftproject.exception.NoSuchDriverExistsException;
import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for handling all API request related to driver
 */
@RestController
@Validated
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;

    @PostMapping("/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver add(@Valid @RequestBody Driver driver) throws EmailAlreadyExistsException {
        logger.info("Got Driver data {} for saving into DB ",driver);
        try {
            return driverService.save(driver);
        }catch(Exception ex){
            logger.error("Exception occurred while inserting driver details {}",driver);
            throw ex;
        }
    }

    @GetMapping("/driver/{driverId}")
    public Driver get(@PathVariable("driverId")long driverId) throws NoSuchDriverExistsException {
        logger.info("Getting Driver profile for driverId {}",driverId);
        try {
            return driverService.get(driverId);
        }catch(Exception ex){
            logger.error("Exception occurred while getting driver details for driverId - {}",driverId);
            throw ex;
        }
    }

    @PutMapping("/driver/{driverId}/markActive")
    public Driver markActive(@PathVariable("driverId") long driverId) throws NoSuchDriverExistsException{
        logger.info("Marking driverId - {} active",driverId);
        try{
            return driverService.markActive(driverId);
        }catch(Exception ex){
            logger.error("Exception while marking driver profile to Active for driverId - {}",driverId);
            throw ex;
        }
    }

    @PutMapping("/driver/{driverId}/documentsVerified")
    public Driver setVerifiedFlag(@PathVariable("driverId") long driverId) throws NoSuchDriverExistsException{
        logger.info("Setting isVerified flag for driverId - {}",driverId);
        try{
            return driverService.setVerifiedFlag(driverId);
        }catch(Exception ex){
            logger.error("Exception while marking isVerified flag for driverId - {}",driverId);
            throw ex;
        }
    }

}
