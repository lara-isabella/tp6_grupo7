package ar.edu.unju.escmi.tp6.dominio;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDev;

    //CONSTRUCTORES
    public Prestamo() {
    }
    public Prestamo(int id, LocalDate fechaPrestamo, LocalDate fechaDev) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDev = fechaDev;
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
        System.out.println("********************************************");
    }

    public void registrarDevolucion(){
        System.out.println("********************************************");
        System.out.println("Registrando devolucion...");
        this.fechaDev = LocalDate.now();
        if (libro != null) {
            libro.setEstado(true);
            System.out.println("La devolucion se ha registrado.");
        } else {
            System.out.println("No se puede registrar devolución.");
        }

    }
}
