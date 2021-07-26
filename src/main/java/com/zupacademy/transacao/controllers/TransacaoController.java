package com.zupacademy.transacao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zupacademy.transacao.dto.TransacaoResponse;
import com.zupacademy.transacao.model.Cartao;
import com.zupacademy.transacao.model.Transacao;
import com.zupacademy.transacao.repositories.CartaoRepository;
import com.zupacademy.transacao.repositories.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	private final TransacaoRepository repository;
	private final CartaoRepository cartaoRepository;
	
	public TransacaoController(TransacaoRepository repository, CartaoRepository cartaoRepository) {
		this.repository = repository;
		this.cartaoRepository = cartaoRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAllPaged(@PathVariable String id, @PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Cartao cartao = cartaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Page<Transacao> transacoes = repository.findAllByCartaoId(paginacao, cartao.getId());
		
		List<TransacaoResponse> list = new ArrayList<>();
		transacoes.forEach(transacao -> list.add(new TransacaoResponse(transacao)));
		
		return ResponseEntity.ok(list);
	}
}
