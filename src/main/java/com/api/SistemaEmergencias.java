import java.util.Scanner;
import java.util.Vector;

public class SistemaEmergencias {

    public static void main(String[] args) {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        LectorArchivo lector = new LectorArchivo("pacientes.txt");

        // Leer los pacientes desde el archivo
        Vector<Paciente> pacientes = lector.leerPacientes();

        // Verificar si se cargaron pacientes
        if (pacientes.isEmpty()) {
            System.out.println("No se encontraron pacientes en el archivo.");
            return;
        }

        // Agregar pacientes a la cola de prioridad
        for (Paciente p : pacientes) {
            cola.add(p);
        }

        // Atender pacientes
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistema de Emergencias del Hospital\n");

        while (!cola.isEmpty()) {
            System.out.println("Siguiente paciente en ser atendido: " + cola.remove());
        }
        scanner.close();
        System.out.println("\nNo hay más pacientes en espera.");
    }
}
