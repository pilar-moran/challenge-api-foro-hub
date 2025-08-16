package com.aluracursos.api_foro_hub.domain.topico;

import com.aluracursos.api_foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;

    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public DatoResumenTopico registrar(DatoRegistroTopico datos) {

        if (!usuarioRepository.existsById(datos.usuarioId())) {
            throw new ValidacionExcepcion("El ID del usuario no se encuentra en la base de datos.");
        }

        var autor = usuarioRepository.getReferenceById(datos.usuarioId());
        var topico = new Topico(datos, autor);

        topicoRepository.save(topico);

        return new DatoResumenTopico(topico);

    }

    public Page<DatoResumenTopico> listar(Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatoResumenTopico::new);
    }


    public DatoDetalleTopico detallar(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ValidacionExcepcion("No se encontró el tópico con id: " + id));
        return new DatoDetalleTopico(topico);
    }

    @Transactional
    public DatoDetalleTopico actualizar(Long id, @Valid DatoActualizacionTopico datos) {
        var optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()) {
            throw new ValidacionExcepcion("No se encontró el tópico con id: " + id);
        }

        var topico = optionalTopico.get();

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setCurso(datos.curso());

        return new DatoDetalleTopico(topico);
    }

    public void eliminar(Long id) {
        var optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isEmpty()) {
            throw new ValidacionExcepcion("No se encontró el tópico con id: " + id);
        }

        var topico = optionalTopico.get();

        topico.setEstado(false);
    }
}
