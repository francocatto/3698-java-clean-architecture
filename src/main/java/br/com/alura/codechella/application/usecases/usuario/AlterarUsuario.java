package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.adapters.UsuarioRepository;
import br.com.alura.codechella.domain.entities.Usuario;

public class AlterarUsuario {

    private final UsuarioRepository usuarioRepository;

    public AlterarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario alterar(String cpf, Usuario usuario) {
        return this.usuarioRepository.alterar(cpf, usuario);
    }

}
