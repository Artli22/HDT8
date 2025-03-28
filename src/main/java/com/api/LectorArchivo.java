package com.api;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    
    private String rutaArchivo;

    public LectorArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Lee el archivo y devuelve una lista de objetos Paciente.
     * 
     * @return List<Paciente> con todos los pacientes
     */
    public List<Paciente> leerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();

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