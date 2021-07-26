package com.zupacademy.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.zupacademy.transacao.model.Cartao;
import com.zupacademy.transacao.model.Estabelecimento;
import com.zupacademy.transacao.model.Transacao;

public class TransactionMessage {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private LocalDateTime efetivadaEm;

	@Deprecated
	public TransactionMessage() {
	}
	
	public TransactionMessage(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}
	
	public String getId() {
		return id;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}
	
	public CartaoResponse getCartao() {
		return cartao;
	}
	
	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	public Transacao toModel() {
		Cartao cartao = this.cartao.toModel();
		Estabelecimento estabelecimento = this.estabelecimento.toModel();
		return new Transacao(this.id, this.valor, estabelecimento, cartao, this.efetivadaEm);
	}
}
