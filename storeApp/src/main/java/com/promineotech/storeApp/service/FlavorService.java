package com.promineotech.storeApp.service;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.storeApp.entity.Flavor;
import com.promineotech.storeApp.repostitory.FlavorRepository;

@Service
public class FlavorService {

	private static final Logger logger = LogManager.getLogger(FlavorService.class);
	
	@Autowired
	private FlavorRepository repo;
	
	public Iterable<Flavor> getFlavors() {
		return repo.findAll();
	}
	
	public Flavor createFlavor(Flavor flavor) {
		return repo.save(flavor);
	}
	
	public Flavor updateFlavor(Flavor flavor, Long id) {
		logger.info("Updating product {}" + flavor);
		Flavor oldProduct = repo.findById(id)
					.orElseThrow(() -> new NoSuchElementException("Can't find flavor with id:" + id));
			oldProduct.setName(flavor.getName());
			return repo.save(oldProduct);
		
	}
	
	public void removeFlavor(Long id) throws Exception {
		try {
			repo.deleteById(id);			
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete flavor: " + id, e);
			throw new Exception("Unable to delete flavor.");
		}
	}
		
}
