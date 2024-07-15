package com.fumohub.foro.domain.topico;

import com.fumohub.foro.infra.errors.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTopico {
    @Autowired
    private TopicoRepository topicoRepository;
    //Create
    public DatosRespuestaTopico registrarTopico(DatosRegistroTopico datosRegistroTopico){
        //validar
        validarDuplicidad(datosRegistroTopico);
        //crear
        Topico topico=topicoRepository.save(new Topico(datosRegistroTopico));
        //devolver
        return new DatosRespuestaTopico(topico);
    }
    //Read
    public DatosRespuestaTopico leerTopico(Long id){
        validarSiExiste(id);
        Topico topico= topicoRepository.getReferenceById(id);
        return new DatosRespuestaTopico(topico);
    }
    //Update
    public DatosRespuestaTopico actualizarTopico(Long id, DatosRegistroTopico datosRegistroTopico){
        validarSiExiste(id);
        Topico topico=topicoRepository.getReferenceById(id);
        validarDuplicidad(datosRegistroTopico);
        topico.actualizarDatos(datosRegistroTopico);
        return new DatosRespuestaTopico(topico);
    }
    //Delete
    public void eliminarTopico(Long id){
        validarSiExiste(id);
        topicoRepository.deleteById(id);
    }

    public void validarDuplicidad(DatosRegistroTopico datosRegistroTopico){
        if (topicoRepository.existsByTitulo(datosRegistroTopico.titulo())){
            throw new ValidacionDeIntegridad("Ya existe un tópico con ese título, por favor modifíquelo");
        }
        if (topicoRepository.existsByMensaje(datosRegistroTopico.mensaje())){
            throw new ValidacionDeIntegridad("Ya existe un tópico con ese mensaje, por favor modifíquelo");
        }
    }
    public void validarSiExiste(Long id){
        if (topicoRepository.findById(id).isEmpty()){
            throw new ValidacionDeIntegridad("ID del tópico no encontrado");
        }
    }
}
