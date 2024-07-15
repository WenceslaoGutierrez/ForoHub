package com.fumohub.foro.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    private boolean status;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();
        this.fechaCreacion= LocalDateTime.now();
        this.status=false;
        this.autor= datosRegistroTopico.autor();
        this.curso= datosRegistroTopico.curso();
    }

    public void actualizarDatos(DatosRegistroTopico datosRegistroTopico) {
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();
        this.fechaCreacion= LocalDateTime.now();
        this.autor= datosRegistroTopico.autor();
        this.curso= datosRegistroTopico.curso();
    }
}
