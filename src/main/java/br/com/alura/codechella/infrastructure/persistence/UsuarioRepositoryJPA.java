package br.com.alura.codechella.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryJPA extends JpaRepository<UsuarioEntity, Long> {
}
