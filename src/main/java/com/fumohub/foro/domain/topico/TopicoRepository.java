package com.fumohub.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    boolean existsByTitulo(String titulo);
    boolean existsByMensaje(String mensaje);
    Page <Topico> findByStatusFalse(Pageable page);

}
