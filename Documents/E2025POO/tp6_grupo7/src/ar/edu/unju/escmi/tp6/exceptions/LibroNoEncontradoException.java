package ar.edu.unju.escmi.tp6.exceptions;

public class LibroNoEncontradoException extends Exception {
    public LibroNoEncontradoException() {
        super("No se ha encontrado el libro solicitado.");
    }

    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
