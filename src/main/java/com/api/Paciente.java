//  @ Hoja de trabajo 8
//  @ File Name : Paciente.java
//  @ Date : 27/03/2025
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

package com.api;

/**
 * Represents a patient with a name, symptom, and priority level.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char prioridad;

    /**
     * Constructs a new Paciente.
     * 
     * @param nombre    The name of the patient.
     * @param sintoma   The symptom of the patient.
     * @param prioridad The priority level of the patient.
     */
    public Paciente(String nombre, String sintoma, char prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    /**
     * Gets the name of the patient.
     * 
     * @return The name of the patient.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets the symptom of the patient.
     * 
     * @return The symptom of the patient.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Gets the priority level of the patient.
     * 
     * @return The priority level of the patient.
     */
    public char getPrioridad() {
        return prioridad;
    }

    /**
     * Compares this patient to another based on priority.
     * 
     * @param otro The other patient to compare to.
     * @return A negative integer, zero, or a positive integer as this patient's
     *         priority is less than, equal to, or greater than the other patient's
     *         priority.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.prioridad, otro.prioridad);
    }

    /**
     * Returns a string representation of the patient.
     * 
     * @return A string containing the patient's name, symptom, and priority.
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + prioridad;
    }
}
