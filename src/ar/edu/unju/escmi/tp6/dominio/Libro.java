package ar.edu.unju.escmi.tp6.dominio;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int isbn;
    public boolean estado;

    // CONSTRUCTORES
    public Libro() {
    }
    public Libro(int id, String titulo, String autor, int isbn, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = estado;
    }

    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void mostrarDatos(){
        System.out.println("********************************************");
        System.out.println("DATOS DEL LIBRO");
        System.out.println("ID en el sistema: " + id);
        System.out.println("Codigo ISBN: " + isbn);
        System.out.println("Nombre: " + titulo);
        System.out.println("Autor: " + autor);
        if (estado){
            System.out.println("Estado del libro: DISPONIBLE");
        } else {
            System.out.println("Estado del libro: NO DISPONIBLE");
        }
        System.err.println("********************************************");
    }
    
}
