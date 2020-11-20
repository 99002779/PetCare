package com.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.dao.PetRepository;
import com.pet.exception.PetNotFoundException;
import com.pet.model.Pet;

@Service
public class PetServiceImplementation implements PetService{
	
	@Autowired
	PetRepository petRepository;
	
	@Override
	public Pet addPet(Pet pet) {
		Pet newPet=petRepository.save(pet);
		return newPet;
	}

	@Override
	public boolean deletePet(Integer petId) throws PetNotFoundException {
		// TODO Auto-generated method stub
		petRepository.deleteById(petId);
		return true;
	}

	@Override
	public Pet getPetById(Integer petId) throws PetNotFoundException
	{
		// TODO Auto-generated method stub
		return petRepository.findByPetId(petId);
	}

	@Override
	public Pet updatePet(Pet pet) {
		// TODO Auto-generated method stub
		return petRepository.save(pet);
	}

	@Override
	public List<Pet> getAllPets() {
		// TODO Auto-generated method stub
		return petRepository.findAll();
	}

	@Override
	public List<Pet> getPetbyBreed(String petBreed) throws PetNotFoundException {
		// TODO Auto-generated method stub
		List<Pet> petList = petRepository.findByPetBreed(petBreed);
		 if(petList.isEmpty()) {
			 throw new PetNotFoundException("Pet is not available with this breed..");
		 }
		 return petList;
		
	}

	@Override
	public List<Pet> getPetbyCategory(String petCategory) throws PetNotFoundException {
		// TODO Auto-generated method stub
		List<Pet> petList = petRepository.findByPetCategory(petCategory);
		 if(petList.isEmpty()) {
			 throw new PetNotFoundException("Pet Category is not available");
		 }
		 return petList;
	}

	@Override
	public List<Pet> findPetByPetCategoryAndPetBreed(String petCategory, String petBreed) {
		// TODO Auto-generated method stub
		List<Pet> petList= petRepository.findPetByPetCategoryAndPetBreed(petCategory, petBreed);
		if(petList.isEmpty()) {
			 throw new PetNotFoundException("pet with Category is not available");
		 }
		 return petList;
	}

	@Override
	public List<Pet> findPetByPetBreedAndPetCost(String petBreed, Integer petCost) {
		// TODO Auto-generated method stub
		List<Pet> petList= petRepository.findPetByPetBreedAndPetCost(petBreed, petCost);
		if(petList.isEmpty()) {
			 throw new PetNotFoundException("pet with Category is not available");
		 }
		 return petList;
		
	}

}
