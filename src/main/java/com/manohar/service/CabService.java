package com.manohar.service;

import java.util.List;

import com.manohar.entity.Cab;
import com.manohar.exception.NotFoundException;


public interface CabService {

public Cab updateCab(Integer id,String type, Integer rate) throws NotFoundException;
	
	public List<String> viewCabsOfType() throws NotFoundException;
	public int countCabsOfType() throws NotFoundException;
	
}

