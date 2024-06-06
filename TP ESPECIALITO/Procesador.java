import java.util.ArrayList;
import java.util.List;

public class Procesador {
    private String idProcesador;
    private String codigoProcesador;
    private boolean estaRefrigerado;
    private Integer anioFuncionamiento;
    private List<Tarea> tareasAsignadas;

    public Procesador(String idProcesador, String codigoProcesador, boolean estaRefrigerado, Integer anioFuncionamiento) {
        this.idProcesador = idProcesador;
        this.codigoProcesador = codigoProcesador;
        this.estaRefrigerado = estaRefrigerado;
        this.anioFuncionamiento = anioFuncionamiento;
        this.tareasAsignadas = new ArrayList<>();
    }

    public Procesador() {
    }


    public String getIdProcesador() {
        return idProcesador;
    }
    public void setIdProcesador(String idProcesador) {
        this.idProcesador = idProcesador;
    }

    public String getCodigoProcesador() {
        return codigoProcesador;
    }
    public void setCodigoProcesador(String codigoProcesador) {
        this.codigoProcesador = codigoProcesador;
    }

    public boolean getEstaRefrigerado() {
        return estaRefrigerado;
    }
    public void setEstaRefrigerado(boolean estaRefrigerado) {
        this.estaRefrigerado = estaRefrigerado;
    }

    public Integer getAnioFuncionamiento() {
        return anioFuncionamiento;
    }
    public void setAnioFuncionamiento(Integer anioFuncionamiento) {
        this.anioFuncionamiento = anioFuncionamiento;
    }

    public void asignarTarea(Tarea tarea) {
        tareasAsignadas.add(tarea);
    }

    public void desasignarTarea(Tarea tarea) {
        tareasAsignadas.remove(tarea);
    }
    
    public int getTiempoTotal() {
        return tareasAsignadas.stream().mapToInt(Tarea::getTiempoEjecucion).sum();
    }

    public int getNumTareasCriticas() {
        return (int) tareasAsignadas.stream().filter(Tarea::isEsCritica).count();
    }

     // Método para vaciar la lista de tareas
     public void limpiarTareas() {
        tareasAsignadas.clear();
    }
    

    @Override
    public String toString() {
        return "Procesador{id='" + idProcesador + "', codigo='" + codigoProcesador + "', refrigerado=" + estaRefrigerado + 
               ", anio=" + anioFuncionamiento + ", tareasAsignadas=" + tareasAsignadas + "}";
    }
}
