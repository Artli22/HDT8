//  @ Hoja de trabajo 8
//  @ File Name : Paciente.java
//  @ Date : 27/03/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

/**
 * Clase que representa a un paciente en el sistema de emergencias.
 * Implementa la interfaz Comparable para ordenar pacientes por prioridad.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char prioridad;

    /**
     * Constructor de la clase Paciente.
     * 
     * @param nombre    Nombre del paciente.
     * @param sintoma   Síntoma del paciente.
     * @param prioridad Nivel de prioridad del paciente (A es más urgente que B, etc.).
     */
    public Paciente(String nombre, String sintoma, char prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return Nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     * 
     * @return Síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el nivel de prioridad del paciente.
     * 
     * @return Nivel de prioridad del paciente.
     */
    public char getPrioridad() {
        return prioridad;
    }

    /**
     * Compara este paciente con otro según su nivel de prioridad.
     * 
     * @param otro Otro paciente a comparar.
     * @return Un valor negativo, cero o positivo según el orden de prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.prioridad, otro.prioridad);
    }

    /**
     * Representación en cadena del paciente.
     * 
     * @return Cadena con el nombre, síntoma y prioridad del paciente.
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + prioridad;
    }
}
