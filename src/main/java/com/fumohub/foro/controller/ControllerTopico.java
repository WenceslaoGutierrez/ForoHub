package com.fumohub.foro.controller;

import com.fumohub.foro.domain.topico.DatosRegistroTopico;
import com.fumohub.foro.domain.topico.DatosRespuestaTopico;
import com.fumohub.foro.domain.topico.ServiceTopico;
import com.fumohub.foro.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class ControllerTopico {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    ServiceTopico serviceTopico;
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaTopico datosRespuestaTopico=serviceTopico.registrarTopico(datosRegistroTopico);
        URI url=uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(datosRespuestaTopico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
