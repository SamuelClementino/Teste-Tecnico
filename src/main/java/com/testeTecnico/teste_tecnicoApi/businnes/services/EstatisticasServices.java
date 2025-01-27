package com.testeTecnico.teste_tecnicoApi.business.services;

import com.testeTecnico.teste_tecnicoApi.business.controller.dtos.EstatisticasResponseDTO;
import com.testeTecnico.teste_tecnicoApi.business.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasServices {

    private final TransacaoService TransacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacao(Integer intervaloBusca) {
        List<TransacaoRequestDTO> transacoes = TransacaoService.buscarTransacao(intervaloBusca);
        DoubleSummaryStatistics estatisticasTransacao = transacoes.stream()
                .mapToDouble(TransacaoRequestDTO::getValor)
                .summaryStatistics();
        return new EstatisticasResponseDTO(
                estatisticasTransacao.getAverage(),
                estatisticasTransacao.getSum(),
                estatisticasTransacao.getMin(),
                estatisticasTransacao.getMax(),
                estatisticasTransacao.getCount()
        );
    }
}
