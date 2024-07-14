package com.fumohub.foro.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTopico {
    @Autowired
    private TopicoRepository topicoRepository;
    public DatosRespuestaTopico registrarTopico(DatosRegistroTopico datosRegistroTopico){
        //validar
        //crear
        Topico topico=topicoRepository.save(new Topico(datosRegistroTopico));
        //devolver
        return new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(), topico.isStatus(), topico.getAutor(),topico.getCurso());
    }

    public void validarSiExiste(){
    }
}
