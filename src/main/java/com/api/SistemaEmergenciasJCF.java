package com.api;

import java.util.PriorityQueue;
import java.util.List;
import java.util.Scanner;

public class SistemaEmergenciasJCF implements SistemaEmergenciasInterface {

    @Override
    public void ejecutar() {
        PriorityQueue<Paciente> cola = new PriorityQueue<>();
        LectorArchivo lector = new LectorArchivo("pacientes.txt");

        List<Paciente> pacientes = lector.leerPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("No se encontraron pacientes en el archivo.");
            return;
        }

        cola.addAll(pacientes);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Emergencias (Java Collection Framework) ===");

        while (!cola.isEmpty()) {
            Paciente siguiente = cola.poll();
            System.out.println("Atendiendo a: " + siguiente);
        }

        scanner.close();
        System.out.println("No hay más pacientes en espera.");
    }
}
