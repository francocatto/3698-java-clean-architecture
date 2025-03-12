package br.com.alura.codechella.infrastructure.adapters;

import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.Endereco;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;

public class UsuarioMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail(), Endereco.toPersistence(usuario.getEndereco()));
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario.UsuarioBuilder().cpf(entity.getCpf()).nome(entity.getNome()).nascimento(entity.getNascimento()).email(entity.getEmail()).endereco(entity.getEndereco().getCep(), entity.getEndereco().getNumero(), entity.getEndereco().getComplemento()).build();
    }
}
