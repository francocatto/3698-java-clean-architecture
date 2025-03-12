package br.com.alura.codechella.infrastructure.controllers;

import br.com.alura.codechella.domain.vo.Endereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UsuarioDTO(@NotNull String cpf, @NotNull String nome, @NotNull LocalDate nascimento, @NotNull String email, Endereco endereco) {
    public static String formatarCpf(String cpf) {
        // Verifica se o CPF tem 11 dígitos
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos.");
        }

        // Formata o CPF no padrão XXX.XXX.XXX-XX
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
}
