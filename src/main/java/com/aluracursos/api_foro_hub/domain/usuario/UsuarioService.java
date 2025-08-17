package com.aluracursos.api_foro_hub.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrar(String login, String contrasena) {
        String contrasenaCodificada = passwordEncoder.encode(contrasena);
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setContrasena(contrasenaCodificada);
        return usuarioRepository.save(usuario);
    }
}


