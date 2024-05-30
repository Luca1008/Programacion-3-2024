import java.util.List;

/**
 * Solución con Backtracking
 * Estrategia: Intentamos asignar cada tarea a cada procesador y verificamos si la asignación es válida.
 * Retrocedemos si una asignación no cumple con las restricciones.
 */
public class SolucionBacktracking {
    private List<Procesador> procesadores;  // Lista de procesadores disponibles
    private List<Tarea> tareas;  // Lista de tareas a asignar
    private int maxTiempo;  // Tiempo máximo de ejecución permitido para procesadores no refrigerados
    private int estadosGenerados;  // Contador de estados generados durante el backtracking

    public SolucionBacktracking(List<Procesador> procesadores, List<Tarea> tareas, int maxTiempo) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.maxTiempo = maxTiempo;
        this.estadosGenerados = 0;
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
     * Algoritmo de backtracking para asignar tareas a procesadores.
     */
    public boolean backtracking(int index) {
        estadosGenerados++;
        // Caso base: todas las tareas han sido asignadas
        if (index == tareas.size()) {
            return true;
        }
        Tarea tarea = tareas.get(index);
        // Intentar asignar la tarea actual a cada procesador
        for (Procesador procesador : procesadores) {
            if (esValidaAsignacion(procesador, tarea)) {
                procesador.asignarTarea(tarea);  // Asignar tarea al procesador
                if (backtracking(index + 1)) {  // Intentar asignar la siguiente tarea
                    return true;
                }
                procesador.desasignarTarea(tarea);  // Desasignar tarea si no se encontró una solución válida
            }
        }
        return false;  // No se encontró una asignación válida para la tarea actual
    }

    /**
     * Método para iniciar el proceso de backtracking y mostrar los resultados.
     */
    public void resolver() {
        if (backtracking(0)) {
            System.out.println("Solución obtenida (Backtracking):");
            for (Procesador procesador : procesadores) {
                System.out.println(procesador);
            }
            System.out.println("Tiempo máximo de ejecución: " + getMaxTiempo());
            System.out.println("Cantidad de estados generados: " + estadosGenerados);
        } else {
            System.out.println("No se encontró una solución válida.");
        }
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
