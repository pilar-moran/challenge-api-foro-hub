package com.aluracursos.api_foro_hub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record DatoDetalleTopico(
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime fechaCreacion,
        Boolean estado,
        String autor,
        String curso
) {

    public DatoDetalleTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getUsuario().getLogin(),
                topico.getCurso()
        );
    }

}
