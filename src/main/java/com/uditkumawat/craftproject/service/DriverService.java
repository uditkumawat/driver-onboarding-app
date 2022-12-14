package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.exception.EmailAlreadyExistsException;
import com.uditkumawat.craftproject.exception.NoSuchDriverExistsException;
import com.uditkumawat.craftproject.model.Driver;

public interface DriverService {

    Driver save(Driver driver) throws EmailAlreadyExistsException;

    Driver get(long driverId) throws NoSuchDriverExistsException;

    Driver markActive(long driverId) throws NoSuchDriverExistsException;

    Driver setVerifiedFlag(long driverId) throws NoSuchDriverExistsException;

    Driver setDocumentsUploadedFlag(long driverId) throws NoSuchDriverExistsException;
}
