package com.pet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="petDb")
@TypeAlias("Pet")
public class Pet {
   @Id
	Integer petId;
	String petName;
	String petCategory;
	String petBreed;
	String petFood;
	String petOwner;
	Integer petOwnerNumber;
	Integer petCost;
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(Integer petId, String petName, String petCategory, String petBreed, String petFood, String petOwner,
			Integer petOwnerNumber, Integer petCost) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petCategory = petCategory;
		this.petBreed = petBreed;
		this.petFood = petFood;
		this.petOwner = petOwner;
		this.petOwnerNumber = petOwnerNumber;
		this.petCost = petCost;
	}

	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetCategory() {
		return petCategory;
	}
	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}
	public String getPetBreed() {
		return petBreed;
	}
	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}
	public String getPetFood() {
		return petFood;
	}
	public void setPetFood(String petFood) {
		this.petFood = petFood;
	}
	public String getPetOwner() {
		return petOwner;
	}
	public void setPetOwner(String petOwner) {
		this.petOwner = petOwner;
	}
	public Integer getPetOwnerNumber() {
		return petOwnerNumber;
	}
	public void setPetOwnerNumber(Integer petOwnerNumber) {
		this.petOwnerNumber = petOwnerNumber;
	}
	
	public Integer getPetCost() {
		return petCost;
	}

	public void setPetCost(Integer petCost) {
		this.petCost = petCost;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petCategory=" + petCategory + ", petBreed="
				+ petBreed + ", petFood=" + petFood + ", petOwner=" + petOwner + ", petOwnerNumber=" + petOwnerNumber
				+ ", petCost=" + petCost + "]";
	}

	
	
	
}
