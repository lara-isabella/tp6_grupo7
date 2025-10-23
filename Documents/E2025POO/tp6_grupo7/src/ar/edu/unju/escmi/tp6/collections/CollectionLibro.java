package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unju.escmi.tp6.dominio.Libro;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoDisponibleException;
import ar.edu.unju.escmi.tp6.exceptions.LibroNoEncontradoException;

public class CollectionLibro {

    public static Map<Integer, Libro> libros = new HashMap<>();

    public static void agregarLibro(Libro libro) {
        if (libro != null) {
            libros.put(libro.getId(), libro);
        }
    }

    public static void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("⚠️  No hay libros registrados en la biblioteca.");
            return;
        }
        for (Libro l : libros.values()) {
            l.mostrarDatos();
        }
    }

    // Ahora maneja también la disponibilidad del libro
    public static Libro buscarLibros(int id) throws LibroNoEncontradoException, LibroNoDisponibleException {
        Libro encontrado = libros.get(id);

        if (encontrado == null) {
            throw new LibroNoEncontradoException("No existe un libro con el ID " + id);
        }

        // Si el libro no está disponible (estado = false), lanza la excepción correspondiente
        if (!encontrado.isEstado()) {
            throw new LibroNoDisponibleException("El libro con ID " + id + " no está disponible actualmente.");
        }

        return encontrado;
    }
}
