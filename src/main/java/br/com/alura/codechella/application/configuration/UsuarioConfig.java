package br.com.alura.codechella.application.configuration;

import br.com.alura.codechella.application.usecases.usuario.CriarUsuario;
import br.com.alura.codechella.application.usecases.usuario.ListarUsuarios;
import br.com.alura.codechella.infrastructure.adapters.UsuarioRepository;
import br.com.alura.codechella.infrastructure.adapters.UsuarioMapper;
import br.com.alura.codechella.infrastructure.persistence.UsuarioRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(UsuarioRepository usuarioRepository){
        return new CriarUsuario(usuarioRepository);
    }

    @Bean
    UsuarioRepository criarRepositorioDeUsuario(UsuarioRepositoryJPA usuarioRepositoryJPA, UsuarioMapper usuarioEntityMapper){
        return new UsuarioRepository(usuarioRepositoryJPA, usuarioEntityMapper);
    }

    @Bean
    UsuarioMapper usuarioEntityMapper(){
        return new UsuarioMapper();
    }

    @Bean
    ListarUsuarios listarUsuarios(UsuarioRepository usuarioRepository){
        return new ListarUsuarios(usuarioRepository);
    }
}
