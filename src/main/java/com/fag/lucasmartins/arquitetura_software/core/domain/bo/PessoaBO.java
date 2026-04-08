package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO() {
        this.id = UUID.randomUUID();
    }

    public void validar() {
        if (nomeCompleto == null || nomeCompleto.isBlank()) {
            throw new DomainException("Nome completo é obrigatório");
        }
        if (cpf == null || cpf.length() != 11) {
            throw new DomainException("CPF deve conter 11 caracteres");
        }
        if (email == null || !email.contains("@")) {
            throw new DomainException("E-mail inválido (deve conter '@')");
        }
        if (telefone == null || telefone.length() != 11) {
            throw new DomainException("Telefone deve conter 11 dígitos (sem máscara)");
        }
        if (dataNascimento == null) {
            throw new DomainException("Data de nascimento é obrigatória");
        }
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("Idade mínima de 18 anos não atendida");
        }
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
