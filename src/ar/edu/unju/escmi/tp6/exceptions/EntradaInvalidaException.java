package ar.edu.unju.escmi.tp6.exceptions;

public class EntradaInvalidaException extends Exception {

    public EntradaInvalidaException() {
        super("La entrada ingresada es invalida. Intente nuevamente.");
    }
    public EntradaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
