import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la solución de asignación de tareas a procesadores utilizando el algoritmo de backtracking.
 */
public class SolucionBacktracking {
    private List<Procesador> procesadores;
    private List<Tarea> tareas;
    private int maxTiempo;
    private int estadosGenerados;
    private List<Procesador> mejorSolucion;
    private int mejorTiempoTotal;

    /**
     * Constructor para inicializar la solución de backtracking.
     * @param procesadores Lista de procesadores disponibles.
     * @param tareas Lista de tareas a asignar.
     * @param maxTiempo Tiempo máximo de ejecución permitido para procesadores no refrigerados.
     */
    public SolucionBacktracking(List<Procesador> procesadores, List<Tarea> tareas, int maxTiempo) {
        this.procesadores = procesadores;
        this.tareas = tareas;
        this.maxTiempo = maxTiempo;
        this.estadosGenerados = 0;
        this.mejorSolucion = null;
        this.mejorTiempoTotal = Integer.MAX_VALUE;
    }

    /**
     * Verifica si la asignación de una tarea a un procesador es válida según las restricciones.
     * @param procesador Procesador al que se quiere asignar la tarea.
     * @param tarea Tarea que se quiere asignar.
     * @return True si la asignación es válida, false en caso contrario.
     */
    public boolean esValidaAsignacion(Procesador procesador, Tarea tarea) {
        // Calcula el tiempo total si se asigna la tarea al procesador
        int tiempoTotal = procesador.getTiempoTotal() + tarea.getTiempoEjecucion();
        
        // Verifica si el procesador no refrigerado excede el tiempo máximo permitido
        if (!procesador.getEstaRefrigerado() && tiempoTotal > maxTiempo) {
            return false;
        }
        
        // Verifica si el procesador tiene más de 2 tareas críticas asignadas
        if (tarea.isEsCritica() && procesador.getNumTareasCriticas() >= 2) {
            return false;
        }
        
        return true;
    }

    /**
     * Algoritmo de backtracking para asignar tareas a procesadores.
     * @param index Índice de la tarea actual a asignar.
     */
    public void backtracking(int index) {
        estadosGenerados++;
        
        // Caso base: todas las tareas han sido asignadas
        if (index == tareas.size()) {
            int tiempoTotal = getMaxTiempo();
            // Actualiza la mejor solución si se encuentra una mejor
            if (tiempoTotal < mejorTiempoTotal) {
                mejorTiempoTotal = tiempoTotal;
                mejorSolucion = deepCopy(procesadores);
            }
            return;
        }
        
        Tarea tarea = tareas.get(index);
        
        // Intentar asignar la tarea actual a cada procesador
        for (Procesador procesador : procesadores) {
            if (esValidaAsignacion(procesador, tarea)) {
                procesador.asignarTarea(tarea);  // Asignar tarea al procesador
                
                backtracking(index + 1);  // Llamada recursiva para asignar la siguiente tarea
                
                procesador.desasignarTarea(tarea);  // Desasignar tarea si no se encuentra una solución válida
            }
        }
    }

    /**
     * Realiza una copia profunda de la lista de procesadores.
     * @param procesadores Lista de procesadores a copiar.
     * @return Copia profunda de la lista de procesadores.
     */
    private List<Procesador> deepCopy(List<Procesador> procesadores) {
        List<Procesador> copia = new ArrayList<>();
        
        // Realiza una copia profunda de cada procesador y sus tareas asignadas
        for (Procesador procesador : procesadores) {
            Procesador nuevoProcesador = new Procesador(procesador.getIdProcesador(), procesador.getCodigoProcesador(),
                    procesador.getEstaRefrigerado(), procesador.getAnioFuncionamiento());
            
            for (Tarea tarea : procesador.getTareasAsignadas()) {
                nuevoProcesador.asignarTarea(new Tarea(tarea.getIdTarea(), tarea.getNombreTarea(), tarea.getTiempoEjecucion(),
                        tarea.isEsCritica(), tarea.getNivelPrioridad()));
            }
            
            copia.add(nuevoProcesador);
        }
        
        return copia;
    }

    /**
     * Método para resolver el problema utilizando backtracking.
     */
    public void resolver() {
        backtracking(0);  // Inicia el backtracking desde la primera tarea
        
        if (mejorSolucion != null) {
            System.out.println("Solución obtenida (Backtracking):");
            
            for (Procesador procesador : mejorSolucion) {
                System.out.println(procesador);
            }
            
            System.out.println("Tiempo máximo de ejecución: " + mejorTiempoTotal);
            System.out.println("Cantidad de estados generados: " + estadosGenerados);
        } else {
            System.out.println("No se encontró una solución válida.");
        }
    }

    /**
     * Calcula el tiempo máximo de ejecución entre todos los procesadores.
     * @return Tiempo máximo de ejecución.
     */
    private int getMaxTiempo() {
        int max = 0;
        
        // Encuentra el tiempo máximo de ejecución entre todos los procesadores
        for (Procesador procesador : procesadores) {
            max = Math.max(max, procesador.getTiempoTotal());
        }
        
        return max;
    }
}

