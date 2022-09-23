package com.uditkumawat.craftproject.controller;

import com.uditkumawat.craftproject.exception.EmailAlreadyExistsException;
import com.uditkumawat.craftproject.exception.NoSuchDriverExistsException;
import com.uditkumawat.craftproject.model.Driver;
import com.uditkumawat.craftproject.service.DriverService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DriverControllerTest {

    @Mock
    private DriverService driverService;

    @InjectMocks
    private DriverController driverController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); //without this you will get NPE
    }

    @Test
    public void add_whenEmailAlreadyExists() throws EmailAlreadyExistsException {

        Driver driver = new Driver();
        driver.setEmail("udit.kumawat@gmail.com");

        Mockito.when(driverService.save(driver)).thenThrow(new EmailAlreadyExistsException("Driver already exists with this emailId"));

        Exception exception = assertThrows(EmailAlreadyExistsException.class,()->{
            driverController.add(driver);
        });

        assertEquals(exception.getMessage(),"Driver already exists with this emailId");
    }

    @Test
    public void add() throws EmailAlreadyExistsException {

        Driver driver = new Driver();
        driver.setEmail("udit.kumawat@gmail.com");

        Mockito.when(driverService.save(driver)).thenReturn(driver);

        assertNotNull(driverController.add(driver));
    }

    @Test
    public void get() throws NoSuchDriverExistsException {

        Mockito.when(driverService.get(1)).thenThrow(new NoSuchDriverExistsException("No driver exists with id"));

        Exception exception = assertThrows(NoSuchDriverExistsException.class,()->{
            driverController.get(1);
        });

        assertEquals(exception.getMessage(),"No driver exists with id");
    }

}
