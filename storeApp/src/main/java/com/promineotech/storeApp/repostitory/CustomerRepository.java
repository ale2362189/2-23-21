package com.promineotech.storeApp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.storeApp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
