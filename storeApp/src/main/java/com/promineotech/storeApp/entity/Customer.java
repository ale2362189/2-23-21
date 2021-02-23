package com.promineotech.storeApp.entity;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.promineotech.storeApp.util.MilitaryDiscount;

@Entity
public class Customer {

	private Long id;
	private String firstName;
	private String lastName;
	private Address address;
	private MilitaryDiscount discount;
	private Set<Order> orders;
	private Set<Recipe> recipe;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public MilitaryDiscount getDiscount() {
		return discount;
	}
	public void setLevel(MilitaryDiscount discount) {
		this.discount = discount;
	}
	
//	@OneToMany(mappedBy = "customer"
//			+ "")
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public Set<Recipe> getRecipe() {
		return recipe;
	}
	public void setRecipe(Set<Recipe> recipe) {
		this.recipe = recipe;
	}
	
	
}
