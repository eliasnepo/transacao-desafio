package com.zupacademy.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {

	private String id;
	private BigDecimal valor;
	private Estabelecimento estabelecimento;
	private Cartao cartao;
	private LocalDateTime efetivadaEm;

	@Deprecated
	public TransactionMessage() {
	}
	
	public TransactionMessage(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
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
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	
	public Cartao getCartao() {
		return cartao;
	}
	
	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
