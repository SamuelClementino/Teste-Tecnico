package com.testeTecnico.teste_tecnicoApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeTecnico.teste_tecnicoApi.business.services.TransacaoService;
import com.testeTecnico.teste_tecnicoApi.controller.dtos.TransacaoRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService TransacaoService;

    @PostMapping
    @Operation(description = "Endpoint responsável por adicionar transações")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Transação gravada com sucesso"),
        @ApiResponse(responseCode = "422", description = "A transação não atende aos requisitos da transação"),
        @ApiResponse(responseCode = "400", description = "Erro de requisição"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {
        TransacaoService.adicionarTransacoes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "Endpoint responsável por deletar transações")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Transações deletadas com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de requisição"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletarTransacao() {
        TransacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }
}
