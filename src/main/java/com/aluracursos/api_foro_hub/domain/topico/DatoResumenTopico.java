package com.aluracursos.api_foro_hub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record DatoResumenTopico(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime fechaCreacion
) {
    public DatoResumenTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}
