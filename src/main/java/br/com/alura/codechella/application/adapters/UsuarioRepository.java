package br.com.alura.codechella.application.adapters;

import br.com.alura.codechella.domain.entities.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario persistir(Usuario usuario);

    List<Usuario> listar();
}
