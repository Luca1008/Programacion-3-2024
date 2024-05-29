import java.util.List;

/**
 * Solución con Backtracking
 * Estrategia: Intentamos asignar cada tarea a cada procesador y verificamos si la asignación es válida.
 * Retrocedemos si una asignación no cumple con las restricciones.
 */
public class SolucionBacktracking {
    private List<Procesador> procesadores;
    private List<Tarea> tareas;
    private int maxTiempo;
    private int estadosGenerados;

    public SolucionBacktracking(List<Procesador> procesadores, List<Tarea> tareas, int maxTiempo) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.maxTiempo = maxTiempo;
        this.estadosGenerados = 0;
    }

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

    public boolean backtracking(int index) {
        estadosGenerados++;
        if (index == tareas.size()) {
            return true;
        }
        Tarea tarea = tareas.get(index);
        for (Procesador procesador : procesadores) {
            if (esValidaAsignacion(procesador, tarea)) {
                procesador.asignarTarea(tarea);
                if (backtracking(index + 1)) {
                    return true;
                }
                procesador.desasignarTarea(tarea);
            }
        }
        return false;
    }

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

    private int getMaxTiempo() {
        int max = 0;
        for (Procesador procesador : procesadores) {
            max = Math.max(max, procesador.getTiempoTotal());
        }
        return max;
    }
}
