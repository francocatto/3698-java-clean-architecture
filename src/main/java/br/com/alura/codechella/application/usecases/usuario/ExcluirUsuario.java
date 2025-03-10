package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.adapters.UsuarioRepository;
import br.com.alura.codechella.domain.entities.Usuario;

public class ExcluirUsuario {

    private final UsuarioRepository usuarioRepository;

    public ExcluirUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void excluir(String cpf) {
        this.usuarioRepository.excluir(cpf);
    }
}
