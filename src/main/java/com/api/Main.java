//  @ Hoja de trabajo 8
//  @ File Name : Main.java
//  @ Date : 02/04/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

import java.util.Scanner;

/**
 * Main class to run the emergency system.
 */
public class Main {

    /**
     * Main method to select and execute the emergency system implementation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación:");
        System.out.println("1. Java Collection Framework (JCF)");
        System.out.println("2. VectorHeap (HEAP)");
        System.out.print("Ingrese opción: ");
        
        String opcion = scanner.nextLine();
        String tipo = opcion.equals("1") ? "JCF" : "HEAP";

        try {
            SistemaEmergenciasInterface sistema = SistemaEmergenciasFactory.getSistema(tipo);
            sistema.ejecutar();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
