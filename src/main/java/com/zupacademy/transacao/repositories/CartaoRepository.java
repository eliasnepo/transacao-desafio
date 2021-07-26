package com.zupacademy.transacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zupacademy.transacao.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String>{

}
