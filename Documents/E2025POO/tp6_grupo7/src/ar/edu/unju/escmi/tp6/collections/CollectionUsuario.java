package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp6.dominio.Usuario;
import ar.edu.unju.escmi.tp6.exceptions.UsuarioNoRegistradoException;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static Usuario buscarUsuario(int dni) throws UsuarioNoRegistradoException {
        for (Usuario u : usuarios) {
            if (u.getDni() == dni) {
                return u;
            }
        }
        throw new UsuarioNoRegistradoException("No se encontró un usuario con el ID " + dni);
    }

    public static void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("- " + u.getNombre() + " " + u.getApellido() + " (DNI: " + u.getDni() + ")");
        }
    }
}