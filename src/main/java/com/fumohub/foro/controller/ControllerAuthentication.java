package com.fumohub.foro.controller;

import com.fumohub.foro.domain.usuario.DatosUsuarioAutenticacion;
import com.fumohub.foro.domain.usuario.Usuario;
import com.fumohub.foro.infra.security.DatosToken;
import com.fumohub.foro.infra.security.ServiceToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ControllerAuthentication {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ServiceToken serviceToken;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosUsuarioAutenticacion datosUsuarioAutenticacion){
        Authentication authenticationToken=new UsernamePasswordAuthenticationToken(datosUsuarioAutenticacion.username(),datosUsuarioAutenticacion.password());
        var authenticatedUser=authenticationManager.authenticate(authenticationToken);
        var jwt=serviceToken.generarToken((Usuario) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DatosToken(jwt));
    }
}
