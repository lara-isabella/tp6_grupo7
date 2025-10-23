package ar.edu.unju.escmi.tp6.principal;

import java.util.Scanner;
import ar.edu.unju.escmi.tp6.collections.*;
import ar.edu.unju.escmi.tp6.dominio.*;

public class Principal {
    
    static Scanner sc = new Scanner(System.in);

    byte op;

    do {
        System.out.println("\n******** MENU ********");
        System.out.println("1 - Registrar libro.");
        System.out.println("2 - Registrar usuario.");
        System.out.println("3 - Préstamo de libro.");
        System.out.println("4 - Devolución de libro.");
        System.out.println("5 - Listar libros.");
        System.out.println("6 - Salir");        
        System.out.print("\n\n Ingrese una opción: ");
        op = sc.nextByte();
        sc.nextLine();

        switch (op) {

        }
    } while (op != 6);

}
