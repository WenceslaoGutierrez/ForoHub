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
        //devolver
        return null;
    }

    public void validarSiExiste(){
    }
}
