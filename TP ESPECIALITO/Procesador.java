public class Procesador {
    private String idProcesador;
    private String codigoProcesador;
    private boolean estaRefrigerado;
    private Integer anioFuncionamiento;

    public Procesador(String idProcesador, String codigoProcesador, boolean estaRefrigerado, Integer anioFuncionamiento) {
        this.idProcesador = idProcesador;
        this.codigoProcesador = codigoProcesador;
        this.estaRefrigerado = estaRefrigerado;
        this.anioFuncionamiento = anioFuncionamiento;
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
    
    
}
