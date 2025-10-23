package ar.edu.unju.escmi.tp6.dominio;

public class Bibliotecario extends Usuario {
    private int legajo;

    //CONSTRUCTORES
    public Bibliotecario(int legajo) {
        this.legajo = legajo;
    }

    public Bibliotecario(int dni, String nombre, String apellido, String email, int legajo) {
        super(dni, nombre, apellido, email);
        this.legajo = legajo;
    }

    //GETTERS Y SETTERS
    public int getLegajo() {
        return legajo;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    
}
