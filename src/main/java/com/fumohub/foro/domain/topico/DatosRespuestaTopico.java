package com.fumohub.foro.domain.topico;

import lombok.Getter;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        @Getter
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        boolean status,
        String autor,
        String curso
        ) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(), topico.isStatus(), topico.getAutor(), topico.getCurso());
    }
}