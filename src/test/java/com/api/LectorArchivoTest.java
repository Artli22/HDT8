package com.api;

import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class LectorArchivoTest {

    @Test
    void testLeerPacientes() throws Exception {
        // Crear un archivo temporal para pruebas
        String rutaArchivo = "test_pacientes.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            writer.println("Juan Perez, Dolor de cabeza, A");
            writer.println("Maria Lopez, Fiebre, B");
            writer.println("Carlos Gomez, Fractura, C");
        }

        // Instanciar LectorArchivo y leer pacientes
        LectorArchivo lector = new LectorArchivo(rutaArchivo);
        Vector<Paciente> pacientes = lector.leerPacientes();

        // Verificar que se leyeron correctamente
        assertEquals(3, pacientes.size());
        assertEquals("Juan Perez", pacientes.get(0).getNombre());
        assertEquals("Dolor de cabeza", pacientes.get(0).getSintoma());
        assertEquals('A', pacientes.get(0).getPrioridad());
    }
}
