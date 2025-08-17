package com.aluracursos.api_foro_hub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);
}
