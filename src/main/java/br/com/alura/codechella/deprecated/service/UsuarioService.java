package br.com.alura.codechella.deprecated.service;

import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    UsuarioEntity cadastrarUsuario(UsuarioEntity usuario);

    List<UsuarioEntity> listarTodos();
}
