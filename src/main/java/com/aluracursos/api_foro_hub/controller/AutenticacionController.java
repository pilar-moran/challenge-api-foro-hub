package com.aluracursos.api_foro_hub.controller;

import com.aluracursos.api_foro_hub.domain.usuario.DatoAutenticacion;
import com.aluracursos.api_foro_hub.domain.usuario.Usuario;
import com.aluracursos.api_foro_hub.infra.security.DatoTokenJWT;
import com.aluracursos.api_foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<DatoTokenJWT> iniciarSesion(@RequestBody @Valid DatoAutenticacion datos) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
            var autenticacion = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
            return ResponseEntity.ok(new DatoTokenJWT(tokenJWT));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
