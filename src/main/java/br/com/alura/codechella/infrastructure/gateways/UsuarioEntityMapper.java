package br.com.alura.codechella.infrastructure.gateways;

import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario.UsuarioBuilder().cpf(entity.getCpf()).nome(entity.getNome()).nascimento(entity.getNascimento()).email(entity.getEmail()).build();
    }
}
