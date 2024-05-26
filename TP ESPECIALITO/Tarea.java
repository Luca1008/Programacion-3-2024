public class Tarea {
    private String idTarea;
    private String nombreTarea;
    private Integer tiempoEjecucion;
    private boolean esCritica;
    private Integer nivelPrioridad;

    public Tarea() {
    }

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


    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
    public void setTiempoEjecucion(Integer tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }
    public void setEsCritica(boolean esCritica) {
        this.esCritica = esCritica;
    }
    public void setNivelPrioridad(Integer nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
    

    @Override
    public String toString() {
        return "Tarea{" +
                "id='" + idTarea + '\'' +
                ", nombre='" + nombreTarea + '\'' +
                ", tiempo=" + tiempoEjecucion +
                ", critica=" + esCritica +
                ", prioridad=" + nivelPrioridad +
                '}';
    }
}
