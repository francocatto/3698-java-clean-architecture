package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.adapters.UsuarioRepository;
import br.com.alura.codechella.domain.entities.Usuario;

public class CriarUsuario {

    private final UsuarioRepository repositorioDeUsuario;

    public CriarUsuario(UsuarioRepository repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public Usuario cadastrar(Usuario usuario){
        return repositorioDeUsuario.persistir(usuario);
    }

}
