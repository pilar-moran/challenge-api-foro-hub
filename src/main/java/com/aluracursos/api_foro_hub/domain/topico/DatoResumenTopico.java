package com.aluracursos.api_foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatoResumenTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
    public DatoResumenTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
