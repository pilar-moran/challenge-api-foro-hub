package com.aluracursos.api_foro_hub.controller;

import com.aluracursos.api_foro_hub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DatoResumenTopico> registrar(@RequestBody @Valid DatoRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {

        var datosDeTopico = service.registrar(datos);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosDeTopico.id()).toUri();
        return ResponseEntity.created(url).body(datosDeTopico);

    }

    @GetMapping
    public ResponseEntity<Page<DatoResumenTopico>> listar(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {
        var page = service.listar(paginacion);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatoDetalleTopico> detallar(@PathVariable Long id) {
        var detalle = service.detallar(id);

        return ResponseEntity.ok(detalle);
    }

    @PutMapping("/id")
    public ResponseEntity<DatoDetalleTopico> actualizar(@PathVariable Long id, @RequestBody @Valid DatoActualizacionTopico datos) {
        var actualizado = service.actualizar(id, datos);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
