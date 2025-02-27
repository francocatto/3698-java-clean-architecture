package br.com.alura.codechella.infrastructure.adapters;

import br.com.alura.codechella.application.adapters.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;
import br.com.alura.codechella.infrastructure.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioMapper mapper) {
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
        return usuarioRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
