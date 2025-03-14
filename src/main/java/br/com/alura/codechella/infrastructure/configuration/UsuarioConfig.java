package br.com.alura.codechella.infrastructure.configuration;

import br.com.alura.codechella.application.usecases.usuario.AlterarUsuario;
import br.com.alura.codechella.application.usecases.usuario.CriarUsuario;
import br.com.alura.codechella.application.usecases.usuario.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.usuario.ListarUsuarios;
import br.com.alura.codechella.infrastructure.adapters.UsuarioRepositoryFile;
import br.com.alura.codechella.infrastructure.adapters.UsuarioRepositoryJpa;
import br.com.alura.codechella.infrastructure.persistence.UsuarioMapper;
import br.com.alura.codechella.infrastructure.persistence.UsuarioFileRepository;
import br.com.alura.codechella.infrastructure.persistence.UsuarioJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* TODO Parametrizar o tipo de repositório para rodar a aplicação
 */
@Configuration
public class UsuarioConfig {

    @Bean
    UsuarioRepositoryJpa criarRepositorioDeUsuarioJPA(UsuarioJpaRepository usuarioJpaRepository, UsuarioMapper usuarioEntityMapper){
        return new UsuarioRepositoryJpa(usuarioJpaRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioRepositoryFile criarRepositorioDeUsuarioFile(UsuarioFileRepository usuarioFileRepository, UsuarioMapper usuarioEntityMapper){
        return new UsuarioRepositoryFile(usuarioFileRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioFileRepository usuarioFileRepository() {
        return new UsuarioFileRepository();
    }

    @Bean
    UsuarioMapper usuarioEntityMapper(){
        return new UsuarioMapper();
    }

    @Bean
    CriarUsuario criarUsuario(UsuarioRepositoryFile usuarioRepository){
        return new CriarUsuario(usuarioRepository);
    }

    @Bean
    ListarUsuarios listarUsuarios(UsuarioRepositoryFile usuarioRepository){
        return new ListarUsuarios(usuarioRepository);
    }

    @Bean
    ExcluirUsuario excluirUsuario(UsuarioRepositoryFile usuarioRepository) {
        return new ExcluirUsuario(usuarioRepository);
    }

    @Bean
    AlterarUsuario alterarUsuario(UsuarioRepositoryFile usuarioRepository) {
        return new AlterarUsuario(usuarioRepository);
    }
}
