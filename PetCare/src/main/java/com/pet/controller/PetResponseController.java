package com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.exception.PetNotFoundException;
import com.pet.model.Pet;
import com.pet.service.PetService;
//import com.pet.service.petservice;
@RestController
@RequestMapping("petcare")
public class PetResponseController {
	@Autowired
    PetService petService;
	
	@PostMapping("/pets")
    ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        Pet pets = petService.addPet(pet);
        return ResponseEntity.ok(pets);
    }
    @DeleteMapping("/pets/delete-one/{petId}")
    ResponseEntity<Void> deletePet(@PathVariable("petId")Integer petId) throws PetNotFoundException{
        petService.deletePet(petId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/pets/get-one/{petId}")
    ResponseEntity<Pet> getPetById(@PathVariable("petId")Integer petid) throws PetNotFoundException{
        Pet pets = petService.getPetById(petid);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Getting Pet by Id");
        header.add("breed", "One Pet");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(pets);
    }
    @PutMapping("/pets/update-one")
    ResponseEntity<Pet> updatePet(@RequestBody Pet Pet) {
        Pet pets = petService.updatePet(Pet);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Updating Pet");
        header.add("breed", "One Pet");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(pets);
    }
    @GetMapping("/pets")
    ResponseEntity<List<Pet>> getAllpets(){
        List<Pet> PetList =  petService.getAllPets();
        return ResponseEntity.ok(PetList);
    }
    @GetMapping("/pets/Breed/{breed}")
    ResponseEntity<List<Pet>> getPetbyBreed(@PathVariable("breed")String breed) throws PetNotFoundException{
        List<Pet> PetList =   petService.getPetbyBreed(breed);
        return ResponseEntity.ok(PetList);
    }
    @GetMapping("/pets/category/{category}")
    ResponseEntity<List<Pet>> getPetbyCategory(@PathVariable("category")String category)throws PetNotFoundException{
        List<Pet> PetList = petService.getPetbyCategory(category);    
        return ResponseEntity.ok(PetList);
    }
    @GetMapping("/pets/breedcost/{breed}/{cost}")
    public ResponseEntity<List<Pet>> findPetByBreedAndCost(@PathVariable("breed")String breed,
            @PathVariable("cost")Integer cost) {
        List<Pet> PetList = petService.findPetByPetBreedAndPetCost(breed, cost);
        return ResponseEntity.ok(PetList);
        
    }
    @GetMapping("/pets/categorybreed/{category}/{breed}")
    public ResponseEntity<List<Pet>>  findPetByCategoryAndBreed(@PathVariable("category")String category, 
            @PathVariable("breed")String breed) {
        List<Pet> PetList = petService.findPetByPetCategoryAndPetBreed(category,breed);
        return ResponseEntity.ok(PetList);
    }
}
