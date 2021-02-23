package com.promineotech.storeApp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.storeApp.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
