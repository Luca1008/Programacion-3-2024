import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Solución Greedy
 * Estrategia: Asignar cada tarea al procesador con el menor tiempo total de ejecución actual,
 * respetando las restricciones.
 */
public class SolucionGreedy {
    private List<Procesador> procesadores;  // Lista de procesadores disponibles
    private List<Tarea> tareas;  // Lista de tareas a asignar
    private int maxTiempo;  // Tiempo máximo de ejecución permitido para procesadores no refrigerados
    private int candidatosConsiderados;  // Contador de candidatos considerados durante la asignación

    public SolucionGreedy(List<Procesador> procesadores, List<Tarea> tareas, int maxTiempo) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.maxTiempo = maxTiempo;
        this.candidatosConsiderados = 0;
    }

    /**
     * Verifica si la asignación de una tarea a un procesador es válida según las restricciones.
     */
    public boolean esValidaAsignacion(Procesador procesador, Tarea tarea) {
        int tiempoTotal = procesador.getTiempoTotal() + tarea.getTiempoEjecucion();
        // Restricción 1: Procesadores no refrigerados no pueden exceder el tiempo máximo
        if (!procesador.getEstaRefrigerado() && tiempoTotal > maxTiempo) {
            return false;
        }
        // Restricción 2: Procesadores no pueden tener más de 2 tareas críticas
        if (tarea.isEsCritica() && procesador.getNumTareasCriticas() >= 2) {
            return false;
        }
        return true;
    }

    /**
     * Algoritmo greedy para asignar tareas a procesadores.
     */
    public void resolver() {
        List<Tarea> tareasAsignadas = new ArrayList<>(); // Lista de tareas ya asignadas
        
        for (Tarea tarea : tareas) {
            // Ordenar procesadores por tiempo total de ejecución actual (de menor a mayor)
            Collections.sort(procesadores, (p1, p2) -> Integer.compare(p1.getTiempoTotal(), p2.getTiempoTotal()));
            
            // Intentar asignar la tarea al procesador con el menor tiempo total de ejecución
            for (Procesador procesador : procesadores) {
                candidatosConsiderados++;
                if (esValidaAsignacion(procesador, tarea)) {
                    procesador.asignarTarea(tarea);  // Asignar tarea al procesador
                    tareasAsignadas.add(tarea);  // Añadir tarea a la lista de tareas asignadas
                    break;  // Salir del bucle una vez que la tarea ha sido asignada
                }
            }
        }

        // Eliminar tareas asignadas de la lista original de tareas
        tareas.removeAll(tareasAsignadas);

        System.out.println("Solución obtenida (Greedy):");
        for (Procesador procesador : procesadores) {
            System.out.println(procesador);
        }
        System.out.println("Tiempo máximo de ejecución: " + getMaxTiempo());
        System.out.println("Cantidad de candidatos considerados: " + candidatosConsiderados);
    }

    /**
     * Calcula el tiempo máximo de ejecución entre todos los procesadores.
     */
    private int getMaxTiempo() {
        int max = 0;
        for (Procesador procesador : procesadores) {
            max = Math.max(max, procesador.getTiempoTotal());
        }
        return max;
    }
}
