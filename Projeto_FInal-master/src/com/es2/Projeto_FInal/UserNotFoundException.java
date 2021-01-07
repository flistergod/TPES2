package com.es2.Projeto_FInal;


public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Utilizador nao encontrado");
    }
}
