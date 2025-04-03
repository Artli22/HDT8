//  @ Hoja de trabajo 8
//  @ File Name : SistemaEmergenciasHeap.java
//  @ Date : 02/04/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

import java.util.List;
import java.util.Scanner;

/**
 * Implementation of SistemaEmergenciasInterface using a VectorHeap.
 */
public class SistemaEmergenciasHeap implements SistemaEmergenciasInterface {

    /**
     * Executes the emergency system using a VectorHeap.
     */
    @Override
    public void ejecutar() {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        LectorArchivo lector = new LectorArchivo("pacientes.txt");

        List<Paciente> pacientes = lector.leerPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("No se encontraron pacientes en el archivo.");
            return;
        }

        for (Paciente p : pacientes) {
            cola.add(p);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Emergencias (VectorHeap) ===");

        while (!cola.isEmpty()) {
            Paciente siguiente = cola.remove();
            System.out.println("Atendiendo a: " + siguiente);
        }

        scanner.close();
        System.out.println("No hay más pacientes en espera.");
    }
}
