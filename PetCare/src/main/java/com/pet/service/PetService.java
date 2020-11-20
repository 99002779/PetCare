package com.pet.service;
import org.springframework.stereotype.Service;
import java.util.List;

import com.pet.exception.PetNotFoundException;
import com.pet.model.Pet;

@Service
public interface PetService {
	Pet addPet(Pet pet);
    boolean deletePet(Integer petId) throws PetNotFoundException;
    Pet getPetById(Integer petId) throws PetNotFoundException;
    Pet updatePet( Pet pet);
   
    List<Pet> getAllPets();
    List<Pet> getPetbyBreed(String author) throws PetNotFoundException;
    List<Pet> getPetbyCategory(String category)throws PetNotFoundException;
    
	
	List<Pet> findPetByPetCategoryAndPetBreed(String petCategory, String petBreed)throws PetNotFoundException;
	List<Pet> findPetByPetBreedAndPetCost(String petBreed, Integer petCost)throws PetNotFoundException;
}
