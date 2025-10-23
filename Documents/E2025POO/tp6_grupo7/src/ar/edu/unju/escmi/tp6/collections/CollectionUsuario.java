package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp6.dominio.Usuario;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();

    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void mostrarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("- " + u.getNombre() + " " + u.getApellido() + " (DNI: " + u.getDni() + ")");
        }
    }
}