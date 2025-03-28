//  @ Hoja de trabajo 8
//  @ File Name : LectorArchivo.java
//  @ Date : 27/03/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

/**
 * Utility class for reading patient data from a file.
 */
public class LectorArchivo {
    private String rutaArchivo;

    /**
     * Constructs a new LectorArchivo.
     * 
     * @param rutaArchivo The path to the file to read.
     */
    public LectorArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Reads the file and returns a Vector of patients.
     * 
     * @return A Vector containing all the patients read from the file.
     */
    public Vector<Paciente> leerPacientes() {
        Vector<Paciente> pacientes = new Vector<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String sintoma = partes[1];
                    char prioridad = partes[2].charAt(0);
                    pacientes.add(new Paciente(nombre, sintoma, prioridad));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return pacientes;
    }
}
