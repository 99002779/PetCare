package com.pet.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.pet.model.Pet;

@Repository
public interface PetRepository extends MongoRepository<Pet,Integer>{
	//derived query
	Pet findByPetId(Integer petId);
	List<Pet> findByPetName(String petName);
	List<Pet> findByPetCategory(String petCategory);
	List<Pet> findByPetBreed(String petBreed);
	List<Pet> findByPetFood(String petFood);
	
	
	List<Pet> findPetByPetBreedAndPetCost(String petBreed,Integer petCost);
	List<Pet> findPetByPetCategoryAndPetBreed(String petCategory, String petBreed);
}
