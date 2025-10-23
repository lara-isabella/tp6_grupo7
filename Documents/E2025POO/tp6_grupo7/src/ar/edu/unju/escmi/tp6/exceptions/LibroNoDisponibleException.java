package ar.edu.unju.escmi.tp6.exceptions;

public class LibroNoDisponibleException extends Exception {
    public LibroNoDisponibleException() {
        super("El libro seleccionado no se encuentra disponible.");
    }
    public LibroNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
