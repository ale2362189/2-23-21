package com.promineotech.storeApp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.storeApp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
