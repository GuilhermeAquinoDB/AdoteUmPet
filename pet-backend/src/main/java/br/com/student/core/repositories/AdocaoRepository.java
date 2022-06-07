package br.com.student.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.student.core.models.Adocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

}
