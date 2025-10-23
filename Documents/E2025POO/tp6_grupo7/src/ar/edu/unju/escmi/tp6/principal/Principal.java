package ar.edu.unju.escmi.tp6.principal;

import java.util.Scanner;
import ar.edu.unju.escmi.tp6.collections.* ;
import ar.edu.unju.escmi.tp6.dominio.* ;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte op;

        do{
            System.out.println("\n******** MENU ********");
            System.out.println("1 - Registrar libro.");
            System.out.println("2 - Registrar usuario.");
            System.out.println("3 - Préstamo de libro.");
            System.out.println("4 - Devolución de libro.");
            System.out.println("5 - Listar libros.");
            System.out.println("6 - Salir");        
            System.out.print("\n\n Ingrese una opción: ");
            op = sc.nextByte();

            switch (op) {
                case 1:
                    System.out.println("Opción 1 seleccionada: REGISTRAR LIBRO");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada: REGISTRAR USUARIO");
                    System.out.println("Seleccione tipo de usuario a registrar:");
                    System.out.println("1 - Alumno");
                    System.out.println("2 - Bibliotecario");
                    System.out.print("Ingrese una opción: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("DNI: ");
                        int dni = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Curso: ");
                        String curso = sc.nextLine();
                        System.out.print("Numero de Libreta: ");
                        int numLibreta= sc.nextInt();
                        sc.nextLine();

                        Alumno nuevo = new Alumno(dni, nombre, apellido, email, curso, numLibreta);
                        CollectionUsuario.agregarUsuario(nuevo);
                        System.out.println("Alumno registrado: " + nuevo.getNombre() + nuevo.getApellido());

                    } else if (tipo == 2) {
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("DNI: ");
                        int dni = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Legajo: ");
                        int legajo = sc.nextInt();
                        sc.nextLine();

                        Bibliotecario nuevo = new Bibliotecario(dni, nombre, apellido, email, legajo);
                        CollectionUsuario.agregarUsuario(nuevo);
                        System.out.println("Bibliotecario registrado: " + nuevo.getNombre() + nuevo.getApellido());

                    } else {
                        System.out.println("Opción inválida. No se registró el usuario.");
                    }
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada: PRESTAMO DE UN LIBRO");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada: DEVOLUCION DE UN LIBRO");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada: LISTAR LIBROS");
                    break;
                case 6: 
                    System.out.println("Opción 6 seleccionada: SALIR DEL SISTEMA");
                    System.out.println("Saliendo del sistema. \n Saliendo del sistema.. \n Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida seleccionada: INTENTA DE NUEVO");
            }

            sc.close();
        } while (op != 6);
        
    }

}