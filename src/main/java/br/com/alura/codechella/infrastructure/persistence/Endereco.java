package br.com.alura.codechella.infrastructure.persistence;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
public class Endereco {
    private String cep;
    private Integer numero;
    private String complemento;

    public Endereco(String cep, Integer numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public static Endereco toPersistence(br.com.alura.codechella.domain.vo.Endereco endereco) {
        return new Endereco(endereco.getCep(), endereco.getNumero(), endereco.getComplemento());
    }
}