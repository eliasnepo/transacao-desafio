package com.zupacademy.transacao.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.zupacademy.transacao.dto.TransactionMessage;
import com.zupacademy.transacao.model.Transacao;
import com.zupacademy.transacao.repositories.TransacaoRepository;

@Component
public class ListenerDeTransacao {

	private final TransacaoRepository transacaoRepository;
	
	public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	static final Logger log = LoggerFactory.getLogger(ListenerDeTransacao.class);
	
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionMessage eventoDeTransacao) {
        log.info("ID da transação: " + eventoDeTransacao.getId());
        log.info("Número do cartão: " + eventoDeTransacao.getCartao().getId());
        
        Transacao transacao = eventoDeTransacao.toModel();
        transacaoRepository.save(transacao);
    }

}