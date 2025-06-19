package com.manohar.service;

import com.manohar.entity.CustomerDTO;

public interface UserLogIn {
	
	public String logIntoAccount(CustomerDTO userDto);
	
	public String logOutFromAccount(String key);
}
