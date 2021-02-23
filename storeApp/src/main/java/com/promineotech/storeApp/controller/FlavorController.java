package com.promineotech.storeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.storeApp.entity.Flavor;
import com.promineotech.storeApp.service.FlavorService;

  @RestController
//@RequestMapping("/flavors")
public class FlavorController {
	
	@Autowired
	private FlavorService service;
	
//	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<Object>(service.getFlavors(), HttpStatus.OK);
	}
	
//	@RequestMapping(method=RequestMethod.POST)
  	@ResponseStatus(code = HttpStatus.CREATED)
	public Flavor createFlavors(@RequestBody Flavor flavor) {
		return service.createFlavor(flavor);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateFlavor(@RequestBody Flavor flavor, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateFlavor(flavor, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update product.", HttpStatus.BAD_REQUEST);
		}
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
		try {
			service.removeFlavor(id);
			return new ResponseEntity<Object>("Successfully deleted product with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete product.", HttpStatus.BAD_REQUEST); 
		}
	}

}