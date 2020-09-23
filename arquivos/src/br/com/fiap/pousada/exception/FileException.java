package br.com.fiap.pousada.exception;

public class FileException extends Exception {

    public FileException() {
        this("Problemas carregar o arquivo.");
    }

    public FileException(String msg) {
        super(msg);
    }

}
