package br.com.alura.codechella.infrastructure.adapters;

import br.com.alura.codechella.application.adapters.UsuarioRepository;
import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;
import br.com.alura.codechella.infrastructure.persistence.UsuarioJpaRepository;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioRepositoryJpa implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;

    private final UsuarioMapper mapper;

    public UsuarioRepositoryJpa(UsuarioJpaRepository usuarioJpaRepository, UsuarioMapper mapper) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario persistir(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        return mapper.toDomain(usuarioJpaRepository.save(usuarioEntity));
    }

    @Override
    public List<Usuario> listar() {
        return usuarioJpaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void excluir(String cpf) {
        List<UsuarioEntity> listaDeUsuarios = this.usuarioJpaRepository.findUsuarioEntityByCpf(cpf);
        listaDeUsuarios.forEach(usuarioEntity -> usuarioJpaRepository.delete(usuarioEntity));
    }

    public Usuario alterar(String cpf, Usuario usuario) {
        List<UsuarioEntity> listaDeUsuarios = this.usuarioJpaRepository.findUsuarioEntityByCpf(cpf);
        if (!listaDeUsuarios.isEmpty()) {
            UsuarioEntity usuarioAtual = listaDeUsuarios.get(0);
            UsuarioEntity usuarioAtualizado = mapper.toEntity(usuario);
            usuarioAtualizado.setId(usuarioAtual.getId());
            return mapper.toDomain(usuarioJpaRepository.save(usuarioAtualizado));
        }
        return null;
    }


}
