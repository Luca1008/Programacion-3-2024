/**
 * Clase principal para ejecutar los servicios y algoritmos de asignación de tareas a procesadores.
 */
public class Main {
    public static void main(String args[]) {
        
        //con Tarea1
        Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas1.csv");
        
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

        
        int maxTiempo = 200; // Ejemplo de tiempo máximo para procesadores no refrigerados
        int maxTiempo2 = 10; // Ejemplo de tiempo máximo para procesadores no refrigerados

        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando backtracking
        System.out.println("Servicio 1 tiempo 1 Resolución con Backtracking:");
        servicios.resolverBacktracking(maxTiempo);
        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando greedy
        System.out.println("Servicio 1 tiempo 1 Resolución con Greedy:");
        servicios.resolverGreedy(maxTiempo);
        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando backtracking
        System.out.println("Servicio 1 tiempo 2 Resolución con Backtracking:");
        servicios.resolverBacktracking(maxTiempo2);
        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando greedy
        System.out.println("Servicio 1 tiempo 2 Resolución con Greedy:");
        servicios.resolverGreedy(maxTiempo2);
        System.out.println("--------------------------------------------------------------------------------------------");






        //con Tarea2
        Servicios servicios2 = new Servicios("datasets/Procesadores.csv", "datasets/Tareas2.csv");
        
        // Servicio 1: Obtener información de una tarea por su identificador
        System.out.println("Servicio 1: Dado un identificador de tarea obtener toda la información de la tarea asociada");
        System.out.println(servicios2.servicio1("T1"));
        System.out.println("--------------------------------------------------------------------------------------------");

        // Servicio 2: Listar tareas críticas o no críticas
        System.out.println("Servicio 2: Permitir que el usuario decida si quiere ver todas las tareas críticas o no críticas y generar el listado apropiado resultante.");
        System.out.println(servicios2.servicio2(false));
        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println(servicios2.servicio2(true));
        System.out.println("--------------------------------------------------------------------------------------------");

        // Servicio 3: Obtener tareas entre dos niveles de prioridad
        System.out.println("Servicio 3: Obtener todas las tareas entre 2 niveles de prioridad indicados.");
        System.out.println(servicios2.servicio3(40, 90));
        System.out.println("--------------------------------------------------------------------------------------------");

        
        int maxTiempo3 = 200; // Ejemplo de tiempo máximo para procesadores no refrigerados
        int maxTiempo4 = 100; // Ejemplo de tiempo máximo para procesadores no refrigerados
        int maxTiempo5 = 80; // Ejemplo de tiempo máximo para procesadores no refrigerados

        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando backtracking
        System.out.println("Servicio 2 tiempo 1 Resolución con Backtracking:");
        servicios2.resolverBacktracking(maxTiempo3);
        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando greedy
        System.out.println("Servicio 2 tiempo 1 Resolución con Greedy:");
        servicios2.resolverGreedy(maxTiempo3);
        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando backtracking
        System.out.println("Servicio 2 tiempo 2 Resolución con Backtracking:");
        servicios2.resolverBacktracking(maxTiempo4);
        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando greedy
        System.out.println("Servicio 2 tiempo 2 Resolución con Greedy:");
        servicios2.resolverGreedy(maxTiempo4);
        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando backtracking
        System.out.println("Servicio 2 tiempo 3 Resolución con Backtracking:");
        servicios2.resolverBacktracking(maxTiempo5);
        System.out.println("--------------------------------------------------------------------------------------------");
        // Resolver el problema de asignación de tareas utilizando greedy
        System.out.println("Servicio 2 tiempo 3 Resolución con Greedy:");
        servicios2.resolverGreedy(maxTiempo5);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}



