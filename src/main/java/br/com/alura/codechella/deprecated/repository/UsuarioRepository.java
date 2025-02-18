package br.com.alura.codechella.deprecated.repository;

import br.com.alura.codechella.deprecated.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
