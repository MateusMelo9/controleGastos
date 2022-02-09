package com.dev.controleGastos.service.exception;

public class CategoriaJaCadastradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public CategoriaJaCadastradoException(String message) {
        super(message);
    }
}
