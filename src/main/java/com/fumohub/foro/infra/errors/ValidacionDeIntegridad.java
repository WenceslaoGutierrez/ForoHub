package com.fumohub.foro.infra.errors;

public class ValidacionDeIntegridad extends RuntimeException{
    public ValidacionDeIntegridad (String s){
        super(s);
    }
}
