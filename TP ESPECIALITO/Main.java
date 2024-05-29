public class Main {

	public static void main(String args[]) {
		Servicios servicios = new Servicios("datasets/Procesadores.csv", "datasets/Tareas.csv");
		

			//------------------Servicio 1--------------------------------
			System.out.println("Servicio 1: Dado un identificador de tarea obtener toda la informacion de la tarea asociada");
			System.out.println(servicios.servicio1("T1"));
			
			System.out.println("--------------------------------------------------------------------------------------------");
			
//------------------Servicio 2--------------------------------			System.out.println("Servicio 2: Permitir que el usuario decida si quiere ver todas las tareas criticas o no criticas y generar el listado apropiado resultante.");
			System.out.println(servicios.servicio2(false));

			System.out.println("--------------------------------------------------------------------------------------------");

			System.out.println(servicios.servicio2(true));


			System.out.println("--------------------------------------------------------------------------------------------");
//------------------Servicio 3--------------------------------			System.out.println("Servicio 3; Obtener todas las tareas entre 2 niveles de prioridad indicados.");
			System.out.println(servicios.servicio3(10,90));

			System.out.println("--------------------------------------------------------------------------------------------");

			int maxTiempo = 100; // Ejemplo de tiempo máximo para procesadores no refrigerados
			System.out.println("Resolución con Backtracking:");
			servicios.resolverBacktracking(maxTiempo);

			System.out.println("--------------------------------------------------------------------------------------------");

			System.out.println("Resolución con Greedy:");
			servicios.resolverGreedy(maxTiempo);
	}
}



