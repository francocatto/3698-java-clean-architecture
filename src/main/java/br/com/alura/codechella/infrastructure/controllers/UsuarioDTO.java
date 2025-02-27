package br.com.alura.codechella.infrastructure.controllers;

import br.com.alura.codechella.domain.vo.Endereco;

import java.time.LocalDate;

public record UsuarioDTO(String cpf, String nome, LocalDate nascimento, String email, Endereco endereco) {
}
