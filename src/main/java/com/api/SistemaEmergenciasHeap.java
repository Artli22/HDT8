package com.api;

import java.util.List;
import java.util.Scanner;

public class SistemaEmergenciasHeap implements SistemaEmergenciasInterface {

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
