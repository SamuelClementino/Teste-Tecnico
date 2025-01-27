package com.testeTecnico.teste_tecnicoApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testeTecnico.teste_tecnicoApi.business.services.EstatisticasServices;
import com.testeTecnico.teste_tecnicoApi.controller.dtos.EstatisticasResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticasServices estatisticasServices;

    @GetMapping
    @Operation(description = "Endpoint responsável por buscar estatísticas de transações")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de requisição"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
        @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca
    ) {
        return ResponseEntity.ok(estatisticasServices.calcularEstatisticasTransacao(intervaloBusca));
    }
}
