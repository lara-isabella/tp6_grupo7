package ar.edu.unju.escmi.tp6.exceptions;

public class PrestamoNoEncontradoException extends Exception {

    public PrestamoNoEncontradoException() {
        super("No se encontró el préstamo solicitado.");
    }

    public PrestamoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
