package com.zupacademy.transacao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zupacademy.transacao.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	Page<Transacao> findAllByCartaoId(Pageable paginacao, String id);
}
