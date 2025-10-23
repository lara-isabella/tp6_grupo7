package ar.edu.unju.escmi.tp6.exceptions;

public class UsuarioNoRegistradoException extends Exception {
    public UsuarioNoRegistradoException() {
        super("El usuario no se encuentra en el sistema");
    }

    public UsuarioNoRegistradoException(String mensaje) {
        super(mensaje);
    }
}
