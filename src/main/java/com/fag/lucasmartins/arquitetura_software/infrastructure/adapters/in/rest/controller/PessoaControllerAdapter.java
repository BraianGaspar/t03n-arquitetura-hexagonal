package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaServicePort;

    public PessoaControllerAdapter(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrarPessoa(@RequestBody PessoaRequestDTO requestDTO) {
        PessoaBO pessoaBO = PessoaDTOMapper.toBo(requestDTO);
        PessoaBO pessoaCriadaBo = pessoaServicePort.salvar(pessoaBO);
        PessoaResponseDTO responseDTO = PessoaDTOMapper.toDto(pessoaCriadaBo);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPorId(@PathVariable UUID id) {
        PessoaBO pessoaBO = pessoaServicePort.buscarPorId(id);
        PessoaResponseDTO responseDTO = PessoaDTOMapper.toDto(pessoaBO);
        return ResponseEntity.ok(responseDTO);
    }
}
