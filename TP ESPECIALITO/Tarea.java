/**
 * Clase que representa una tarea.
 */
public class Tarea {
    private String idTarea;
    private String nombreTarea;
    private Integer tiempoEjecucion;
    private boolean esCritica;
    private Integer nivelPrioridad;

    /**
     * Constructor para crear una nueva tarea.
     * @param idTarea Identificador de la tarea.
     * @param nombreTarea Nombre de la tarea.
     * @param tiempoEjecucion Tiempo de ejecución de la tarea.
     * @param esCritica Indica si la tarea es crítica.
     * @param nivelPrioridad Nivel de prioridad de la tarea.
     */
    public Tarea(String idTarea, String nombreTarea, Integer tiempoEjecucion, boolean esCritica, Integer nivelPrioridad) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.tiempoEjecucion = tiempoEjecucion;
        this.esCritica = esCritica;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public Integer getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public boolean isEsCritica() {
        return esCritica;
    }

    public Integer getNivelPrioridad() {
        return nivelPrioridad;
    }

    @Override
    public String toString() {
        return "Tarea{id='" + idTarea + "', nombre='" + nombreTarea + "', tiempo=" + tiempoEjecucion +
                ", critica=" + esCritica + ", prioridad=" + nivelPrioridad + "}";
    }
}

