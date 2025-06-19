package com.manohar.service;

import java.time.LocalDate;
import java.util.List;

import com.manohar.entity.Admin;
import com.manohar.entity.TripBooking;
import com.manohar.exception.AdminExceptions;



public interface AdminService {

	public Admin saveAdmin(Admin admin) throws AdminExceptions;
	
	public Admin update(Admin admin) throws AdminExceptions;
	
	public Admin delete(Integer id) throws AdminExceptions;
	
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions;
	
	public List<TripBooking> getTripsDriverwise();
	
	public List<TripBooking> getTripsCustomerwise();
	
	public List<TripBooking> getTripsDatewise() throws AdminExceptions;
	
	public List<TripBooking> getTripsDatewiseAndCustomer(Integer customerId,LocalDate date) throws AdminExceptions;
	
	
	

}
