import java.util.*;

/**
 * Clase que proporciona servicios para manipular tareas y procesadores.
 */
public class Servicios {
     private Tree<Tarea> tareas;
     private Tree<Procesador> procesadores;
     private HashMap<String, Tarea> tareaMap;
     private List<Tarea> tareasCriticas;
     private List<Tarea> tareasNoCriticas;
     private TreeMap<Integer, List<Tarea>> prioridadMap;

     /**
      * Constructor que carga datos desde archivos CSV.
      * 
      * @param pathProcesadores Ruta del archivo CSV de procesadores.
      * @param pathTareas       Ruta del archivo CSV de tareas.
      */
     public Servicios(String pathProcesadores, String pathTareas) {
          this.procesadores = new Tree<>();
          this.tareas = new Tree<>();
          this.tareaMap = new HashMap<>();
          this.tareasCriticas = new ArrayList<>();
          this.tareasNoCriticas = new ArrayList<>();
          this.prioridadMap = new TreeMap<>();

          CSVReader reader = new CSVReader();
          reader.readProcessors(pathProcesadores, procesadores, new HashMap<>());
          reader.readTasks(pathTareas, tareas, tareaMap);

          for (Tarea tarea : tareaMap.values()) {
               if (tarea.isEsCritica()) {
                    tareasCriticas.add(tarea);
               } else {
                    tareasNoCriticas.add(tarea);
               }
               int prioridad = tarea.getNivelPrioridad();
               prioridadMap.putIfAbsent(prioridad, new ArrayList<>());
               prioridadMap.get(prioridad).add(tarea);
          }
     }

     /**
      * Servicio 1: Dado un identificador de tarea obtener toda la información de la
      * tarea asociada.
      * Complejidad: O(1) debido a la búsqueda en el HashMap.
      * 
      * @param ID Identificador de la tarea.
      * @return Tarea asociada al identificador.
      */
     public Tarea servicio1(String ID) {
          return tareaMap.get(ID);
     }

     /**
      * Servicio 2: Permitir que el usuario decida si quiere ver todas las tareas
      * críticas o no críticas
      * y generar el listado apropiado resultante.
      * Complejidad: O(1) para devolver la lista correspondiente.
      * 
      * @param esCritica Indica si se desean listar tareas críticas (true) o no
      *                  críticas (false).
      * @return Lista de tareas críticas o no críticas.
      */
     public List<Tarea> servicio2(boolean esCritica) {
          return esCritica ? tareasCriticas : tareasNoCriticas;
     }

     /**
      * Servicio 3: Obtener todas las tareas entre 2 niveles de prioridad indicados.
      * Complejidad: O(log n + k) donde n es el número de prioridades distintas y k
      * el número de tareas en el rango.
      * 
      * @param prioridadInferior Límite inferior del rango de prioridad.
      * @param prioridadSuperior Límite superior del rango de prioridad.
      * @return Lista de tareas en el rango de prioridad.
      */
     public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
          List<Tarea> resultado = new ArrayList<>();
          NavigableMap<Integer, List<Tarea>> subMap = prioridadMap.subMap(prioridadInferior, true, prioridadSuperior,
                    true);
          for (List<Tarea> listaTareas : subMap.values()) {
               resultado.addAll(listaTareas);
          }
          return resultado;
     }

     /**
      * Resuelve el problema de asignación de tareas a procesadores utilizando el
      * algoritmo de backtracking.
      * 
      * @param maxTiempo Tiempo máximo de ejecución permitido para procesadores no
      *                  refrigerados.
      */
     public void resolverBacktracking(int maxTiempo) {
          List<Procesador> listaProcesadores = procesadores.getAll();
          List<Tarea> listaTareas = new ArrayList<>(tareaMap.values());
          for (Procesador procesador : listaProcesadores) {
               procesador.limpiarTareas();
          }
          SolucionBacktracking solucion = new SolucionBacktracking(listaProcesadores, listaTareas, maxTiempo);
          solucion.resolver();
     }

     /**
      * Resuelve el problema de asignación de tareas a procesadores utilizando el
      * algoritmo greedy.
      * 
      * @param maxTiempo Tiempo máximo de ejecución permitido para procesadores no
      *                  refrigerados.
      */
     public void resolverGreedy(int maxTiempo) {
          List<Procesador> listaProcesadores = procesadores.getAll();
          List<Tarea> listaTareas = new ArrayList<>(tareaMap.values());
          for (Procesador procesador : listaProcesadores) {
               procesador.limpiarTareas();
          }
          SolucionGreedy solucion = new SolucionGreedy(listaProcesadores, listaTareas, maxTiempo);
          solucion.resolver();
     }
}
