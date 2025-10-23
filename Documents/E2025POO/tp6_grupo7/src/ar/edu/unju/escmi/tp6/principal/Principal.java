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