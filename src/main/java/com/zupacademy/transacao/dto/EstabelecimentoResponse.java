package com.zupacademy.transacao.dto;

import com.zupacademy.transacao.model.Estabelecimento;

public class EstabelecimentoResponse {

	private String nome;
	private String cidade;
	private String endereco;

	@Deprecated
	public EstabelecimentoResponse() {
	}

	public EstabelecimentoResponse(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public Estabelecimento toModel() {
		return new Estabelecimento(this.nome, this.cidade, this.endereco);
	}
}
