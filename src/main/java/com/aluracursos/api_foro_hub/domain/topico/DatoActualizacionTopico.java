package com.aluracursos.api_foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatoActualizacionTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso
) {
}
