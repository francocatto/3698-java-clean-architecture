package br.com.alura.codechella.application.adapters;

import br.com.alura.codechella.domain.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {

    Usuario persistir(Usuario usuario);

    List<Usuario> listar();

    void excluir(Long id);

    Usuario alterar(Usuario usuario);
}