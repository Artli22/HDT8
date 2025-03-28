//  @ Hoja de trabajo 8
//  @ File Name : SistemaEmergencias.java
//  @ Date : 27/03/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

import java.util.PriorityQueue;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que simula un sistema de emergencias hospitalarias.
 * Utiliza una cola de prioridad para atender pacientes según su nivel de prioridad.
 */
public class SistemaEmergencias {

    /**
     * Método principal que ejecuta el sistema de emergencias.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crear PriorityQueue con orden basado en Comparable
        PriorityQueue<Paciente> cola = new PriorityQueue<>();
        LectorArchivo lector = new LectorArchivo("pacientes.txt");

        // Leer los pacientes desde el archivo
        List<Paciente> pacientes = lector.leerPacientes();

        // Verificar si se cargaron pacientes
        if (pacientes.isEmpty()) {
            System.out.println("No se encontraron pacientes en el archivo.");
            return;
        }

        // Agregar pacientes a la cola de prioridad
        cola.addAll(pacientes);

        // Atender pacientes
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistema de Emergencias del Hospital ===\n");

        while (!cola.isEmpty()) {
            Paciente siguiente = cola.poll(); // poll() obtiene y elimina el primer elemento
            System.out.println("Atendiendo a: " + siguiente);
        }
        scanner.close();
        System.out.println("\nNo hay más pacientes en espera.");
    }
}
