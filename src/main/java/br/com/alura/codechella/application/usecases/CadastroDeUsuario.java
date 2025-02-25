package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;

public class CadastroDeUsuario {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public CadastroDeUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public Usuario cadastrar(Usuario usuario){
        return repositorioDeUsuario.persistir(usuario);
    }

}
