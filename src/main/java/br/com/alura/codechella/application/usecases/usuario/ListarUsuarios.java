package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.adapters.UsuarioRepository;
import br.com.alura.codechella.domain.entities.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final UsuarioRepository repositorioDeUsuario;

    public ListarUsuarios(UsuarioRepository repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }


    public List<Usuario> listarTodos() {
        return this.repositorioDeUsuario.listar();
    }
}
