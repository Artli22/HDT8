package com.api;

import java.util.Scanner;

public class Main {
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
