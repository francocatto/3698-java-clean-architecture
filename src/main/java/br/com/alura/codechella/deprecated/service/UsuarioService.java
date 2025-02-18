package br.com.alura.codechella.deprecated.service;

import br.com.alura.codechella.deprecated.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
