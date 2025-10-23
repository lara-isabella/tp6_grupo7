package ar.edu.unju.escmi.tp6.exceptions;

public class PrestamoNoEncontradoException extends Exception {

    public PrestamoNoEncontradoException() {
        super("Prestamo solicitado no encontrado");
    }

    public PrestamoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
