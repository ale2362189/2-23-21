package com.promineotech.storeApp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.storeApp.entity.Flavor;

public interface FlavorRepository extends JpaRepository<Flavor, Long>{

}
