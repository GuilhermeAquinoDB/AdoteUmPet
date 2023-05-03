package br.com.student.api.pet.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.student.core.models.Pet;
import br.com.student.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.student.api.pet.dtos.PetRequest;
import br.com.student.api.pet.dtos.PetResponse;
import br.com.student.api.pet.services.PetService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/pets")
public class PetController {
	
	@Autowired
	private PetService petService;
	private PetRepository petRepository;
	
	@GetMapping
	public List<PetResponse> findAll() {
		
		return petService.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetResponse create(@RequestBody @Valid PetRequest petRequest) {

		return petService.create(petRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		petService.excluir(id);
	}
	
}
