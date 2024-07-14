package com.fumohub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DatosRespuestaTopico(
         Long id,
         String titulo,
         String mensaje,
         Date fechaCreacion,
         boolean status,
         String autor,
         String curso
        ) {
}