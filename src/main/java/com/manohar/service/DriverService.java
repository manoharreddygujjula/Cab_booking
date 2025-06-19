package com.manohar.service;

import java.util.List;

import com.manohar.entity.Driver;
import com.manohar.exception.DriverNotFoundException;
import com.manohar.exception.InvalidId;

public interface DriverService {
public Driver insertDriver(Driver driver);
public Driver viewDriverById(Integer id) throws InvalidId;
public Driver updateDriver(Integer id,Integer license, Boolean available)throws DriverNotFoundException;
public String deleteDriverById(Integer id)throws DriverNotFoundException;
public List<Driver> viewBestDriver()throws DriverNotFoundException;
}
