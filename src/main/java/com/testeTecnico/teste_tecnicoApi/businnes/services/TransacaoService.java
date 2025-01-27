package com.testeTecnico.teste_tecnicoApi.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testeTecnico.teste_tecnicoApi.controller.dtos.TransacaoRequestDTO;
import com.testeTecnico.teste_tecnicoApi.infrastructure.UnprocessableEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacao = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {
        log.info("Iniciando processamento");
        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.erro("Data e Hora maiores que a data atual");
            throw new UnprocessableEntity("Data e Hora maior que a data e hora atuais");
        }

        if (dto.valor() < 0) {
            log.erro("Valor não pode ser menor que 0");
            throw new UnprocessableEntity("Valor não pode ser menor que 0");
        }

        listaTransacao.add(dto);
    }

    public void limparTransacao() {
        listaTransacao.clear();
    }

    public List<TransacaoRequestDTO> buscarTransacao(Integer intervaloBusca) {
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        return listaTransacao.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo))
                .toList();
    }
}
