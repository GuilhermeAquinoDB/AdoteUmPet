package br.com.student.api.adocao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.student.api.adocao.dtos.AdocaoRequest;
import br.com.student.api.adocao.dtos.AdocaoResponse;
import br.com.student.api.pet.mappers.PetMapper;
import br.com.student.core.models.Adocao;
import br.com.student.core.repositories.PetRepository;

@Component
public class AdocaoMapper {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetMapper petMapper;

	public Adocao toModel(AdocaoRequest adocaoRequest) {
		
		return Adocao.builder()
			.email(adocaoRequest.getEmail())
			.valor(adocaoRequest.getValor())
			.pet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()))
			.build();
	}
	
	public AdocaoResponse toResponse(Adocao adocao) {

		return AdocaoResponse.builder()
				.id(adocao.getId())
				.email(adocao.getEmail())
				.valor(adocao.getValor())
				.pet(petMapper.toResponse(adocao.getPet()))
				.build();
	}
}
