import java.util.List;

/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {
     private Tree<Tarea> tareas;
     private Tree<Procesador> procesadores;
	/*
     * Expresar la complejidad temporal del constructor.
     * Posee la complejidad de en el peor de los casos en que arbol este desbalanceado
     * la complejidad seria O(n2 + m2)
     */
	public Servicios(String pathProcesadores, String pathTareas){
          procesadores = new Tree<>();
          tareas = new Tree<>();
		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores, procesadores);
		reader.readTasks(pathTareas, tareas);
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1.
     * Dado un identificador de tarea obtener toda la información de la tarea asociada
     La complejidad temporal de esta implementación es O(h), en donde hs la altura del árbol,
     en el peor de los casos h 0 n por lo que la complejidad en O(n),
     pero si esta balanceado la complejidad pasa a ser O(log n)
     */
	public Tarea servicio1(String ID) {
          return tareas.get(ID);
     }
    
    /*
     * Expresar la complejidad temporal del servicio 2.
     * Permitir que el usuario decida si quiere ver todas las tareas críticas o no críticas y generar
     el listado apropiado resultante.
     La complejidad temporal de esta implementación es O(n),
     ya que se realiza una búsqueda en profundidad (DFS) y se visita cada nodo del árbol una vez.
     */
	public List<Tarea> servicio2(boolean esCritica) {
          List<Tarea> criticas = tareas.getCriticas(esCritica);
          return criticas;
     }

    /*
     * Expresar la complejidad temporal del servicio 3.
     * Obtener todas las tareas entre 2 niveles de prioridad indicados.
     La complejidad temporal de esta implementación también es o(n),
     a que se realiza una búsqueda en profundidad (DFS) y se visita cada nodo del árbol una vez.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
          List<Tarea> conPrioridad = tareas.getTareasEntrePrioridades(prioridadInferior, prioridadSuperior);
          return conPrioridad;
     }

     // Método para resolver el problema utilizando backtracking
     public void resolverBacktracking(int maxTiempo) {
          List<Procesador> listaProcesadores = procesadores.getAll();
          List<Tarea> listaTareas = tareas.getAll();

          SolucionBacktracking solucion = new SolucionBacktracking(listaProcesadores, listaTareas, maxTiempo);
          solucion.resolver();
 }

 // Método para resolver el problema utilizando greedy
     public void resolverGreedy(int maxTiempo) {
          List<Procesador> listaProcesadores = procesadores.getAll();
          List<Tarea> listaTareas = tareas.getAll();

          SolucionGreedy solucion = new SolucionGreedy(listaProcesadores, listaTareas, maxTiempo);
          solucion.resolver();
 }

}
