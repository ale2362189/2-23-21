package com.promineotech.storeApp.controller;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.promineotech.storeApp.entity.Recipe;
import com.promineotech.storeApp.service.RecipeService;

@RestController
//@RequestMapping("customers/{id}/recipes")
public class RecipeController {

	@Autowired
	private RecipeService service;
	
//	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createRecipe(@RequestBody Set<Long> recipeIds, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.submitNewRecipe(recipeIds, id), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateRecipe(recipe, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update recipe.", HttpStatus.BAD_REQUEST);
		}
	}
}


