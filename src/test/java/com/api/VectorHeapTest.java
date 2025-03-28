package com.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @Test
    void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();

        // Agregar pacientes
        heap.add(new Paciente("Juan Perez", "Dolor de cabeza", 'A'));
        heap.add(new Paciente("Maria Lopez", "Fiebre", 'B'));
        heap.add(new Paciente("Carlos Gomez", "Fractura", 'C'));

        // Verificar orden de prioridad
        assertEquals("Juan Perez", heap.remove().getNombre());
        assertEquals("Maria Lopez", heap.remove().getNombre());
        assertEquals("Carlos Gomez", heap.remove().getNombre());
    }

    @Test
    void testIsEmpty() {
        VectorHeap<Paciente> heap = new VectorHeap<>();

        // Verificar que está vacío inicialmente
        assertTrue(heap.isEmpty());

        // Agregar un paciente y verificar que ya no está vacío
        heap.add(new Paciente("Juan Perez", "Dolor de cabeza", 'A'));
        assertFalse(heap.isEmpty());

        // Remover el paciente y verificar que está vacío nuevamente
        heap.remove();
        assertTrue(heap.isEmpty());
    }
}
