package com.manohar.service;



import java.util.List;

import com.manohar.entity.Customer;
import com.manohar.exception.InvalidId;
import com.manohar.exception.Nullexception;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	public Customer findCustomer(Integer id)throws InvalidId;
	public Customer updateCustomer(Customer customer,Integer id)throws InvalidId;
	public String deleteCustomer(Integer id)throws InvalidId;
	public List<Customer> allCustomer()throws Nullexception;
	public Customer vaildCustomer(String Email,String Password)throws InvalidId;
	
}
