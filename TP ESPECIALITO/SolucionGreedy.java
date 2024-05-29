import java.util.Collections;
import java.util.List;

/**
 * Solución Greedy
 * Estrategia: Asignar cada tarea al procesador con el menor tiempo total de ejecución actual,
 * respetando las restricciones.
 */
public class SolucionGreedy {
    private List<Procesador> procesadores;
    private List<Tarea> tareas;
    private int maxTiempo;
    private int candidatosConsiderados;

    public SolucionGreedy(List<Procesador> procesadores, List<Tarea> tareas, int maxTiempo) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.maxTiempo = maxTiempo;
        this.candidatosConsiderados = 0;
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

    public void resolver() {
        for (Tarea tarea : tareas) {
            Collections.sort(procesadores, (p1, p2) -> Integer.compare(p1.getTiempoTotal(), p2.getTiempoTotal()));
            for (Procesador procesador : procesadores) {
                candidatosConsiderados++;
                if (esValidaAsignacion(procesador, tarea)) {
                    procesador.asignarTarea(tarea);
                    break;
                }
            }
        }

        System.out.println("Solución obtenida (Greedy):");
        for (Procesador procesador : procesadores) {
            System.out.println(procesador);
        }
        System.out.println("Tiempo máximo de ejecución: " + getMaxTiempo());
        System.out.println("Cantidad de candidatos considerados: " + candidatosConsiderados);
    }

    private int getMaxTiempo() {
        int max = 0;
        for (Procesador procesador : procesadores) {
            max = Math.max(max, procesador.getTiempoTotal());
        }
        return max;
    }
}
