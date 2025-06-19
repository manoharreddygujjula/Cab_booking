package com.manohar.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manohar.entity.CurrentUserSession;
import com.manohar.entity.Customer;
import com.manohar.entity.CustomerDTO;

import com.manohar.exception.AdminExceptions;
import com.manohar.exception.InvalidPasswordException;
import com.manohar.exception.NotFoundException;
import com.manohar.exception.UserAlreadyExistWithuserId;
import com.manohar.repository.AdminDao;
import com.manohar.repository.CustomerDao;
import com.manohar.repository.DriverDao;
import com.manohar.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private SessionDao sessionDao;

	@Override
	public String logIntoAccount(CustomerDTO userDto) {
		Optional<Customer> opt_customer = customerDao.findById(userDto.getUserId());
//		Optional<Driver> opt_driver = driverDao.findById(userDto.getUserId());
//		Optional<Admin> opt_admin = adminDao.findById(userDto.getUserId());

		Integer userId = opt_customer.get().getUserId();

		Optional<CurrentUserSession> currentUserOptional = sessionDao.findById(userId);

		if (!opt_customer.isPresent()) {
			throw new AdminExceptions("user not found");
		}
		if (currentUserOptional.isPresent()) {
			throw new UserAlreadyExistWithuserId("User already logged in with this number");
		}
		if (opt_customer.get().getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(opt_customer.get().getUserId(), key,
					LocalDateTime.now());
			sessionDao.save(currentUserSession);

			return currentUserSession.toString();
		} else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}

	}

	@Override
	public String logOutFromAccount(String key) {
		Optional<CurrentUserSession> currentUserOptional = sessionDao.findByUuid(key);

		if (!currentUserOptional.isPresent()) {
			throw new NotFoundException("User is not logged in with this number");
		}

		CurrentUserSession currentUserSession = currentUserOptional.get();
		sessionDao.delete(currentUserSession);

		return "Logged Out...";
	}

}
