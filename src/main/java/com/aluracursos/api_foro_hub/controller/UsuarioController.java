package com.aluracursos.api_foro_hub.controller;

import com.aluracursos.api_foro_hub.domain.usuario.DatoRegistroUsuario;
import com.aluracursos.api_foro_hub.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody DatoRegistroUsuario datos) {
        usuarioService.registrar(datos.login(), datos.contrasena());
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}
