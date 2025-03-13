package br.com.alura.codechella.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Setter
@Getter
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    @Embedded
    private Endereco endereco;

    public UsuarioEntity(String cpf, String nome, LocalDate nascimento, String email, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
    }
}
