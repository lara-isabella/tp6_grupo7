package ar.edu.unju.escmi.tp6.principal;

import java.util.Scanner;
import java.time.LocalDate;

import ar.edu.unju.escmi.tp6.dominio.*;
import ar.edu.unju.escmi.tp6.utils.FechaUtil;
import ar.edu.unju.escmi.tp6.collections.*;
import ar.edu.unju.escmi.tp6.exceptions.*;

/**
 * Clase Principal: punto de entrada del sistema de préstamos de libros.
 * Controla el menú y gestiona las operaciones principales.
 */
public class Principal {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        precargarDatos(); // opcional para pruebas

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero();
            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> registrarUsuario();
                case 3 -> registrarPrestamo();
                case 4 -> registrarDevolucion();
                case 5 -> mostrarListados();
                case 6 -> System.out.println("\n👋 Programa finalizado.");
                default -> System.out.println("⚠️  Opción inválida, intente nuevamente.");
            }
        } while (opcion != 6);
    }

    // --------------------------------------------------------------------
    //  MÉTODOS DE LECTURA
    // --------------------------------------------------------------------
    public static int leerEntero() {
        while (true) {
            try {
                String linea = scanner.nextLine();
                if (linea.trim().isEmpty()) {
                    throw new EntradaInvalidaException("No se ingresó ningún valor.");
                }
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.print("⚠️  Debe ingresar un número. Intente nuevamente: ");
            } catch (EntradaInvalidaException e) {
                System.out.print("⚠️  " + e.getMessage() + " Intente nuevamente: ");
            }
        }
    }

    public static String leerCadena() {
        return scanner.nextLine();
    }

    // --------------------------------------------------------------------
    //  MENÚ PRINCIPAL
    // --------------------------------------------------------------------
    private static void mostrarMenu() {
        System.out.println("\n========= SISTEMA DE BIBLIOTECA =========");
        System.out.println("1 - Registrar libro");
        System.out.println("2 - Registrar usuario");
        System.out.println("3 - Registrar préstamo");
        System.out.println("4 - Registrar devolución");
        System.out.println("5 - Mostrar listados");
        System.out.println("6 - Salir");
        System.out.print("Seleccione una opción: ");
    }

    // --------------------------------------------------------------------
    //  REGISTRO DE LIBROS Y USUARIOS
    // --------------------------------------------------------------------
    private static void registrarLibro() {
        System.out.println("\n📚 Registrar nuevo libro");
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Título: ");
        String titulo = leerCadena();
        System.out.print("Autor: ");
        String autor = leerCadena();
        System.out.print("ISBN (número): ");
        int isbn = leerEntero();

        Libro libro = new Libro(id, titulo, autor, isbn, true);
        CollectionLibro.agregarLibro(libro);
        System.out.println("✅ Libro registrado correctamente.");
    }

    private static void registrarUsuario() {
        System.out.println("\n👤 Registrar nuevo usuario");
        System.out.print("Tipo (1-Alumno / 2-Bibliotecario): ");
        int tipo = leerEntero();

        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Nombre: ");
        String nombre = leerCadena();
        System.out.print("Apellido: ");
        String apellido = leerCadena();
        System.out.print("Email: ");
        String email = leerCadena();

        if (tipo == 1) {
            System.out.print("Curso: ");
            String curso = leerCadena();
            System.out.print("N° Libreta: ");
            int numLibreta = leerEntero();
            Alumno alumno = new Alumno(id, nombre, apellido, email, curso, numLibreta);
            CollectionUsuario.agregarUsuario(alumno);
        } else {
            System.out.print("Legajo: ");
            int legajo = leerEntero();
            Bibliotecario bibliotecario = new Bibliotecario(id, nombre, apellido, email, legajo);
            CollectionUsuario.agregarUsuario(bibliotecario);
        }
        System.out.println("✅ Usuario registrado correctamente.");
    }

    // --------------------------------------------------------------------
    //  REGISTRO DE PRÉSTAMOS Y DEVOLUCIONES
    // --------------------------------------------------------------------
    private static void registrarPrestamo() {
        System.out.println("\n📖 Registrar préstamo");

        try {
            System.out.print("ID del préstamo: ");
            int idPrestamo = leerEntero();
            System.out.print("ID del usuario: ");
            int idUsuario = leerEntero();
            System.out.print("ID del libro: ");
            int idLibro = leerEntero();
            System.out.print("Fecha del préstamo (dd/MM/yyyy): ");
            String fechaStr = leerCadena();

            Usuario usuario = CollectionUsuario.buscarUsuario(idUsuario);
            Libro libro = CollectionLibro.buscarLibros(idLibro); // puede lanzar excepciones
            LocalDate fechaPrestamo = FechaUtil.convertirStringLocalDate(fechaStr);

            Prestamo nuevo = new Prestamo(idPrestamo, fechaPrestamo, null, libro, usuario);
            CollectionPrestamo.guardarPrestamo(nuevo);
            libro.setEstado(false); // marcar como no disponible
            System.out.println("✅ Préstamo registrado correctamente.");

        } catch (UsuarioNoRegistradoException e) {
            System.out.println("⚠️  " + e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println("⚠️  " + e.getMessage());
        } catch (LibroNoDisponibleException e) {
            System.out.println("⚠️  " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️  Error inesperado: " + e.getMessage());
        }
    }

    private static void registrarDevolucion() {
        System.out.println("\n🔁 Registrar devolución");

        try {
            System.out.print("ID del préstamo: ");
            int idPrestamo = leerEntero();
            System.out.print("Fecha de devolución (dd/MM/yyyy): ");
            String fechaStr = leerCadena();

            Prestamo prestamo = CollectionPrestamo.buscarPrestamo(idPrestamo);
            LocalDate fechaDevolucion = FechaUtil.convertirStringLocalDate(fechaStr);
            prestamo.registrarDevolucion(fechaDevolucion);

            System.out.println("✅ Devolución registrada correctamente.");
        } catch (PrestamoNoEncontradoException e) {
            System.out.println("⚠️  " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️  Error al registrar la devolución: " + e.getMessage());
        }
    }

    // --------------------------------------------------------------------
    //  LISTADOS
    // --------------------------------------------------------------------
    private static void mostrarListados() {
        System.out.println("\n📋 Listados disponibles:");
        System.out.println("1 - Libros");
        System.out.println("2 - Usuarios");
        System.out.println("3 - Préstamos");
        System.out.print("Seleccione una opción: ");
        int opcion = leerEntero();

        switch (opcion) {
            case 1 -> CollectionLibro.mostrarLibros();
            case 2 -> CollectionUsuario.mostrarUsuarios();
            case 3 -> CollectionPrestamo.mostrarPrestamos();
            default -> System.out.println("Opción inválida.");
        }
    }

    // --------------------------------------------------------------------
    //  PRE-CARGA DE DATOS (opcional)
    // --------------------------------------------------------------------
    private static void precargarDatos() {
        // Precarga mínima de ejemplo (opcional)
        if (CollectionLibro.libros.isEmpty()) {
            CollectionLibro.agregarLibro(new Libro(1, "El Principito", "Antoine de Saint-Exupéry", 1111, true));
            CollectionLibro.agregarLibro(new Libro(2, "Java Básico", "Autor Anónimo", 2222, true));
        }

        if (CollectionUsuario.usuarios.isEmpty()) {
            Alumno a = new Alumno(1, "Luisana", "Pereira", "luli@ejemplo.com", "4A", 1234);
            Bibliotecario b = new Bibliotecario(2, "Yamila", "Gómez", "yami@ejemplo.com", 500);
            CollectionUsuario.agregarUsuario(a);
            CollectionUsuario.agregarUsuario(b);
        }
    }
}
