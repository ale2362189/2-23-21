package com.promineotech.storeApp.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.storeApp.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
