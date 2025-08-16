package com.aluracursos.api_foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatoDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Long usuarioId,
        String curso

) {

    public DatoDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getUsuario().getId(),
                topico.getCurso()
        );
    }
}
