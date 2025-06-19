package com.manohar.service;

import java.util.List;

import com.manohar.entity.TripBooking;
import com.manohar.exception.InvalidId;


public interface TripService {

	
	public TripBooking AddTrip(TripBooking tb);
	public List<TripBooking> alltrip();
	public TripBooking updateTrip(TripBooking tb,Integer id)throws InvalidId;
	public String deletetrip(Integer id) throws InvalidId;
	public TripBooking tripEnd(Integer id)throws InvalidId;
}
