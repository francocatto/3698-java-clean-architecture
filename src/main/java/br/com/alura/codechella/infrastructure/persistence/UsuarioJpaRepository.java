package br.com.alura.codechella.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findUsuarioEntityByCpf(String cpf);
}
