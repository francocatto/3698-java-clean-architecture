package br.com.alura.codechella.infrastructure.controllers;

import br.com.alura.codechella.application.usecases.usuario.AlterarUsuario;
import br.com.alura.codechella.application.usecases.usuario.CriarUsuario;
import br.com.alura.codechella.application.usecases.usuario.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.usuario.ListarUsuarios;
import br.com.alura.codechella.domain.entities.Usuario;
import br.com.alura.codechella.infrastructure.persistence.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    private final ListarUsuarios listarUsuarios;

    private final ExcluirUsuario excluirUsuario;

    private final AlterarUsuario alterarUsuario;
    private final UsuarioMapper usuarioMapper;


    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, ExcluirUsuario excluirUsuario, AlterarUsuario alterarUsuario, UsuarioMapper usuarioMapper) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.excluirUsuario = excluirUsuario;
        this.alterarUsuario = alterarUsuario;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioDTO usuarioDTO, UriComponentsBuilder uriBuilder) {
        Usuario usuario = criarUsuario.cadastrar(Usuario.builder().cpf(usuarioDTO.cpf()).nome(usuarioDTO.nome()).nascimento(usuarioDTO.nascimento()).endereco(usuarioDTO.endereco().getCep(), usuarioDTO.endereco().getNumero(), usuarioDTO.endereco().getComplemento()).email(usuarioDTO.email()).build());
        //var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        //return ResponseEntity.created(uri).body(usuario);
        return ResponseEntity.ok(new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail(), usuario.getEndereco()));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(listarUsuarios.listarTodos().stream().map(u -> new UsuarioDTO(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail(), u.getEndereco())).collect(Collectors.toUnmodifiableList()));
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity<Usuario> deletar(@PathVariable String cpf) {
        this.excluirUsuario.excluir(UsuarioDTO.formatarCpf(cpf));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{cpf}")
    @Transactional
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable String cpf, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        var usuario = alterarUsuario.alterar(UsuarioDTO.formatarCpf(cpf), Usuario.builder().cpf(usuarioDTO.cpf()).nome(usuarioDTO.nome()).nascimento(usuarioDTO.nascimento()).endereco(usuarioDTO.endereco().getCep(), usuarioDTO.endereco().getNumero(), usuarioDTO.endereco().getComplemento()).email(usuarioDTO.email()).build());
        return ResponseEntity.ok(new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail(), usuario.getEndereco())); // HTTP 200 - OK
    }



}
