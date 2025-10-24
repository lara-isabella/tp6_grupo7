package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDev;
    private Libro libro;
    private Usuario usuario;

    //CONSTRUCTORES
    public Prestamo() {
    }
    public Prestamo(int id, LocalDate fechaPrestamo, LocalDate fechaDev, Libro libro, Usuario usuario) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDev = fechaDev;
        this.libro = libro;
        this.usuario = usuario;
    }

    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public LocalDate getFechaDev() {
        return fechaDev;
    }
    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void mostrarDatos() {
        System.out.println("********************************************");
        System.out.println("DATOS DEL PRESTAMO");
        System.out.println("Codigo de Prestamo: " + id);
        System.out.println("Fecha de Prestamo: " + fechaPrestamo);
        System.out.println("Fecha de devolucion: ");
        if (fechaDev == null) {
            System.out.println("El libro no ha sido devuelto.");
        } else {
            System.out.println(fechaDev);
        }
        if (libro != null) {
            System.out.println("Libro: " + libro.getTitulo());
        }
        if (usuario != null) {
            System.out.println("Usuario: " + usuario.getNombre());
        }
        System.out.println("********************************************");
    }

    public void registrarDevolucion(LocalDate fechaDevolucion){
        System.out.println("********************************************");
        System.out.println("Registrando devolucion...");
        if (fechaDevolucion.isBefore(fechaPrestamo)) {
    System.out.println("⚠️ La fecha de devolución no puede ser anterior a la fecha de préstamo.");
    return;
}
        this.fechaDev = fechaDevolucion;
        if (libro != null) {
            libro.setEstado(true);
            System.out.println("La devolucion se ha registrado.");
        } else {
            System.out.println("No se puede registrar devolución.");
        }

    }
}
