package br.com.alura.codechella.infrastructure.adapters;

import br.com.alura.codechella.application.adapters.UsuarioRepository;
import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioEntity;
import br.com.alura.codechella.infrastructure.persistence.UsuarioFileRepository;
import br.com.alura.codechella.infrastructure.persistence.UsuarioMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioRepositoryFile implements UsuarioRepository {

    private final UsuarioFileRepository usuarioFileRepository;

    private final UsuarioMapper mapper;

    public UsuarioRepositoryFile(UsuarioFileRepository usuarioFileRepository, UsuarioMapper mapper) {
        this.usuarioFileRepository = usuarioFileRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario persistir(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        return mapper.toDomain(usuarioFileRepository.save(usuarioEntity));
    }

    @Override
    public List<Usuario> listar() {
        return ((List<UsuarioEntity>) usuarioFileRepository.findAll()).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void excluir(String cpf) {
        List<UsuarioEntity> listaDeUsuarios = this.usuarioFileRepository.findUsuarioEntityByCpf(cpf);
        listaDeUsuarios.forEach(usuarioEntity -> usuarioFileRepository.delete(usuarioEntity));
    }

    @Override
    public Usuario alterar(String cpf, Usuario usuario) {
        List<UsuarioEntity> listaDeUsuarios = this.usuarioFileRepository.findUsuarioEntityByCpf(cpf);
        if (!listaDeUsuarios.isEmpty()) {
            UsuarioEntity usuarioAtual = listaDeUsuarios.get(0);
            UsuarioEntity usuarioAtualizado = mapper.toEntity(usuario);
            usuarioAtualizado.setId(usuarioAtual.getId());
            return mapper.toDomain(usuarioFileRepository.save(usuarioAtualizado));
        }
        return null;
    }
}
