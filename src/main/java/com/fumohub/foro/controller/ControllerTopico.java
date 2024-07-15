package com.fumohub.foro.controller;

import com.fumohub.foro.domain.topico.DatosRegistroTopico;
import com.fumohub.foro.domain.topico.DatosRespuestaTopico;
import com.fumohub.foro.domain.topico.ServiceTopico;
import com.fumohub.foro.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class ControllerTopico {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private ServiceTopico serviceTopico;
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaTopico datosRespuestaTopico=serviceTopico.registrarTopico(datosRegistroTopico);
        URI url=uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosRespuestaTopico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> detallarTopicoPorID(@PathVariable Long id){
        DatosRespuestaTopico datosRespuestaTopico=serviceTopico.leerTopico(id);
        return ResponseEntity.ok(datosRespuestaTopico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTodoTopicosSinResolver(@PageableDefault (size = 10)Pageable paginar){
        return ResponseEntity.ok(topicoRepository.findByStatusFalse(paginar).map(DatosRespuestaTopico::new));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity <DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        DatosRespuestaTopico datosRespuestaTopico=serviceTopico.actualizarTopico(id, datosRegistroTopico);
        return ResponseEntity.ok(datosRespuestaTopico);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        serviceTopico.eliminarTopico(id);
        return ResponseEntity.ok("Tópico eliminado de la base de datos");
    }
}
