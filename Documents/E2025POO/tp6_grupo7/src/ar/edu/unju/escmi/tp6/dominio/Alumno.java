package ar.edu.unju.escmi.tp6.dominio;

public class Alumno extends Usuario {
    private String curso;
    private int numLibreta;

    //CONSTRUCTORES
    public Alumno(String curso, int numLibreta) {
        this.curso = curso;
        this.numLibreta = numLibreta;
    }

    public Alumno(int dni, String nombre, String apellido, String email, String curso, int numLibreta) {
        super(dni, nombre, apellido, email);
        this.curso = curso;
        this.numLibreta = numLibreta;
    }

    // GETTERS Y SETTERS
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getNumLibreta() {
        return numLibreta;
    }
    public void setNumLibreta(int numLibreta) {
        this.numLibreta = numLibreta;
    }

    @Override
    public String getTipoUsuario() {
        return "Alumno";
    }

    @Override
    public void mostrarDatos() {
        System.out.println("********************************************");
        System.out.println("DATOS DEL ALUMNO");
        System.out.println("Alumno: " + getNombre() + " " + getApellido());
        System.out.println("DNI: " + getDni());
        System.out.println("Email: " + getEmail());
        System.out.println("Curso: " + curso);
        System.out.println("N° Libreta: " + numLibreta);
    }
}
