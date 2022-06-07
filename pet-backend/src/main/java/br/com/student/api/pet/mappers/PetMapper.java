package br.com.student.api.pet.mappers;

import org.springframework.stereotype.Component;

import br.com.student.api.pet.dtos.PetResponse;
import br.com.student.core.models.Pet;

@Component
public class PetMapper {

	public PetResponse toResponse(Pet pet) {
		var petResponse = new PetResponse();
		petResponse.setId(pet.getId());
		petResponse.setNome(pet.getNome());
		petResponse.setHistoria(pet.getHistoria());
		petResponse.setFoto(pet.getFoto());
		return petResponse;
	}
}
