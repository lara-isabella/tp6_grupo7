package ar.edu.unju.escmi.tp6.exceptions;

public class LibroNoEncontradoException extends Exception {
    public LibroNoEncontradoException() {
        super("Libro solicitado no encontrado");
    }

    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
