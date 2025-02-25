package br.com.alura.codechella.infrastructure.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;
import br.com.alura.codechella.infrastructure.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario persistir(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        return mapper.toDomain(usuarioEntity);
    }

    @Override
    public List<Usuario> listar() {
        return null; //usuarioRepository.findAll();
    }
}
