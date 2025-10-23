package ar.edu.unju.escmi.tp6.dominio;

public class Usuario {
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String email;

    //CONSTRUCTORES
    public Usuario() {
    }

    public Usuario(int dni, String nombre, String apellido, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // GETTERS Y SETTERS
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUsuario() {
        return "Usuario";
    }

    public void mostrarDatos(){
        System.out.println("********************************************");
        System.out.println("DATOS DEL USUARIO");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre Completo: " + apellido + ", " + nombre);
        System.out.println("Correo electronico: " + email);
    }
}
