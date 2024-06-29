import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un procesador.
 */
public class Procesador {
    private String idProcesador;
    private String codigoProcesador;
    private boolean estaRefrigerado;
    private Integer anioFuncionamiento;
    private List<Tarea> tareasAsignadas;

    /**
     * Constructor para crear un nuevo procesador.
     * @param idProcesador Identificador del procesador.
     * @param codigoProcesador Código del procesador.
     * @param estaRefrigerado Indica si el procesador está refrigerado.
     * @param anioFuncionamiento Año de funcionamiento del procesador.
     */
    public Procesador(String idProcesador, String codigoProcesador, boolean estaRefrigerado, Integer anioFuncionamiento) {
        this.idProcesador = idProcesador;
        this.codigoProcesador = codigoProcesador;
        this.estaRefrigerado = estaRefrigerado;
        this.anioFuncionamiento = anioFuncionamiento;
        this.tareasAsignadas = new ArrayList<>();
    }

    public String getIdProcesador() {
        return idProcesador;
    }

    public String getCodigoProcesador() {
        return codigoProcesador;
    }

    public boolean getEstaRefrigerado() {
        return estaRefrigerado;
    }

    public Integer getAnioFuncionamiento() {
        return anioFuncionamiento;
    }

    /**
     * Asigna una tarea al procesador.
     * @param tarea Tarea a asignar.
     */
    public void asignarTarea(Tarea tarea) {
        tareasAsignadas.add(tarea);
    }

    /**
     * Desasigna una tarea del procesador.
     * @param tarea Tarea a desasignar.
     */
    public void desasignarTarea(Tarea tarea) {
        tareasAsignadas.remove(tarea);
    }

    /**
     * Obtiene la lista de tareas asignadas al procesador.
     * @return Lista de tareas asignadas.
     */
    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    /**
     * Obtiene el tiempo total de ejecución de todas las tareas asignadas al procesador.
     * @return Tiempo total de ejecución.
     */
    public int getTiempoTotal() {
        return tareasAsignadas.stream().mapToInt(Tarea::getTiempoEjecucion).sum();
    }

    /**
     * Obtiene el número de tareas críticas asignadas al procesador.
     * @return Número de tareas críticas.
     */
    public int getNumTareasCriticas() {
        return (int) tareasAsignadas.stream().filter(Tarea::isEsCritica).count();
    }

    /**
     * Limpia todas las tareas asignadas al procesador.
     */
    public void limpiarTareas() {
        tareasAsignadas.clear();
    }

    @Override
    public String toString() {
        return "Procesador{id='" + idProcesador + "', codigo='" + codigoProcesador + "', refrigerado=" + estaRefrigerado +
               ", anio=" + anioFuncionamiento + ", tareasAsignadas=" + tareasAsignadas + "}";
    }
}

