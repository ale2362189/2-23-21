package com.promineotech.storeApp.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.storeApp.entity.Customer;
import com.promineotech.storeApp.entity.Flavor;
import com.promineotech.storeApp.entity.Order;
import com.promineotech.storeApp.entity.Recipe;
import com.promineotech.storeApp.repostitory.CustomerRepository;
import com.promineotech.storeApp.repostitory.FlavorRepository;
import com.promineotech.storeApp.repostitory.RecipeRepository;

@Service
public class RecipeService {

	private static final Logger logger = LogManager.getLogger(RecipeService.class);

	@Autowired
	private RecipeRepository recipeRepo;

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private FlavorRepository flavorRepo;

	public Iterable<Recipe> getRecipe() {
		return recipeRepo.findAll();
	}

	public Recipe createRecipe(Recipe recipe) {
		return recipeRepo.save(recipe);
	}

	public Recipe updateRecipe(Recipe recipe, Long id) {
		logger.info("Updating recipe {}" + recipe);
		Recipe oldRecipe = recipeRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Can't find recipe with id:" + id));
		oldRecipe.setName(recipe.getName());
		oldRecipe.setFlavors(recipe.getFlavors());
		return recipeRepo.save(oldRecipe);

	}

	public void removeRecipe(Long id) throws Exception {
		try {
			recipeRepo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete product: " + id, e);
			throw new Exception("Unable to delete product.");
		}
	}

	public Recipe submitNewRecipe(Set<Long> flavorIds, Long customerId) throws Exception {
		try {
			Customer customer = customerRepo.findById(customerId)
					.orElseThrow(() -> new NoSuchElementException("Can't find customer with ID: " + customerId));
			Recipe recipe = initializeNewRecipe(flavorIds, customer);
			return recipeRepo.save(recipe);
		} catch (Exception e) {
			logger.error("Exception occured while trying to create new order for customer: " + customerId, e);
			throw e;
		}
	}

	private Recipe initializeNewRecipe(Set<Long> flavorIds, Customer customer) {
		Recipe recipe = new Recipe();
		recipe.setFlavors(convertToFlavorSet(flavorRepo.findAllById(flavorIds)));
		return null;
	}

	
		private Set<Flavor> convertToFlavorSet(Iterable<Flavor> iterable) {
			Set<Flavor> set = new HashSet<Flavor>();
			for (Flavor flavor : iterable) {
				set.add(flavor);
			}
		return set;
	}
}
