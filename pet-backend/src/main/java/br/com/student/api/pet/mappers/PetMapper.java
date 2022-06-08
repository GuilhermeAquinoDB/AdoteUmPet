package br.com.student.api.pet.mappers;

import org.springframework.stereotype.Component;

import br.com.student.api.pet.dtos.PetResponse;
import br.com.student.core.models.Pet;

@Component
public class PetMapper {

	public PetResponse toResponse(Pet pet) {
		return PetResponse.builder()
			.id(pet.getId())
			.nome(pet.getNome())
			.historia(pet.getHistoria())
			.foto(pet.getFoto())
			.build();
	}
}
