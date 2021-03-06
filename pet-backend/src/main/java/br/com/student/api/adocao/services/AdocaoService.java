package br.com.student.api.adocao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.student.api.adocao.dtos.AdocaoRequest;
import br.com.student.api.adocao.dtos.AdocaoResponse;
import br.com.student.api.adocao.mappers.AdocaoMapper;
import br.com.student.core.repositories.AdocaoRepository;

@Service
public class AdocaoService {
	
	@Autowired
	private AdocaoRepository adocaoRepository;
	
	@Autowired
	private AdocaoMapper adocaoMapper;
	
	public AdocaoResponse create(AdocaoRequest adocaoRequest) {
		var adocaoToCreate = adocaoMapper.toModel(adocaoRequest);
		var createdAdocao = adocaoRepository.save(adocaoToCreate);
		return adocaoMapper.toResponse(createdAdocao);
	}
	
	public List<AdocaoResponse> findAll() {
		return adocaoRepository.findAll()
				.stream()
				.map((adocao) -> adocaoMapper.toResponse(adocao))
				.collect(Collectors.toList());
	}

}
