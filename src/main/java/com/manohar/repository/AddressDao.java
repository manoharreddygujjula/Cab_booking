package com.manohar.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.manohar.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
