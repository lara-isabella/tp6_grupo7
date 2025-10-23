package ar.edu.unju.escmi.tp6.collections;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unju.escmi.tp6.dominio.Prestamo;
import ar.edu.unju.escmi.tp6.exceptions.PrestamoNoEncontradoException;

public class CollectionPrestamo {

    // Mapa que guarda todos los préstamos registrados
    public static Map<Integer, Prestamo> prestamos = new HashMap<>();

    // Guarda un nuevo préstamo
    public static void guardarPrestamo(Prestamo prestamo) {
        if (prestamo != null) {
            prestamos.put(prestamo.getId(), prestamo);
        }
    }

    // Devuelve un préstamo por su ID, o lanza una excepción si no existe
      public static Prestamo buscarPrestamo(int id) throws PrestamoNoEncontradoException {
        Prestamo encontrado = prestamos.get(id);
        if (encontrado == null) {
            throw new PrestamoNoEncontradoException("No existe préstamo con el ID " + id);
        }
        return encontrado;
    }
    // Muestra todos los préstamos registrados
    public static void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos cargados actualmente.");
            return;
        }
        for (Prestamo p : prestamos.values()) {
            p.mostrarDatos();
        }
    }
}
