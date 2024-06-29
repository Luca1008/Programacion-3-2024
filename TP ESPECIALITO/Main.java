/**
 * Clase principal para ejecutar los servicios y algoritmos de asignación de tareas a procesadores.
 */
public class Main {
    public static void main(String args[]) {
        Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");

        // Servicio 1: Obtener información de una tarea por su identificador
        System.out.println("Servicio 1: Dado un identificador de tarea obtener toda la información de la tarea asociada");
        System.out.println(servicios.servicio1("T1"));
        System.out.println("--------------------------------------------------------------------------------------------");

        // Servicio 2: Listar tareas críticas o no críticas
        System.out.println("Servicio 2: Permitir que el usuario decida si quiere ver todas las tareas críticas o no críticas y generar el listado apropiado resultante.");
        System.out.println(servicios.servicio2(false));
        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println(servicios.servicio2(true));
        System.out.println("--------------------------------------------------------------------------------------------");

        // Servicio 3: Obtener tareas entre dos niveles de prioridad
        System.out.println("Servicio 3: Obtener todas las tareas entre 2 niveles de prioridad indicados.");
        System.out.println(servicios.servicio3(40, 90));
        System.out.println("--------------------------------------------------------------------------------------------");

        // Resolver el problema de asignación de tareas utilizando backtracking
        int maxTiempo = 200; // Ejemplo de tiempo máximo para procesadores no refrigerados
        System.out.println("Resolución con Backtracking:");
        servicios.resolverBacktracking(maxTiempo);
        System.out.println("--------------------------------------------------------------------------------------------");

        // Resolver el problema de asignación de tareas utilizando greedy
        System.out.println("Resolución con Greedy:");
        servicios.resolverGreedy(maxTiempo);
    }
}



