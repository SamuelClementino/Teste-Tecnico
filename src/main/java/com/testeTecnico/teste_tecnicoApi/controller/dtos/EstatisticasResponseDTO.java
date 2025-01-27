package com.testeTecnico.teste_tecnicoApi.controller.dtos;

public record EstatisticasResponseDTO(
    Double sum,
    Double avg,
    Double min,
    Double max,
    Long count
) {
}
