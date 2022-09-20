package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.exception.EmailAlreadyExistsException;
import com.uditkumawat.craftproject.exception.NoSuchDriverExistsException;
import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    private static final Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);

    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver save(Driver driver) {
        Driver driverDB = driverRepository.findByEmail(driver.getEmail());
        if(driverDB!=null) {
            logger.error("Driver with same email already exists {}",driverDB.getEmail());
            throw new EmailAlreadyExistsException("Driver already exists with this emailId");
        }
        logger.info("Inserting driver details into DB {}",driver);
        return driverRepository.save(driver);
    }

    @Override
    public Driver get(long id) throws NoSuchDriverExistsException{

        Optional<Driver> opt = driverRepository.findById(id);
        if(opt.isPresent()){
            logger.info("Got driver details {} with id {} ",opt.get(),id);
            return opt.get();
        }
        else{
            logger.error("No such driver exists with id {}",id);
            throw new NoSuchDriverExistsException("No driver exists with id "+id);
        }
    }

    @Override
    public Driver markActive(long driverId) throws NoSuchDriverExistsException{

        Optional<Driver> opt = driverRepository.findById(driverId);
        if(opt.isPresent()){
            logger.info("Got driver details {} with id {} ",opt.get(),driverId);
            Driver driver = opt.get();
            driver.setActive(true);
            logger.info("Updating driver - {} to be active for accepting rides",driverId);
            return driverRepository.save(driver);
        }
        else{
            logger.error("No such driver exists with id {}",driverId);
            throw new NoSuchDriverExistsException("No driver exists with id "+driverId);
        }
    }

    @Override
    public Driver setVerifiedFlag(long driverId) throws NoSuchDriverExistsException{

        Optional<Driver> opt = driverRepository.findById(driverId);
        if(opt.isPresent()){
            logger.info("Got driver details {} with id {} ",opt.get(),driverId);
            Driver driver = opt.get();
            driver.setVerified(true);
            logger.info("Updating driver - {} to be verified",driverId);
            return driverRepository.save(driver);
        }
        else{
            logger.error("No such driver exists with id {}",driverId);
            throw new NoSuchDriverExistsException("No driver exists with id "+driverId);
        }
    }

    @Override
    public Driver setDocumentsUploadedFlag(long driverId) throws NoSuchDriverExistsException{

        Optional<Driver> opt = driverRepository.findById(driverId);
        if(opt.isPresent()){
            logger.info("Got driver details {} with id {} ",opt.get(),driverId);
            Driver driver = opt.get();
            driver.setDocumentsUploaded(true);
            logger.info("Updating driver - {} ",driverId);
            return driverRepository.save(driver);
        }
        else{
            logger.error("No such driver exists with id {}",driverId);
            throw new NoSuchDriverExistsException("No driver exists with id "+driverId);
        }
    }
}
