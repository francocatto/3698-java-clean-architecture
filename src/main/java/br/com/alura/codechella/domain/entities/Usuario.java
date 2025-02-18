package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.vo.Endereco;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
    private final String cpf;
    private final String nome;
    private final LocalDate nascimento;
    private final String email;
    private final Endereco endereco;

    private Usuario(String cpf, String nome, LocalDate nascimento, String email, Endereco endereco) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF no padrão incorreto");
        }
        if (email != null && !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new IllegalArgumentException("Email invalido");
        if (Period.between(nascimento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Nascimento inferior a 18 anos");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco=endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getEmail() {
        return email;
    }

    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    public static class UsuarioBuilder {
        private String cpf;
        private String nome;
        private LocalDate nascimento;
        private String email;
        private Endereco endereco;


        public UsuarioBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public UsuarioBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder nascimento(LocalDate nascimento) {
            this.nascimento = nascimento;
            return this;
        }

        public UsuarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder endereco(String cep, Integer numero, String complemento) {
            this.endereco = new Endereco(cep,numero,complemento);
            return this;
        }

        public Usuario build() {
            return new Usuario(cpf, nome, nascimento, email, endereco);
        }
    }
}
