package com.testeTecnico.teste_tecnicoApi.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(
    double valor,
    OffsetDateTime dataHora
) {
}
