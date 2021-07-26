package com.zupacademy.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.zupacademy.transacao.model.Transacao;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private String estabelecimentoCidade;
	private String cartaoId;
	private LocalDateTime efetivadaEm;

	@Deprecated
	public TransacaoResponse() {
	}

	public TransacaoResponse(Transacao transaction) {
		this.id = transaction.getId();
		this.valor = transaction.getValor();
		this.estabelecimentoCidade = transaction.getEstabelecimento().getCidade();
		this.cartaoId = transaction.getCartao().getId();
		this.efetivadaEm = transaction.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getEstabelecimentoCidade() {
		return estabelecimentoCidade;
	}

	public String getCartaoId() {
		return cartaoId;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
