package br.com.student.api.pet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.student.core.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.student.api.pet.dtos.PetRequest;
import br.com.student.api.pet.dtos.PetResponse;
import br.com.student.api.pet.mappers.PetMapper;
import br.com.student.core.repositories.PetRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetMapper petMapper;
	
	
	public List<PetResponse> findAll() {
		
		return petRepository.findAll()
			.stream()
			.map((pet) -> petMapper.toResponse(pet))
			.collect(Collectors.toList());
	}
	
	public PetResponse create(PetRequest petRequest) {
		var petToCreate = petMapper.toModel(petRequest);
		var createdPet = petRepository.save(petToCreate);
		return petMapper.toResponse(createdPet);
	}

	public void excluir(Long id) {

		Optional<Pet> pet = petRepository.findById(id);

		if (pet.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		petRepository.deleteById(id);
	}

}
