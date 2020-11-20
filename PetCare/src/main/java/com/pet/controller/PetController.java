package com.pet.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pet.exception.PetNotFoundException;
import com.pet.model.Pet;
import com.pet.service.PetService;


//@RestController
//@RequestMapping("/book-api")
public class PetController {
	@Autowired
	PetService petService;
	@PostMapping("/pets")
	Pet addPet(@RequestBody Pet pet) {
		return petService.addPet(pet);
	}
	@DeleteMapping("/pets/delete-one/{petId}")
	boolean deletePet(@PathVariable("petId")Integer petid) throws PetNotFoundException{
		return petService.deletePet(petid);
	}
	@GetMapping("/pets/update-one")
	Pet getPetById(@PathVariable("petId")Integer petid)throws PetNotFoundException {
		return petService.getPetById(petid) ;
	}
	@PutMapping("/pets/update-one")
	Pet updatePet(Pet pet) {
		return petService.updatePet(pet);
	}
	@GetMapping("/pets")
	List<Pet> getAllPets(){
		return petService.getAllPets();
	}
	@GetMapping("/pets/breed/{breed}")
	List<Pet>getPetbyBreed(@PathVariable("breed")String breed)throws PetNotFoundException{
		return petService.getPetbyBreed(breed);
	}
	@GetMapping("/pets/category/{category}")
	List<Pet> getPetbycategory(@PathVariable("category")String category)throws PetNotFoundException{
		return petService.getPetbyCategory(category);
	}
	@GetMapping("/pets/breedcost/{breed}/{cost}")
	public List<Pet> findPetByBreedAndCost(@PathVariable("breed")String breed,@PathVariable("cost") Integer cost) {
		// TODO Auto-generated method stub
		return petService. findPetByPetBreedAndPetCost(breed,cost);
	}
	@GetMapping("/pets/categorybreed/{category}/{breed}")
	public List<Pet> findPetByCategoryAndBreed(@PathVariable("category")String category,@PathVariable("breed")String breed) {
		// TODO Auto-generated method stub
		return petService.findPetByPetCategoryAndPetBreed(category, breed);
	}

}