package com.uditkumawat.craftproject.service;

import com.uditkumawat.craftproject.model.Driver;

public interface DriverService {

    Driver save(Driver driver);

    Driver get(long id);
}