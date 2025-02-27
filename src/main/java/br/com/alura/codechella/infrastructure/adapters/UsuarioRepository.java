package br.com.alura.codechella.infrastructure.adapters;

import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;
import br.com.alura.codechella.infrastructure.persistence.UsuarioRepositoryJPA;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioRepository implements br.com.alura.codechella.application.adapters.UsuarioRepository {

    private final UsuarioRepositoryJPA usuarioRepository;

    private final UsuarioMapper mapper;

    public UsuarioRepository(UsuarioRepositoryJPA usuarioRepository, UsuarioMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario persistir(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        return mapper.toDomain(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void excluir(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    public Usuario alterar(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        return mapper.toDomain(usuarioRepository.save(usuarioEntity));
    }


}
