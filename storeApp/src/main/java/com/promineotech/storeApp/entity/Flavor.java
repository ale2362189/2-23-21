package com.promineotech.storeApp.entity;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Flavor {

	private Long id;
	private String name;
	private int percent;
	
	@JsonIgnore
	private Set<Recipe> recipes;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "recipe_order",
//			joinColumns = @JoinColumn(name = "recipeId", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name = "orderId", referencedColumnName = "id"))
	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "recipe_flavor",
//	joinColumns = @JoinColumn(name = "flavorId", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "recipeId", referencedColumnName = "id"))
	

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	
	

	

	

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "percent_flavor",
//	joinColumns = @JoinColumn(name = "flavorId", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "percentId", referencedColumnName = "id"))
	
}


