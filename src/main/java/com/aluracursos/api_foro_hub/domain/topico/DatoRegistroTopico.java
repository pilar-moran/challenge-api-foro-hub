package com.aluracursos.api_foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatoRegistroTopico(
        @NotNull
        Long usuarioId,
        @NotBlank(message = "Titulo es obligatorio")
        String titulo,
        @NotBlank(message = "Mensaje es obligatorio")
        String mensaje,
        @NotBlank(message = "Curso es obligatorio")
        String curso
) {
}
