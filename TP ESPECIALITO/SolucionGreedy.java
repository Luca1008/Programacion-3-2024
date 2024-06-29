import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que implementa la solución de asignación de tareas a procesadores utilizando el algoritmo greedy.
 */
public class SolucionGreedy {
    private List<Procesador> procesadores;
    private List<Tarea> tareas;
    private int maxTiempo;
    private int candidatosConsiderados;

    /**
     * Constructor para inicializar la solución greedy.
     * @param procesadores Lista de procesadores disponibles.
     * @param tareas Lista de tareas a asignar.
     * @param maxTiempo Tiempo máximo de ejecución permitido para procesadores no refrigerados.
     */
    public SolucionGreedy(List<Procesador> procesadores, List<Tarea> tareas, int maxTiempo) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.maxTiempo = maxTiempo;
        this.candidatosConsiderados = 0;
    }

    /**
     * Verifica si la asignación de una tarea a un procesador es válida según las restricciones.
     * @param procesador Procesador al que se quiere asignar la tarea.
     * @param tarea Tarea que se quiere asignar.
     * @return True si la asignación es válida, false en caso contrario.
     */
    public boolean esValidaAsignacion(Procesador procesador, Tarea tarea) {
        int tiempoTotal = procesador.getTiempoTotal() + tarea.getTiempoEjecucion();
        if (!procesador.getEstaRefrigerado() && tiempoTotal > maxTiempo) {
            return false;
        }
        if (tarea.isEsCritica() && procesador.getNumTareasCriticas() >= 2) {
            return false;
        }
        return true;
    }

    /**
     * Método para resolver el problema utilizando el algoritmo greedy.
     */
    public void resolver() {
        Collections.sort(tareas, Comparator.comparingInt(Tarea::getTiempoEjecucion).reversed());

        for (Tarea tarea : tareas) {
            Collections.sort(procesadores, Comparator.comparingInt(Procesador::getTiempoTotal));

            boolean tareaAsignada = false;
            for (Procesador procesador : procesadores) {
                candidatosConsiderados++;
                if (esValidaAsignacion(procesador, tarea)) {
                    procesador.asignarTarea(tarea);
                    tareaAsignada = true;
                    break;
                }
            }
            if (!tareaAsignada) {
                System.out.println("No se pudo asignar la tarea: " + tarea);
            }
        }

        System.out.println("Solución obtenida (Greedy):");
        for (Procesador procesador : procesadores) {
            System.out.println(procesador);
        }
        System.out.println("Tiempo máximo de ejecución: " + getMaxTiempo());
        System.out.println("Cantidad de candidatos considerados: " + candidatosConsiderados);
    }

    /**
     * Calcula el tiempo máximo de ejecución entre todos los procesadores.
     * @return Tiempo máximo de ejecución.
     */
    private int getMaxTiempo() {
        int max = 0;
        for (Procesador procesador : procesadores) {
            max = Math.max(max, procesador.getTiempoTotal());
        }
        return max;
    }
}
