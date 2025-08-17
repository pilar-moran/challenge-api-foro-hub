package com.aluracursos.api_foro_hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatoAutenticacion(
        @NotBlank
        String login,
        @NotBlank
        String contrasena
) {
}
